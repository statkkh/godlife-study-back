package com.godlife_study.back.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.godlife_study.back.repository.resultSet.StudyMaterialCommentListResultSet;

@Getter
@Setter
public class StudyMaterialCommentListItem {
    private int studyMaterialCommentNumber;
    private int studyMaterialNumber;

    private String userEmail;
    private String studyGrade;
    
    private String userProfilImage;
    private String userNickName;

    private String studyMaterialCommentContent;
    private String studyMaterialCommentDatetime;

    public StudyMaterialCommentListItem(StudyMaterialCommentListResultSet resultSet) {   
        this.studyMaterialCommentNumber = resultSet.getStudyMaterialCommentNumber();
        this.studyMaterialNumber = resultSet.getStudyMaterialNumber();
        this.userEmail = resultSet.getUserEmail();
        this.studyGrade = resultSet.getStudyGrade();
        this.userProfilImage = resultSet.getUserProfileImage();
        this.userNickName = resultSet.getUserNickName();
        this.studyMaterialCommentContent = resultSet.getStudyMaterialCommentContent();
        this.studyMaterialCommentDatetime = resultSet.getStudyMaterialCommentDatetime();
    }
    
    public static List<StudyMaterialCommentListItem> getMaterialCommentList(List<StudyMaterialCommentListResultSet> resultSets) {
        List<StudyMaterialCommentListItem> list = new ArrayList<>();
        for (StudyMaterialCommentListResultSet resultSet : resultSets) {
            StudyMaterialCommentListItem studyMaterialCommentListItem = new StudyMaterialCommentListItem(resultSet);
            list.add(studyMaterialCommentListItem);
        }
        return list;
    }    
}
