package com.godlife_study.back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


import com.godlife_study.back.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyServiceController {
    
    private final StudyService studyService;

    @GetMapping("/{studyNumber}/notice")
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNoticeList(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super GetStudyNoticeListResponseDto> response = studyService.getNoticeList(userEmail,studyNumber);
        return response;
    }    

    @PostMapping("/{studyNumber}/notice")
    public ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(
        @RequestBody @Valid PostStudyNoticeRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PostStudyNoticeResponseDto> response = studyService.postNotice(requestBody,createStudyUserEmail,studyNumber);
        return response;
    }

    @PatchMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(
        @RequestBody @Valid PatchStudyNoticeRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super PatchStudyNoticeResponseDto> response = studyService.patchNotice(requestBody,createStudyUserEmail, studyNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super DeleteStudyNoticeResponseDto> deletNotice(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber
    ) {
        ResponseEntity<? super DeleteStudyNoticeResponseDto> response = studyService.deleteNotice(createStudyUserEmail,studyNumber, studyNoticeNumber);
        return response;
    }
    
    @GetMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodoList(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super GetStudyTodoListResponseDto> response = studyService.getTodolist(userEmail, studyNumber);
        return response;
    }

    @PostMapping("/{studyNumber}/todo-list")
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodo(
        @RequestBody @Valid PostStudyTodoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PostStudyTodoListResponseDto> response = studyService.postTodo(requestBody,createStudyUserEmail,studyNumber);
        return response;
    }

    @PatchMapping("/{studyNumber}/todo-list/{studyListNumber}")
    public ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodo(
        @RequestBody @Valid PatchStudyTodoListRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PatchStudyTodoListResponseDto> response = studyService.patchTodo(requestBody,createStudyUserEmail,studyNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/todo-list/{studyListNumber}")
    public ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodo(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyListNumber") Integer studyListNumber
    ){
        ResponseEntity<? super DeleteStudyTodoListResponseDto> response = studyService.deleteTodo(createStudyUserEmail,studyNumber,studyListNumber);
        return response;
    }
}
