package com.godlife_study.back.dto.response.studyService;

import com.godlife_study.back.common.object.StudyMaterialCommentListItem;
import com.godlife_study.back.dto.response.ResponseCode;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.ResponseMessage;
import com.godlife_study.back.repository.resultSet.StudyMaterialCommentListResultSet;

import lombok.Getter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetStudyMaterialCommentListResponseDto extends ResponseDto{

    private List<StudyMaterialCommentListItem> materialCommentList; 

    private GetStudyMaterialCommentListResponseDto(String code, String message, List<StudyMaterialCommentListResultSet> resultSets ) {
        super(code, message);
        this.materialCommentList = StudyMaterialCommentListItem.getMaterialCommentList(resultSets);      
    }  

    public static ResponseEntity<GetStudyMaterialCommentListResponseDto> success(List<StudyMaterialCommentListResultSet> resultSets){
        GetStudyMaterialCommentListResponseDto result = new GetStudyMaterialCommentListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
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

    public static ResponseEntity<ResponseDto> notExistMaterial(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_MATERIAL, ResponseMessage.NOT_EXIST_MATERIAL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
    }   
}
