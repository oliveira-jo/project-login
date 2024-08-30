package com.oliveira.project_login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  @GetMapping("/me")
  public ResponseEntity<Object> getUser(Authentication authentication) {
    return ResponseEntity.ok(authentication.getPrincipal());

  }
}
