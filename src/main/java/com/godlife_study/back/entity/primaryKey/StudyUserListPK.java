package com.godlife_study.back.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyUserListPK implements Serializable{
    @Column(name = "study_number")
    private int studyNumber;
    @Column(name = "user_email")
    private String userEmail;
}
