package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.producer.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserProducer producer;

    @Transactional
    public UserModel save(@Valid UserModel userModel){
        userModel = repository.save(userModel);
        producer.publishMessageEmail(userModel);
        return userModel;
    }
}
