package com.godlife_study.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife_study.back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
    boolean existsByUserEmail(String userEmail);

    UserEntity findByUserEmail(String userEmail);
}
