package com.oliveira.project_login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  @GetMapping("/me")
  public ResponseEntity<String> getUser() {
    return ResponseEntity.ok("Sucesso!");
  }
}
