package com.LMS.Controllers;

import com.LMS.DTOs.UserDTO;
import com.LMS.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/LMS/User")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createNewUser(@Valid @RequestBody UserDTO userDto){
        return new ResponseEntity<>(userServiceImpl.createNewUser(userDto), HttpStatus.CREATED);
    }
}
