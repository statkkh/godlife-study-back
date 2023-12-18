package com.godlife_study.back.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife_study.back.dto.response.ResponseDto;

import com.godlife_study.back.dto.request.studyService.PatchStudyNoticeRequestDto;
import com.godlife_study.back.dto.request.studyService.PostStudyNoticeRequestDto;

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

    @Override
    public ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(PostStudyNoticeRequestDto dto, String createStudyUserEmail, Integer studyNumber) {
        
        try {
            
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PostStudyNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostStudyNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostStudyNoticeResponseDto.noPermission();
                        

            StudyNoticeEntity studyNoticeEntity = new StudyNoticeEntity(dto,studyNumber);
            studyNoticeRepository.save(studyNoticeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostStudyNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(PatchStudyNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber) {


        try {
            
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PatchStudyNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PatchStudyNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchStudyNoticeResponseDto.noPermission();

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(dto.getStudyNoticeNumber());
            if( studyNoticeEntity == null) return PatchStudyNoticeResponseDto.notExistNotice();

            studyNoticeEntity.patchNotice(dto);
            studyNoticeRepository.save(studyNoticeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchStudyNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(String createStudyUserEmail,Integer studyNumber, Integer studyNoticeNumber) {
        
        try {
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return DeleteStudyNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return DeleteStudyNoticeResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteStudyNoticeResponseDto.noPermission();

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if( studyNoticeEntity == null) return DeleteStudyNoticeResponseDto.notExistNotice();

            studyNoticeRepository.delete(studyNoticeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();            
        }

        return DeleteStudyNoticeResponseDto.success();
    }

    private final StudyTodoListRepository studyTodoListRepository;

    @Override
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodoList(String userEmail, Integer studyNumber) {

        List<StudyTodoListResultSet> resultSets = new ArrayList<>();

        try {
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetStudyTodoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return GetStudyTodoListResponseDto.notExistStudy();

            resultSets = studyTodoListRepository.findByStudyNumber(studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();     
        }
        return GetStudyTodoListResponseDto.success(resultSets);

    }

    @Override
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodoList(PostStudyTodoListRequestDto dto,String createStudyUserEmail, Integer studyNumber) {
    
        try {
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PostStudyTodoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostStudyTodoListResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostStudyTodoListResponseDto.noPermission();

            StudyTodoListEntity studyTodoListEntity = new StudyTodoListEntity(dto,studyNumber);
            studyTodoListRepository.save(studyTodoListEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();   
        }

        return PostStudyTodoListResponseDto.success();
    }

    


}


