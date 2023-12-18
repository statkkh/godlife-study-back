package com.godlife_study.back.dto.response;

public interface  ResponseMessage {
    String SUCCESS = "Succss.";

    String VALIDATION_FAILED = "Validation failed.";   
    
    String DATABASE_ERROR = "DataBase error.";

    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname.";
    String DUPLICATED_FAVORITE1 = "Duplicate Favorite1.";
    String SIGN_IN_FAILED = "Login information mismatch";
    String PASS_FAILED = "Confirm Password error.";

    String NO_PERMISSION = "Do not have permission.";

    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_USER_TO_DO_LIST = "This user to do list does exist";
    


    String NOT_EXIST_STUDY = "This study does not exist.";
    String NOT_EXIST_USER_LIST = "This User List Number does not exist.";

    String NOT_EXIST_NOTICE = "This study notice does not  exist.";
    String NOT_EXIST_TODOLIST = "This study todolist does not exist.";
    String NOT_EXIST_MATERIAL = "This study  material does not exist.";
    String NOT_EXIST_MATERIAL_COMMENT="This study material comment does not exist.";

    String CANT_STUDY_DATE_MODIFY = "The next study date cannot be set to earlier than today.";
    String NOT_JOIN_USER = "This user is not join in the study room.";
}
