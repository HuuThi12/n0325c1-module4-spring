package com.techzen.academy_n0325c1.Bai9.service;



import com.nimbusds.jose.JOSEException;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.IntrospectRequest;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.IntrospectResponse;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.LoginRequest;
import com.techzen.academy_n0325c1.Bai9.dto.authenticate.LoginResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;

import java.text.ParseException;

public interface IAuthenticateService {
    LoginResponse login(LoginRequest loginRequest) throws AppException;


    IntrospectResponse introspect(IntrospectRequest introspectRequest) throws ParseException, JOSEException;
}
