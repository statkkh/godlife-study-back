package com.godlife_study.back.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.godlife_study.back.dto.request.studyService.PatchStudyMaterialCommentRequestDto;
import com.godlife_study.back.dto.request.studyService.PostStudyMaterialCommentRequestDto;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_material_comment")
@Table(name = "study_material_comment")
public class StudyMaterialCommentEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyMaterialCommentNumber;
    private int studyMaterialNumber;
    private String userEmail;
    
    private String studyMaterialCommentContent;
    private String studyMaterialCommentDatetime;
    
    
    public StudyMaterialCommentEntity(PostStudyMaterialCommentRequestDto dto, String userEmail,int studyMaterialNumber) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String studyMaterialCommentDatetime = simpleDateFormat.format(now);
                
        this.studyMaterialNumber = studyMaterialNumber;
        this.userEmail = userEmail;
        this.studyMaterialCommentContent = dto.getStudyMaterialCommentContent();
        this.studyMaterialCommentDatetime = studyMaterialCommentDatetime;
    }

    public void patchMaterialComment(PatchStudyMaterialCommentRequestDto dto) {
        this.studyMaterialCommentNumber = dto.getStudyMaterialCommentNumber();
        this.studyMaterialCommentContent = dto.getStudyMaterialCommentContent();
    }    
}
