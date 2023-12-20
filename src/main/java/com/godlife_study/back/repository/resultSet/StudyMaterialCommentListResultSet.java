package com.godlife_study.back.repository.resultSet;

public interface StudyMaterialCommentListResultSet {
    int getStudyMaterialCommentNumber();
    int getStudyMaterialNumber();
    
    String getUserEmail();
    String getStudyGrade();

    String getUserProfileImage();
    String getUserNickName();
    
    String getStudyMaterialCommentContent();
    String getStudyMaterialCommentDatetime();    
} 