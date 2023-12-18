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
public class SignUpResponseDto extends ResponseDto{
    
    private SignUpResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<SignUpResponseDto> success() {
        SignUpResponseDto result = new SignUpResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> duplicateUserEmail() {
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_EMAIL, ResponseMessage.DUPLICATED_EMAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> duplicateUserNickname() {
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_NICKNAME, ResponseMessage.DUPLICATED_NICKNAME);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> duplicateUserFavorite1() {
        ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_FAVORITE1, ResponseMessage.DUPLICATED_FAVORITE1);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
