package com.techzen.academy_n0325c1.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Errorcode {
    KHACH_HANG_NOT_EXITS(40401, "Khách hàng không tồn tại!", HttpStatus.NOT_FOUND),
    GIAO_DICH_NOT_EXITS(40402, "Giao dịch không tồn tại!", HttpStatus.NOT_FOUND);

    int code;
    String message;
    HttpStatus status;

}
