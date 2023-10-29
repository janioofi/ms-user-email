package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Transactional
    public UserModel save(@Valid UserModel userModel){
        return repository.save(userModel);
    }
}
