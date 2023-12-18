package com.godlife_study.back.common;

import java.util.ArrayList;
import java.util.List;

import com.godlife_study.back.repository.resultSet.StudyNoticeListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyNoticeListItem {
    private int studyNoticeNumber;
    private int studyNumber;
    private String studyNoticeContent;
    
    public StudyNoticeListItem(StudyNoticeListResultSet resultSet){
        this.studyNoticeNumber = resultSet.getStudyNoticeNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyNoticeContent = resultSet.getStudyNoticeContent();
    }
    
    public static List<StudyNoticeListItem> getNoticeList(List<StudyNoticeListResultSet> resultSets){
        List<StudyNoticeListItem> list = new ArrayList<>();
        
        for(StudyNoticeListResultSet resultSet :  resultSets){
            StudyNoticeListItem noticeListItem = new StudyNoticeListItem(resultSet);
            list.add(noticeListItem);
        }
        
        return list;
    }        
}
