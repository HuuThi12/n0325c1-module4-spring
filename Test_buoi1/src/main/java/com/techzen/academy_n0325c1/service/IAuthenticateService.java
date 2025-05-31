package com.techzen.academy_n0325c1.service;

import com.techzen.academy_n0325c1.dto.authenticate.LoginRequest;
import com.techzen.academy_n0325c1.dto.authenticate.LoginResponse;
import com.techzen.academy_n0325c1.exception.AppException;

public interface IAuthenticateService {
    LoginResponse login(LoginRequest loginRequest) throws AppException;

}
