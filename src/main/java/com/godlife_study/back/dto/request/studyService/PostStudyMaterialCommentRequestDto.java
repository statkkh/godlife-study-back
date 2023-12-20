package com.godlife_study.back.dto.request.studyService;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStudyMaterialCommentRequestDto {

    @NotBlank
    private String studyMaterialCommentContent;
}
