package com.godlife_study.back.dto.response.studyService;

import com.godlife_study.back.common.object.StudyUserListItem;
import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;
import com.godlife_study.back.repository.resultSet.StudyUserListResultSet;

import lombok.Getter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetStudyUserListResponseDto extends ResponseDto{
    List<StudyUserListItem> studyUserList;

    private GetStudyUserListResponseDto(String code, String message, List<StudyUserListResultSet> resultSets) {
        super(code, message);
        this.studyUserList = StudyUserListItem.getStudyUserList(resultSets);
    }    

    public static ResponseEntity<GetStudyUserListResponseDto> success(List<StudyUserListResultSet> resultSets) {
        GetStudyUserListResponseDto result = new GetStudyUserListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistStudy() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_STUDY, ResponseMessage.NOT_EXIST_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }    

}
