package com.LMS.Services;

import com.LMS.DTOs.UserDTO;
import com.LMS.Entity.BookEntity;
import com.LMS.Entity.UserEntity;
import com.LMS.Exceptions.BookNotFoundExcepiton;
import com.LMS.Exceptions.EmailDuplicateEntryException;
import com.LMS.Exceptions.PhoneDuplicateEntryException;
import com.LMS.Repository.UserReposiitory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserReposiitory userReposiitory;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserReposiitory userReposiitory, ModelMapper modelMapper) {
        this.userReposiitory = userReposiitory;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        userReposiitory.findByEmail(userDTO.getEmail()).ifPresent(user -> {
            throw new EmailDuplicateEntryException("Email ID already exists.");
        });

        // Check for phone number duplication next.
        userReposiitory.findByPhone(userDTO.getPhone()).ifPresent(user -> {
            throw new PhoneDuplicateEntryException("Phone number already exists.");
        });

        UserEntity user = modelMapper.map(userDTO,UserEntity.class);
        return modelMapper.map(userReposiitory.save(user),UserDTO.class);
    }
}
