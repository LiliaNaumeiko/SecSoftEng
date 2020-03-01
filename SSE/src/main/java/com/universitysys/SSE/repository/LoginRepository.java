package com.universitysys.SSE.repository;

import com.universitysys.SSE.exception.WrongPasswordOrLogin;
import com.universitysys.SSE.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import com.universitysys.SSE.model.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Account, Long> {
}
