package com.godlife_study.back.service;

import org.springframework.http.ResponseEntity;

import com.godlife_study.back.dto.request.studyService.PostStudyNoticeRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyNoticeRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife_study.back.dto.response.studyService.GetStudyResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyNoticeResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyTodoListRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyTodoListRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.GetStudyUserListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyUserListResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyTodoListResponseDto;

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
}
