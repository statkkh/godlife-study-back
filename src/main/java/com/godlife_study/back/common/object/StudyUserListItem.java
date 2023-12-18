package com.godlife_study.back.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.godlife_study.back.repository.resultSet.StudyUserListResultSet;

@Getter
@Setter
public class StudyUserListItem {
    private String userEmail;
    private int studyNumber;
    private String studyGrade;

    public StudyUserListItem(StudyUserListResultSet resultSet) {
        this.userEmail = resultSet.getUserEmail();
        this.studyNumber = resultSet.getStudyNumber(); 
        this.studyGrade = resultSet.getStudyGrade();
    }

    public static List<StudyUserListItem> getUserList(List<StudyUserListResultSet> resultSets) {
        List<StudyUserListItem> list = new ArrayList<>();
        for(StudyUserListResultSet resultSet :  resultSets){
            StudyUserListItem StudyUserListItem = new StudyUserListItem(resultSet);
            list.add(StudyUserListItem);
        }
        return list;
    }    
}
