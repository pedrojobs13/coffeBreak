package com.pedrolg.coffeebreak.user.business.usecase;

import com.pedrolg.coffeebreak.config.BCryptPasswordEncoderBean;
import com.pedrolg.coffeebreak.config.Role;
import com.pedrolg.coffeebreak.user.business.User;
import com.pedrolg.coffeebreak.user.integration.UserRepository;
import com.pedrolg.coffeebreak.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoderBean bCryptPasswordEncoderBean;

    public void execute(User user) {
        User newUser = User.builder()
                .city(user.getCity())
                .name(user.getName())
                .password(bCryptPasswordEncoderBean.execute())
                .accountType(Role.fromStringToEnum(user.getAccountType()).getType())
                .email(user.getEmail())
                .phone(user.getPhone())
                .street(user.getStreet())
                .build();


        userRepository.save(UserMapper.toEntity(newUser));
    }


}
