package com.godlife_study.back.dto.response.studyService;

import com.godlife_study.back.common.object.StudyNoticeListItem;
import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;
import com.godlife_study.back.repository.resultSet.StudyNoticeListResultSet;

import lombok.Getter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetStudyNoticeListResponseDto  extends ResponseDto{
    
    private List<StudyNoticeListItem> noticeList; 

    private GetStudyNoticeListResponseDto(String code , String message, List<StudyNoticeListResultSet> resultSets){
        super(code, message);
        this.noticeList = StudyNoticeListItem.getNoticeList(resultSets);
    }

    public static ResponseEntity<GetStudyNoticeListResponseDto> success( List<StudyNoticeListResultSet> resultSets){
        GetStudyNoticeListResponseDto result = new GetStudyNoticeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
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

