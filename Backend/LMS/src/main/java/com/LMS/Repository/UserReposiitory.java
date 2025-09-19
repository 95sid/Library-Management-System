package com.LMS.Repository;

import com.LMS.DTOs.UserDTO;
import com.LMS.Entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposiitory extends JpaRepository<UserEntity,Long> {
    // Clean and simple methods. Validation is handled by the DTO.
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByPhone(String phone);
}
