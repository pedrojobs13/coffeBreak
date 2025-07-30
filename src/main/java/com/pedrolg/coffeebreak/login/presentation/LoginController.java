package com.pedrolg.coffeebreak.login.presentation;

import com.pedrolg.coffeebreak.config.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class LoginController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody LoginDto login) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
