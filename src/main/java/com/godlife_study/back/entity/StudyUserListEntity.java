package com.godlife_study.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.godlife_study.back.entity.primaryKey.StudyUserListPK;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "study_user_list")
@Table(name = "study_user_list")
@IdClass(StudyUserListPK.class)
public class StudyUserListEntity {
    @Id
    private int studyNumber;
    @Id
    private String userEmail;
    private String studyGrade;

    public StudyUserListEntity(int studyNumber, String userEmail, String studyGrade) {
        this.studyNumber = studyNumber;
        this.userEmail = userEmail;
        this.studyGrade = studyGrade;
    }
}
