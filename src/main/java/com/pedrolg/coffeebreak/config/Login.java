package com.pedrolg.coffeebreak.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {
    private String id;
    private String email;
    private List<Role> roles;
}
