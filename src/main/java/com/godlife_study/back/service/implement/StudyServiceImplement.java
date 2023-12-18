package com.godlife_study.back.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife_study.back.dto.response.ResponseDto;

import com.godlife_study.back.dto.request.studyService.PatchStudyNoticeRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyTodoListRequestDto;
import com.godlife_study.back.dto.request.studyService.PostStudyNoticeRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyNoticeResponseDto;

import com.godlife_study.back.dto.request.studyService.PostStudyTodoListRequestDto;
import com.godlife_study.back.dto.request.studyService.PatchStudyTodoListRequestDto;

import com.godlife_study.back.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife_study.back.dto.response.studyService.DeleteStudyTodoListResponseDto;


import com.godlife_study.back.entity.StudyEntity;
import com.godlife_study.back.entity.StudyNoticeEntity;
import com.godlife_study.back.entity.StudyTodoListEntity;

import com.godlife_study.back.repository.UserRepository;
import com.godlife_study.back.repository.StudyRepository;
import com.godlife_study.back.repository.StudyNoticeRepository;
import com.godlife_study.back.repository.StudyTodoListRepository;

import com.godlife_study.back.repository.resultSet.StudyNoticeListResultSet;
import com.godlife_study.back.repository.resultSet.StudyTodoListResultSet;
import com.godlife_study.back.service.StudyService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService {

    private final UserRepository userRepository;

    private final StudyRepository studyRepository;

    private final StudyNoticeRepository studyNoticeRepository;

    @Override
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNoticeList(String userEmail, Integer studyNumber) {

        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();

        try {
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetStudyNoticeListResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyNoticeListResponseDto.notExistStudy();        
            
            resultSets = studyNoticeRepository.findByNoticeList(studyNumber);            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStudyNoticeListResponseDto.success(resultSets);
    }




}

