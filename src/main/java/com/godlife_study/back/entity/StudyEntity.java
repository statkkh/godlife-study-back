package com.godlife_study.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife_study.back.dto.request.study.PatchStudyRequestDto;
import com.godlife_study.back.dto.request.study.PostStudyRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study")
@Table(name="study")
public class StudyEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyNumber;
    private String studyName;
    private String studyStartDate;
    private String studyEndDate;
    private int studyPersonal;
    private String studyCategory1;
    private String studyCategory2;
    private String studyCategory3;
    private boolean studyPublicCheck;
    private String studyPrivatePassword;
    private String studyCoverImageUrl;
    private String studyNextStartDatetime;
    private String StudyNextEndDatetime;
    private int studyTotalDay;
    private String createStudyUserEmail;

    public StudyEntity(PostStudyRequestDto dto, String userEmail) {
        this.studyName = dto.getStudyName();
        this.studyStartDate = dto.getStudyStartDate();
        this.studyEndDate = dto.getStudyEndDate();
        this.studyPersonal = dto.getStudyPersonal();
        this.studyCategory1 = dto.getStudyCategory1();
        this.studyCategory2 = dto.getStudyCategory2();
        this.studyCategory3 = dto.getStudyCategory3();
        this.studyPublicCheck = dto.getStudyPublicCheck();
        this.studyPrivatePassword = dto.getStudyPrivatePassword();
        this.studyCoverImageUrl = dto.getStudyCoverImageUrl();
        this.createStudyUserEmail = userEmail;
    }
    
    public void patch(PatchStudyRequestDto dto) {
        this.studyName = dto.getStudyName();
        this.studyEndDate = dto.getStudyEndDate();
        this.studyPersonal = dto.getStudyPersonal();
        this.studyCategory1 = dto.getStudyCategory1();
        this.studyPublicCheck = dto.getStudyPublicCheck();
        this.studyPrivatePassword = dto.getStudyPrivatePassword();
        this.studyCoverImageUrl = dto.getStudyCoverImageUrl();
    }    
}
