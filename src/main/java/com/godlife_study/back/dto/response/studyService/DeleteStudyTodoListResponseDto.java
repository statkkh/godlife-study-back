package com.godlife_study.back.dto.response.studyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class DeleteStudyTodoListResponseDto extends ResponseDto{
    
    private DeleteStudyTodoListResponseDto(String code , String message){
        super(code, message);
    }

    public static ResponseEntity<DeleteStudyTodoListResponseDto> success(){
        DeleteStudyTodoListResponseDto result = new DeleteStudyTodoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
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

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistTodo(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_TODOLIST, ResponseMessage.NOT_EXIST_TODOLIST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
