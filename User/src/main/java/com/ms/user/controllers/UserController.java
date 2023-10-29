package com.ms.user.controllers;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userModel));
    }

}
