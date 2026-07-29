package com.Connectly.user_service.Service;

import com.Connectly.user_service.DTO.LoginRequestDTO;
import com.Connectly.user_service.DTO.SignupRequestDTO;
import com.Connectly.user_service.DTO.UserDTO;
import com.Connectly.user_service.Entity.User;
import com.Connectly.user_service.Repository.UserRepository;
import com.Connectly.user_service.Util.Bcrypt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public UserDTO signUp(SignupRequestDTO signupRequestDTO) {
        boolean userExists = userRepository.existsByEmail(signupRequestDTO.getEmail());
        if(userExists){
            throw new RuntimeException("User already exists with email: "+ signupRequestDTO.getEmail());
        }

        User user = modelMapper.map(signupRequestDTO, User.class);
        user.setPassword(Bcrypt.hash(signupRequestDTO.getPassword()));

        user = userRepository.save(user);
        log.info("CREATED new user with email: {}", signupRequestDTO.getEmail());

        return modelMapper.map(user, UserDTO.class);
    }

    public String login(LoginRequestDTO loginRequestDTO) {
        log.info("Login triggered for user with email: {}", loginRequestDTO.getEmail());
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Incorrect email or password"));

        boolean isPasswordMatched = Bcrypt.match(loginRequestDTO.getPassword(), user.getPassword());

        if(!isPasswordMatched){
            throw new RuntimeException("Incorrect email or password");
        }

        return jwtService.generateAccessToken(user);
    }
}
