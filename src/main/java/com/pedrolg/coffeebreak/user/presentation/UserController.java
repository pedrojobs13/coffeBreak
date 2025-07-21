package com.pedrolg.coffeebreak.user.presentation;

import com.pedrolg.coffeebreak.user.business.usecase.CreateUserUseCase;
import com.pedrolg.coffeebreak.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserMapper mapperUser;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(UserDto user) {
        createUserUseCase.execute(UserMapper.toModel(user));

        return ResponseEntity.ok().build();
    }
}
