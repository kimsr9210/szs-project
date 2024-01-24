package com.example.test.dto.repository;

import com.example.test.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, String> {
    boolean existsByUserId(String userId);
    Optional<UserInfo> findByUserId(String userId);
}