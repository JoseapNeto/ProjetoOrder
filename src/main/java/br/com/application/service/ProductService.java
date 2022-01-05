package br.com.application.service;


import br.com.application.entity.ProductEntity;
import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.ProductRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {





    @Autowired
    ProductRepository productRepository;



    public ProductEntity insert(ProductEntity product){
        return productRepository.save(product);
    }

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public ProductEntity findById(Integer productId){
     return productRepository.findById(productId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente nao encontrado"){});
    }





}
