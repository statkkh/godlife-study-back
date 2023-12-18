package com.godlife_study.back.dto.response;

public interface  ResponseCode {
    String SUCCESS = "SU";

    String VALIDATION_FAILED = "VF";
    
    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";
    String DUPLICATED_FAVORITE1 = "DF";
    String SIGN_IN_FAILED = "SF";
    String PASS_FAILED = "CPE";
    
    String NO_PERMISSION = "NP";

    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_USER_TO_DO_LIST = "NUTDL";

    String NOT_EXIST_STUDY = "NS";
    String NOT_EXIST_USER_LIST = "This User List Number does not exist.";

    String NOT_EXIST_NOTICE = "NN";
    String NOT_EXIST_TODOLIST = "NT";
    String NOT_EXIST_MATERIAL = "NM";
    String NOT_EXIST_MATERIAL_COMMENT = "NMC";

    String DATABASE_ERROR = "DBE";
}
