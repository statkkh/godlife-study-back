package com.godlife_study.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife_study.back.dto.request.studyService.PatchStudyNoticeRequestDto;
import com.godlife_study.back.dto.request.studyService.PostStudyNoticeRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study_notice")
@Table(name="study_notice")
public class StudyNoticeEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int studyNoticeNumber;
    private int studyNumber;
    private String studyNoticeContent;

    public StudyNoticeEntity(PostStudyNoticeRequestDto dto, Integer studyNumber){
        this.studyNumber = studyNumber;
        this.studyNoticeContent = dto.getStudyNoticeContent();
    }

    public void patchNotice(PatchStudyNoticeRequestDto dto){
        this.studyNoticeNumber = dto.getStudyNoticeNumber();
        this.studyNoticeContent = dto.getStudyNoticeContent();
    }
}
