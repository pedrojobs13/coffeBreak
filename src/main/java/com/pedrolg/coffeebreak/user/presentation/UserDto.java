package com.pedrolg.coffeebreak.user.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
}
