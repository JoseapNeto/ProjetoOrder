package br.com.application.controller;


import br.com.application.entity.UserEntity;
import br.com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping
    public ResponseEntity<UserEntity> insert(@RequestBody UserEntity user){
        user = userService.insert(user);
        return ResponseEntity.ok().body(user);
    }




}
