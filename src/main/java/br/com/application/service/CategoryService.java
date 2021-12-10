package br.com.application.service;


import br.com.application.entity.CategoryEntity;
import br.com.application.entity.ProductEntity;
import br.com.application.repository.CategoryRepository;
import br.com.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {





    @Autowired
    CategoryRepository categoryRepository;



    public CategoryEntity insert(CategoryEntity product){
        return categoryRepository.save(product);
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public CategoryEntity findById(Integer categoryId){
     return categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente nao encontrado"){});
    }



}
