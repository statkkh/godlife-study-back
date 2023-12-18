package com.godlife_study.back.dto.response.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;

public class PostStudyResponseDto  extends ResponseDto{
    private PostStudyResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PostStudyResponseDto> success() {
        PostStudyResponseDto result = new PostStudyResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
