package com.godlife_study.back.service;

import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.response.studyService.GetStudyResponseDto;

import com.godlife_study.back.dto.response.studyService.GetStudyUserListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyUserListResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyNoticeRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyNoticeRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyNoticeResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyTodoListRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyTodoListRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyTodoListResponseDto;
import com.godlife_study.back.dto.request.studyService.PostStudyMaterialRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyMaterialListResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyMaterialResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyMaterialResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyMaterialCommentRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyMaterialCommentRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyMaterialCommentListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyMaterialCommentResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyMaterialCommentResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyMaterialCommentResponseDto;

public interface StudyService {
    ResponseEntity<? super GetStudyResponseDto> getStudy(Integer studyNumber,String userEmail);
    ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail);
    ResponseEntity<? super PostStudyUserListResponseDto> postStudyUserList(String userEmail, Integer studyNumber, String studyGrade);
    ResponseEntity<? super GetStudyNoticeListResponseDto> getNoticeList(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(PostStudyNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber);        
    ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(PatchStudyNoticeRequestDto dto ,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(String createStudyUserEmail, Integer studyNumber, Integer studyNoticeNumber);

    ResponseEntity<? super GetStudyTodoListResponseDto> getTodoList(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostStudyTodoListResponseDto> postTodoList(PostStudyTodoListRequestDto dto,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodoList(PatchStudyTodoListRequestDto dto,String createStudyUserEmail, Integer studyNumber);
    ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodoList(String createStudyUserEmail, Integer studyNumber, Integer studyTodoListNumber);

    ResponseEntity<? super GetStudyMaterialListResponseDto> getMaterialList(String userEmail,Integer studyNumber);
    ResponseEntity<? super PostStudyMaterialResponseDto> postMaterial(PostStudyMaterialRequestDto dto ,String createStudyUserEmail,Integer studyNumber);
    ResponseEntity<? super DeleteStudyMaterialResponseDto> deleteMaterial(String createStudyUserEmail,Integer studyNumber,Integer studyMaterialNumber);

    ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialCommentList(String userEmail,Integer studyNumber,Integer studyMaterialNumber);    
    ResponseEntity<? super PostStudyMaterialCommentResponseDto> postMaterialComment(PostStudyMaterialCommentRequestDto dto, String userEmail,Integer studyNumber,Integer studyMaterialNumber);
    ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(PatchStudyMaterialCommentRequestDto dto, String userEmail, Integer studyNumber, Integer studyMaterialNumber);    
    ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterialComment(String createStudyUserEmail,Integer studyNumber,Integer studyMaterialNumber,Integer studyMaterialCommentNumber);

}
