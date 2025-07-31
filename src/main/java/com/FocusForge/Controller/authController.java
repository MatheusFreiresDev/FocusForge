package com.FocusForge.Controller;

import com.FocusForge.Controller.authDTO.RegisterDTO;
import com.FocusForge.Controller.authDTO.LoginDTO;
import com.FocusForge.Entity.User;
import com.FocusForge.Entity.UserRoles;
import com.FocusForge.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class authController {
        @Autowired
    AuthenticationManager authenticationManager;
        @Autowired
        UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody @Valid RegisterDTO registerDTO) {
        try{
            String password = new BCryptPasswordEncoder().encode(registerDTO.password());
            User newUser = new User(password, registerDTO.role(), registerDTO.name(), registerDTO.email());
            if(userRepository.findByEmail(newUser.getEmail()).isPresent()){
                return ResponseEntity.badRequest().body("Email já registrado.");
            }
            if (newUser.getRole() == null ){
                newUser.setRole(UserRoles.USER);
            }
            return ResponseEntity.ok(  userRepository.save(newUser));
        }  catch (Exception e) {
        return ResponseEntity.badRequest().body("Usuário e senha inválidos");
    }

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO userResponse) {
            var userPassword = new UsernamePasswordAuthenticationToken(userResponse.email(),userResponse.password());
            var auth = this.authenticationManager.authenticate(userPassword);
            User user = userRepository.findUserByEmail(userResponse.email()).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
            return ResponseEntity.ok( user.getName()+ " sucess to login.");
    }
}