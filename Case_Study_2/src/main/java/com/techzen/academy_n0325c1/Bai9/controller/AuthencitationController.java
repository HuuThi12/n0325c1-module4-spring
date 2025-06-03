package com.techzen.academy_n0325c1.Bai9.controller;

import com.nimbusds.jose.JOSEException;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.IntrospectRequest;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.LoginRequest;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.service.impl.AuthenticateService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthencitationController {
    private final AuthenticateService authenticateService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws AppException {
        return ResponseEntity.ok(authenticateService.login(loginRequest));
    }

    @GetMapping("/introspect")
    public ResponseEntity<?> introspect(@RequestBody IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        return ResponseEntity.ok(authenticateService.introspect(introspectRequest));
    }


}
