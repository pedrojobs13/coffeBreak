package com.pedrolg.coffeebreak.user.presentation;

import com.pedrolg.coffeebreak.user.business.usecase.impl.CreateUserUseCase;
import com.pedrolg.coffeebreak.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody UserDto user) {
        createUserUseCase.execute(UserMapper.toModel(user));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
