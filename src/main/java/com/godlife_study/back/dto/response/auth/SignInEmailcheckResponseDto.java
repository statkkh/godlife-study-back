package com.godlife_study.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInEmailcheckResponseDto  extends ResponseDto{
    
    private SignInEmailcheckResponseDto(String code ,String message){
        super(code, message);
    }

    public static ResponseEntity<SignInEmailcheckResponseDto> success() {
        SignInEmailcheckResponseDto result = new SignInEmailcheckResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    
}
