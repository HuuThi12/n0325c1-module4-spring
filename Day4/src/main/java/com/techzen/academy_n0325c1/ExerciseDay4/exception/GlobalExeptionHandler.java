package com.techzen.academy_n0325c1.ExerciseDay4.exception;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // nơi lắng nge lỗi trả về
public class GlobalExeptionHandler {
    @ExceptionHandler(AppExepciton.class)
    public ResponseEntity<?> handleAppExeption(AppExepciton exepciton) {
        Errorcode errorcode = exepciton.getErrorcode();

        return ResponseEntity.status(errorcode.getStatusCode()).body(
                ApiResponse.builder()
                        .code(errorcode.getCode())
                        .message(errorcode.getMessage())
                        .build()
        );
    }

}
