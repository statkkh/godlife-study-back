package com.godlife_study.back.dto.request.studyService;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PostStudyMaterialRequestDto {
    @NotBlank @Size(min = 2)
    private String studyMaterialName;

    @NotNull @Size(min = 2)
    private String studyMaterialWriter;

    private String studyMaterialImageUrl; 
}
