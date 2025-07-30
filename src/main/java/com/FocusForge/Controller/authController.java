package com.FocusForge.Controller;

import com.FocusForge.Controller.Request.UserRequest;
import com.FocusForge.Exceptions.EmailOrPasswordInvalid;
import com.FocusForge.Mappers.UserMapper;
import com.FocusForge.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {
        @Autowired
        UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody @Valid UserRequest userRequest) {
        try{
            return ResponseEntity.ok(UserMapper.toUserResponse( userService.save(UserMapper.toUser(userRequest))));
        } catch (EmailOrPasswordInvalid a)  {
            throw new EmailOrPasswordInvalid("User burro kkkkkkkkj");
        }

    }

}
