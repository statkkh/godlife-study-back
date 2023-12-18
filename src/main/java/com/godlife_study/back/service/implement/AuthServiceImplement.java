package com.godlife_study.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.godlife_study.back.dto.request.auth.SignInEmailCheckRequestDto;
import com.godlife_study.back.dto.request.auth.SignInRequestDto;
import com.godlife_study.back.dto.request.auth.SignUpRequestDto;
import com.godlife_study.back.dto.response.ResponseDto;
import com.godlife_study.back.dto.response.auth.SignInEmailcheckResponseDto;
import com.godlife_study.back.dto.response.auth.SignInResponseDto;
import com.godlife_study.back.dto.response.auth.SignUpResponseDto;
import com.godlife_study.back.entity.UserEntity;
import com.godlife_study.back.provider.JwtProvider;
import com.godlife_study.back.repository.UserRepository;
import com.godlife_study.back.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Override
    public ResponseEntity<? super SignInEmailcheckResponseDto> signInEmailCheck(SignInEmailCheckRequestDto dto) {

        try {
            String userEmail = dto.getUserEmail();

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null) return SignInEmailcheckResponseDto.notExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return SignInEmailcheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {
            
            String userEmail = dto.getUserEmail();

            boolean hasEmail = userRepository.existsByUserEmail(userEmail);
            if (hasEmail) return SignUpResponseDto.duplicateUserEmail();


            String userPassword = dto.getUserPassword();
            String encodedUserPassword = passwordEncoder.encode(userPassword);

            dto.setUserPassword(encodedUserPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try {
            String userEmail = dto.getUserEmail();

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null) return SignInResponseDto.signInFailed();

            String userPassword = dto.getUserPassword();
            String encodedUserPassword = userEntity.getUserPassword();

            boolean isMatched = passwordEncoder.matches(userPassword, encodedUserPassword);
            if (!isMatched) return SignInResponseDto.signInFailed();

            token = jwtProvider.create(userEmail);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }    
        
        return SignInResponseDto.success(token);
    }




    
}
