package com.universitysys.SSE.repository;

import com.universitysys.SSE.exception.WrongPasswordOrLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import com.universitysys.SSE.model.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Students, Long> {
    @Query(" select a.password from Students a where a.username = ?1")
    List<Long> findStudentsByPassword(Long password)  throws WrongPasswordOrLogin;
}
