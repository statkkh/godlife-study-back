package com.godlife_study.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife_study.back.entity.StudyUserListEntity;
import com.godlife_study.back.entity.primaryKey.StudyUserListPK;
import com.godlife_study.back.repository.resultSet.StudyUserListResultSet;

import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface StudyUserListRepository extends JpaRepository<StudyUserListEntity, StudyUserListPK> {
    boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);

    StudyUserListEntity findByStudyNumberAndUserEmail(Integer studyNumber, String userEmail);

    @Query(
        value = "SELECT " +
        "U.user_email AS userEmail, " +
        "U.study_number AS studyNumber, " +
        "S.study_grade AS studyGrade " +
        "FROM study_user_list AS S " +
        "INNER JOIN user AS U " +
        "ON S.user_email = U.user_email " +
        "WHERE S.study_number = ?1 " +
        "ORDER BY S.study_grade ASC ", 
    nativeQuery = true)
    List<StudyUserListResultSet> findByStudyUserList(Integer studyNumber);

    @Transactional
    void deleteByUserEmail(String userEmail);    
}
