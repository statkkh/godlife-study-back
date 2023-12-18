package com.godlife_study.back.entity;


import javax.persistence.Table;

import com.godlife_study.back.dto.request.studyService.PatchStudyTodoListRequestDto;
import com.godlife_study.back.dto.request.studyService.PostStudyTodoListRequestDto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study_todolist")
@Table(name="study_todolist")
public class StudyTodoListEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private boolean studyListCheck;
    
    public StudyTodoListEntity(PostStudyTodoListRequestDto dto, Integer studyNumber){
        this.studyNumber = studyNumber;
        this.studyListContent =  dto.getStudyListContent();
        this.studyListCheck = false;
    }

    public void patchTodoList(PatchStudyTodoListRequestDto dto){
        this.studyListNumber = dto.getStudyListNumber();
        this.studyListContent =  dto.getStudyListContent();
    }      
}
