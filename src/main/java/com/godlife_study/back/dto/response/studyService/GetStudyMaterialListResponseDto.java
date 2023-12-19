package com.godlife_study.back.dto.response.studyService;

import com.godlife_study.back.common.object.StudyMaterialListItem;
import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;
import com.godlife_study.back.repository.resultSet.StudyMaterialListResultSet;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import lombok.Getter;

@Getter
public class GetStudyMaterialListResponseDto extends ResponseDto{

    private List<StudyMaterialListItem> materialList;

    private GetStudyMaterialListResponseDto(String code, String message, List<StudyMaterialListResultSet> resultSets){
        super(code, message); 
        this.materialList = StudyMaterialListItem.getMaterialList(resultSets);
    }
    
    public static ResponseEntity<GetStudyMaterialListResponseDto> success(List<StudyMaterialListResultSet> resultSets){
        GetStudyMaterialListResponseDto result = new GetStudyMaterialListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
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
