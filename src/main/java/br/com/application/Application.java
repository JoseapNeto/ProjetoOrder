package br.com.application;


import br.com.application.entity.CategoryEntity;
import br.com.application.entity.ProductEntity;
import br.com.application.repository.CategoryRepository;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.ProductRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
public class Application {





    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
