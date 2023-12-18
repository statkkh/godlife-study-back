package com.godlife_study.back.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.godlife_study.back.repository.resultSet.StudyTodoListResultSet;

@Getter
@Setter
public class StudyTodoListItem {
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private Boolean studyListCheck;

    public StudyTodoListItem(StudyTodoListResultSet resultSet){
        this.studyListNumber = resultSet.getStudyListNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyListContent = resultSet.getStudyListContent();
        this.studyListCheck = resultSet.getStudyListCheck();
    }

    public static List<StudyTodoListItem> getTodoList(List<StudyTodoListResultSet> resultSets){
        List<StudyTodoListItem> list = new ArrayList<>();
        
        for(StudyTodoListResultSet resultSet :  resultSets){
            StudyTodoListItem StudyTodoListItem = new StudyTodoListItem(resultSet);
            list.add(StudyTodoListItem);
        }

        return list;
    }        
}
