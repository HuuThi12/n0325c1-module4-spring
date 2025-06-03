package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.IntrospectRequest;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.IntrospectResponse;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.LoginRequest;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.LoginResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.model.User;
import com.techzen.academy_n0325c1.Bai9.repository.IUserRepository;
import com.techzen.academy_n0325c1.Bai9.service.IAuthenticateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticateService implements IAuthenticateService {
    @NonFinal
    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;

    IUserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws AppException {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        if (user == null
                || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AppException(Errorcode.UNAUTHORIZED);
        }
        return LoginResponse.builder()
                .token(generateToken(loginRequest.getUsername()))
                .build();
    }

    public boolean verifyJWT(String token)
            throws JOSEException, ParseException {
        // Tạo một đối tượng JWSVerifier với thuật toán HMAC SHA-512 để xác minh chữ ký của JWT
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        // Phân tích cú pháp (parse) chuỗi JWT thành đối tượng SignedJWT
        SignedJWT signedJWT = SignedJWT.parse(token);

        // Lấy thời gian hết hạn của JWT từ phần claims (payload)
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        // Xác minh chữ ký của JWT, kiểm tra xem chữ ký có hợp lệ không
        var verified = signedJWT.verify(verifier);

        // Trả về kết quả xác thực:

        return verified && expiryTime.after(new Date());
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        return IntrospectResponse.builder()
                .isValid(verifyJWT(introspectRequest.getToken()))
                .build();
    }

    // Phương thức generateToken tạo ra một JWT token với thông tin người dùng
    private String generateToken(String username) {
        // Tạo phần header cho JWT, sử dụng thuật toán ký là HS512 (HMAC SHA-512)
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        // Tạo phần claims (payload) cho JWT, chứa các thông tin về người dùng
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username) // Đặt chủ thể (subject) của JWT là tên đăng nhập của người dùng
                .issuer("sqc.com") // Đặt người phát hành JWT là "sqc.com"
                .issueTime(new Date()) // Đặt thời gian phát hành JWT là thời điểm hiện tại
                .expirationTime(new Date( // Đặt thời gian hết hạn cho JWT là 1 giờ kể từ lúc phát hành
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                // Thêm một custom claim (thông tin tùy chỉnh) vào JWT, chứa thông tin về đối tượng Student
                .claim("student", "Thi")
                .build(); // Xây dựng đối tượng JWTClaimsSet

        // Tạo payload từ claims đã tạo, chuyển đối tượng claims thành định dạng JSON
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        // Tạo JWSObject từ header và payload, kết hợp chúng lại thành đối tượng JWS
        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            // Ký JWT bằng thuật toán HMAC SHA-512, sử dụng khóa bí mật (SIGNER_KEY)
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

            // Chuyển đối tượng JWS thành chuỗi JWT hoàn chỉnh (header.payload.signature) và trả về
            return jwsObject.serialize();
        } catch (JOSEException e) {
            // Nếu có lỗi xảy ra trong quá trình ký JWT, ném ra ngoại lệ RuntimeException
            throw new RuntimeException(e);
        }
    }
}
