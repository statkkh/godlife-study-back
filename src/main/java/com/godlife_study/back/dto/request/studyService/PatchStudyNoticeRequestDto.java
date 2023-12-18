package com.godlife_study.back.dto.request.studyService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@NoArgsConstructor
@Getter
public class PatchStudyNoticeRequestDto {
    
    @NotNull
    private int studyNoticeNumber;

    @NotBlank @Size(min = 1)
    private String studyNoticeContent;
}
