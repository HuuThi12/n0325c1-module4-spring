package com.techzen.academy_n0325c1.exception;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import com.techzen.academy_n0325c1.dto.student.StudentRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // nơi để lắng nge lỗi trả về
public class GlobalExeptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException e) {
        Errorcode errorcode = e.getErrorcode();

        return ResponseEntity.status(errorcode.getStatus()).body(
                ApiResponse.builder()
                        .code(errorcode.getCode())
                        .message(e.getMessage())
                        .build()
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
