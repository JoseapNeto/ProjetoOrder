package br.com.application.controller;


import br.com.application.entity.UserEntity;
import br.com.application.service.UserService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserEntity> insert(@RequestBody UserEntity user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> listUser = userService.findAll();
        return ResponseEntity.ok().body(listUser);
    }
    @GetMapping(value = "/{userId}")
    public ResponseEntity findById(@PathVariable Integer userId){
        return ResponseEntity.ok().body(userService.findById(userId));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Integer userId){
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserEntity> update(@PathVariable Integer userId, @RequestBody UserEntity user){
        return ResponseEntity.ok().body(userService.update(userId,user));
    }



}
