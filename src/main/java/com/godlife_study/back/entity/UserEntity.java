package com.godlife_study.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godlife_study.back.dto.request.auth.SignUpRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
@Entity(name="user")
public class UserEntity {
    
    @Id    
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userFavorite1;
    private String userFavorite2;
    private String userFavorite3;
    private String userProfileImageUrl;
    private Integer userExperience;
    
    public UserEntity(SignUpRequestDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userNickname = dto.getUserNickname();
        this.userFavorite1 = dto.getUserFavorite1();
        this.userExperience = 0;
    }
    
    public UserEntity(String userEmail, String userNickname) {
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        userFavorite1 = "자격증";
        userExperience = 0;
    }


}
