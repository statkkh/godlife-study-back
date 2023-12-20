package com.godlife_study.back.dto.request.studyService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PatchStudyMaterialCommentRequestDto {
    @NotNull
    private int studyMaterialCommentNumber;

    @NotBlank
    private String studyMaterialCommentContent;    
}
