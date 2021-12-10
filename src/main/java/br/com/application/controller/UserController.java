package br.com.application.controller;


import br.com.application.entity.UserEntity;
import br.com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> listUser = userService.findAll();
        return ResponseEntity.ok().body(listUser);
    }




}
