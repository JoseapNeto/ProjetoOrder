package br.com.application.controller;


import br.com.application.entity.CategoryEntity;
import br.com.application.entity.ProductEntity;
import br.com.application.service.CategoryService;
import br.com.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;



    @PostMapping
    public ResponseEntity<CategoryEntity> insert(@RequestBody CategoryEntity category){
        category = categoryService.insert(category);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll(){
        List<CategoryEntity> listProduct = categoryService.findAll();
        return ResponseEntity.ok().body(listProduct);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Integer id){
        CategoryEntity category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }


}
