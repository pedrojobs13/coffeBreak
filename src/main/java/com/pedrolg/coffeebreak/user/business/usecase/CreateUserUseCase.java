package com.pedrolg.coffeebreak.user.business.usecase;

import com.pedrolg.coffeebreak.user.business.User;
import com.pedrolg.coffeebreak.user.integration.UserRepository;
import com.pedrolg.coffeebreak.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public void execute(User user) {
        userRepository.save(UserMapper.toEntity(user));
    }


}
