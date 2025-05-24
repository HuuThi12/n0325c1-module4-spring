package com.techzen.academy_n0325c1.exception;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // nơi lắng nge lỗi trả về
public class GlobalExeptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppExeption(AppException exepciton) {
        Errorcode errorcode = exepciton.getErrorcode();

        return ResponseEntity.status(errorcode.getStatus()).body(
                ApiResponse.builder()
                        .code(errorcode.getCode())
                        .message(errorcode.getMessage())
                        .build()
        );
    }

}
