package com.godlife_study.back.dto.response.studyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PostStudyMaterialResponseDto extends ResponseDto {
    
    private PostStudyMaterialResponseDto(String code, String messsage){
        super(code, messsage);
    }
    
    public static ResponseEntity<PostStudyMaterialResponseDto> success(){
        PostStudyMaterialResponseDto result = new PostStudyMaterialResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }      
}
