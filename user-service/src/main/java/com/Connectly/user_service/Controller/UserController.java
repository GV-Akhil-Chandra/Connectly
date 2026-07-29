package com.Connectly.user_service.Controller;

import com.Connectly.user_service.DTO.LoginRequestDTO;
import com.Connectly.user_service.DTO.SignupRequestDTO;
import com.Connectly.user_service.DTO.UserDTO;
import com.Connectly.user_service.Service.AuthService;
import com.Connectly.user_service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO){
        UserDTO userDTO = authService.signUp(signupRequestDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO){
        String token = authService.login(loginRequestDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
