package com.godlife_study.back.service;

import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.request.auth.SignInEmailCheckRequestDto;
import com.godlife_study.back.dto.request.auth.SignInRequestDto;
import com.godlife_study.back.dto.request.auth.SignUpRequestDto;
import com.godlife_study.back.dto.response.auth.SignInEmailcheckResponseDto;
import com.godlife_study.back.dto.response.auth.SignInResponseDto;
import com.godlife_study.back.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignInEmailcheckResponseDto> signInEmailCheck(SignInEmailCheckRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

}
