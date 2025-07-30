package com.pedrolg.coffeebreak.user.mapper;


import com.pedrolg.coffeebreak.user.business.User;
import com.pedrolg.coffeebreak.user.integration.AddressEmbedded;
import com.pedrolg.coffeebreak.user.integration.UserEntity;
import com.pedrolg.coffeebreak.user.presentation.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {
    public static User toModel(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .city(userDto.getCity())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .street(userDto.getStreet())
                .accountType(userDto.getAccountType())
                .password(userDto.getPassword())
                .build();
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .accountType(user.getAccountType())
                .password(user.getPassword())
                .address(toAddress(user))
                .build();
    }

    private static AddressEmbedded toAddress(User user) {
        return AddressEmbedded.builder()
                .city(user.getCity())
                .street(user.getStreet())
                .build();
    }

}
