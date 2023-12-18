package com.godlife_study.back.dto.response.studyService;




import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife_study.back.common.StudyTodoListItem;
import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;
import com.godlife_study.back.repository.resultSet.StudyTodoListResultSet;

import lombok.Getter;

@Getter
public class GetStudyTodoListResponseDto extends ResponseDto{
    
    private List<StudyTodoListItem> todoList;

    private GetStudyTodoListResponseDto(String code, String message, List<StudyTodoListResultSet> resultSets){
        super(code, message);
        this.todoList = StudyTodoListItem.getTodoList(resultSets);
    }

    public static ResponseEntity<GetStudyTodoListResponseDto> success(List<StudyTodoListResultSet> resultSets){
        GetStudyTodoListResponseDto result = new GetStudyTodoListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistToDoList(){
        ResponseDto result = new ResponseDto( ResponseCode.NOT_EXIST_TODOLIST, ResponseMessage.NOT_EXIST_TODOLIST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
