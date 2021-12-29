package br.com.application.controller;


import br.com.application.entity.OrderEntity;
import br.com.application.entity.UserEntity;
import br.com.application.service.OrderService;
import br.com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;



    @PostMapping
    public ResponseEntity<OrderEntity> insert(@RequestBody OrderEntity order){
        order = orderService.insert(order);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderEntity> findById(Integer id){
        OrderEntity order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }




}
