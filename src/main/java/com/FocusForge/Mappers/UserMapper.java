package com.FocusForge.Mappers;

import com.FocusForge.Controller.Request.UserRequest;
import com.FocusForge.Controller.Response.UserResponse;
import com.FocusForge.Entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public User toUser(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())

                .build();
    }

    public UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
