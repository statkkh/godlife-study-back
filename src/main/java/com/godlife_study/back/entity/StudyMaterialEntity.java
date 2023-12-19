package com.godlife_study.back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.godlife_study.back.dto.request.studyService.PostStudyMaterialRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_material")
@Table(name = "study_material")
public class StudyMaterialEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyMaterialNumber;
    private int studyNumber;
    private String studyMaterialName;
    private String studyMaterialImageUrl;
    private String studyMaterialWriter;
    private String studyMaterialDatetime;

    public StudyMaterialEntity(PostStudyMaterialRequestDto dto, Integer studyNumber){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String studyMaterialDatetime = simpleDateFormat.format(now);
        
        this.studyNumber = studyNumber;
        this.studyMaterialName = dto.getStudyMaterialName();
        this.studyMaterialImageUrl = dto.getStudyMaterialImageUrl();
        this.studyMaterialWriter = dto.getStudyMaterialWriter();
        this.studyMaterialDatetime = studyMaterialDatetime;
    }

}
