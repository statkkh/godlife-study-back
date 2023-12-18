package com.godlife_study.back.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInEmailCheckRequestDto {
    @NotBlank @Email
    private String userEmail;
}
