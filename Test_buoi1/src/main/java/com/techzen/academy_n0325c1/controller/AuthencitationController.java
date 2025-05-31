package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.authenticate.LoginRequest;
import com.techzen.academy_n0325c1.exception.AppException;
import com.techzen.academy_n0325c1.service.AuthenticateService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
