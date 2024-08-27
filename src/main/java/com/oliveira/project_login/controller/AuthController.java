package com.oliveira.project_login.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.project_login.domain.user.User;
import com.oliveira.project_login.dto.LoginRequestDTO;
import com.oliveira.project_login.dto.LoginResponseDTO;
import com.oliveira.project_login.dto.RegisterRequestDTO;
import com.oliveira.project_login.dto.RegisterResponseDTO;
import com.oliveira.project_login.infra.security.TokenService;
import com.oliveira.project_login.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO body) {
    User user = this.userRepository.findByEmail(body.email())
        .orElseThrow(() -> new RuntimeException("User not found!"));

    if (passwordEncoder.matches(body.password(), user.getPassword())) {
      String token = this.tokenService.generateToken(user);
      return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
    }

    return ResponseEntity.badRequest().build();

  }

  @PostMapping("/register")
  public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO body) {
    Optional<User> user = this.userRepository.findByEmail(body.email());

    if (user.isEmpty()) {

      User newUser = new User();
      newUser.setPassword(passwordEncoder.encode(body.password()));
      newUser.setName(body.name());
      newUser.setEmail(body.email());
      this.userRepository.save(newUser);

      String token = this.tokenService.generateToken(newUser);
      return ResponseEntity.ok(new RegisterResponseDTO(newUser.getName(), token));

    }

    return ResponseEntity.badRequest().build();

  }

}
