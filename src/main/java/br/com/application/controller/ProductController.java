package br.com.application.controller;


import br.com.application.entity.ProductEntity;
import br.com.application.entity.UserEntity;
import br.com.application.service.ProductService;
import br.com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;



    @PostMapping
    public ResponseEntity<ProductEntity> insert(@RequestBody ProductEntity product){
        product = productService.insert(product);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll(){
        List<ProductEntity> listProduct = productService.findAll();
        return ResponseEntity.ok().body(listProduct);
    }




}
