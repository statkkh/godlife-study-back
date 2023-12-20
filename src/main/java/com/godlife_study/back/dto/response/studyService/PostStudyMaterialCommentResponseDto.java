package com.godlife_study.back.dto.response.studyService;

import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@Getter
public class PostStudyMaterialCommentResponseDto extends ResponseDto{

    private PostStudyMaterialCommentResponseDto(String code, String message) {
        super(code, message);
    }
    
    public static ResponseEntity<PostStudyMaterialCommentResponseDto> success() {
        PostStudyMaterialCommentResponseDto result = new PostStudyMaterialCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }    
    
    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

    public static ResponseEntity<ResponseDto> notExistStudy() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
}
