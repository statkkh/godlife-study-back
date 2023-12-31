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

import com.godlife_study.back.dto.response.studyService.PostStudyMaterialResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyMaterialCommentResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyMaterialResponseDto;
import com.godlife_study.back.dto.response.studyService.GetStudyMaterialListResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyMaterialCommentRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyMaterialCommentRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyMaterialCommentListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyMaterialCommentResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyMaterialCommentResponseDto;

import com.godlife_study.back.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class StudyServiceController {
    
    private final StudyService studyService;

    @GetMapping("/{studyNumber}")
    ResponseEntity<? super GetStudyResponseDto> getStudy(
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String userEmail) 
    {
        ResponseEntity<? super GetStudyResponseDto> response = studyService.getStudy(studyNumber, userEmail);
        return response;
    }    

    @GetMapping("/{studyNumber}/study-user-list")
    public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(
        @PathVariable("studyNumber") Integer studyNumber,
        @AuthenticationPrincipal String userEmail) {
        ResponseEntity<? super GetStudyUserListResponseDto> response = studyService.getStudyUserList(studyNumber,userEmail);
        return response;
    }

    @PostMapping("/{studyNumber}/study-user-list/{studyGrade}")
    public ResponseEntity<? super PostStudyUserListResponseDto> postStudyUserList(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyGrade") String studyGrade
    ){
        ResponseEntity<? super PostStudyUserListResponseDto> response = studyService.postStudyUserList(createStudyUserEmail,studyNumber,studyGrade);
        return response;
    }

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
        @RequestBody @Valid  PostStudyNoticeRequestDto dto,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super PostStudyNoticeResponseDto> response = studyService.postNotice(dto,createStudyUserEmail,studyNumber);
        return response;
    }
        
    @PatchMapping("/{studyNumber}/notice")
    public ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(
        @RequestBody @Valid PatchStudyNoticeRequestDto dto,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PatchStudyNoticeResponseDto> response = studyService.patchNotice(dto,createStudyUserEmail,studyNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/notice/{studyNoticeNumber}")
    public ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyNoticeNumber") Integer studyNoticeNumber
    ){
        ResponseEntity<? super DeleteStudyNoticeResponseDto> response = studyService.deleteNotice(createStudyUserEmail,studyNumber,studyNoticeNumber);
        return response;
    }

    @GetMapping("/{studyNumber}/todoList")
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodoList(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super GetStudyTodoListResponseDto> response = studyService.getTodoList(userEmail,studyNumber);
        return response;
    }

    @PostMapping("/{studyNumber}/todolist")
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodoList(
        @RequestBody @Valid PostStudyTodoListRequestDto dto,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PostStudyTodoListResponseDto> response = studyService.postTodoList(dto,createStudyUserEmail,studyNumber);
        return response;
    }

    @PatchMapping("/{studyNumber}/todolist")
    public ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodoList(
        @RequestBody @Valid PatchStudyTodoListRequestDto dto,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ){
        ResponseEntity<? super PatchStudyTodoListResponseDto> response = studyService.patchTodoList(dto,createStudyUserEmail,studyNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/todolist/{studyTodoListNumber}")
    public ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodoList(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyTodoListNumber") Integer studyTodoListNumber
    ){
        ResponseEntity<? super DeleteStudyTodoListResponseDto> response = studyService.deleteTodoList(createStudyUserEmail,studyNumber,studyTodoListNumber);
        return response;
    }   


    @GetMapping("{studyNumber}/material")
    public ResponseEntity<? super GetStudyMaterialListResponseDto> getMaterialList(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super GetStudyMaterialListResponseDto> response = studyService.getMaterialList(userEmail,studyNumber);
        return response;
    }

    @PostMapping("{studyNumber}/material")
    public ResponseEntity<? super PostStudyMaterialResponseDto> postMaterial(
        @RequestBody @Valid PostStudyMaterialRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber
    ) {
        ResponseEntity<? super PostStudyMaterialResponseDto> response = studyService.postMaterial(requestBody,createStudyUserEmail, studyNumber);
        return response;
    }    

    @DeleteMapping("/{studyNumber}/material/{studyMaterialNumber}")
    public ResponseEntity<? super DeleteStudyMaterialResponseDto> deleteMaterial(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyMaterialNumber") Integer studyMaterialNumber
    ) {
        ResponseEntity<? super DeleteStudyMaterialResponseDto> response = studyService.deleteMaterial(createStudyUserEmail, studyNumber, studyMaterialNumber);
        return response;
    }


    @GetMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super GetStudyMaterialCommentListResponseDto> getMaterialComment(
        @AuthenticationPrincipal String userEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyMaterialNumber") Integer studyMaterialNumber
    ) {
        ResponseEntity<? super GetStudyMaterialCommentListResponseDto> response = studyService.getMaterialCommentList(userEmail, studyNumber, studyMaterialNumber);
        return response;
    }


    @PostMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super PostStudyMaterialCommentResponseDto> postMaterialComment(
        @RequestBody @Valid PostStudyMaterialCommentRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyMaterialNumber") Integer studyMaterialNumber
    ){
        ResponseEntity<? super PostStudyMaterialCommentResponseDto> response = studyService.postMaterialComment(requestBody,createStudyUserEmail, studyNumber, studyMaterialNumber);
        return response;
    }

    @PatchMapping("/{studyNumber}/{studyMaterialNumber}/material-comment")
    public ResponseEntity<? super PatchStudyMaterialCommentResponseDto> patchMaterialComment(
        @RequestBody @Valid PatchStudyMaterialCommentRequestDto requestBody,
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyMaterialNumber") Integer studyMaterialNumber
    ){
        ResponseEntity<? super PatchStudyMaterialCommentResponseDto> response = studyService.patchMaterialComment(requestBody,createStudyUserEmail, studyNumber, studyMaterialNumber);
        return response;
    }

    @DeleteMapping("/{studyNumber}/{studyMaterialNumber}/material-comment/{studyMaterialCommentNumber}")
    public ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> deleteMaterialComment(
        @AuthenticationPrincipal String createStudyUserEmail,
        @PathVariable("studyNumber") Integer studyNumber,
        @PathVariable("studyMaterialNumber") Integer studyMaterialNumber,
        @PathVariable("studyMaterialCommentNumber") Integer studyMaterialCommentNumber
    ) {
        ResponseEntity<? super DeleteStudyMaterialCommentResponseDto> response = studyService.deleteMaterialComment(createStudyUserEmail, studyNumber, studyMaterialNumber,studyMaterialCommentNumber);
        return response;
    }    

}
