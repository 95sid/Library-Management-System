package com.LMS.Services;

import com.LMS.DTOs.UserDTO;
import com.LMS.Entity.UserEntity;
import com.LMS.Exceptions.EmailDuplicateEntryException;
import com.LMS.Exceptions.PhoneDuplicateEntryException;
import com.LMS.Repositor.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        userRepository.findByEmail(userDTO.getEmail()).ifPresent(user -> {
            throw new EmailDuplicateEntryException("Email ID already exists.");
        });
        userRepository.findByPhone(userDTO.getPhone()).ifPresent(user -> {
            throw new PhoneDuplicateEntryException("Phone number already exists.");
        });

        UserEntity user = modelMapper.map(userDTO,UserEntity.class);
        return modelMapper.map(userRepository.save(user),UserDTO.class);
    }
}
