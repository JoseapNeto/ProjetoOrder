package br.com.application.config;


import br.com.application.entity.CategoryEntity;
import br.com.application.entity.OrderEntity;
import br.com.application.entity.ProductEntity;
import br.com.application.entity.UserEntity;
import br.com.application.repository.CategoryRepository;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.ProductRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import static br.com.application.enums.OrderStatus.*;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        UserEntity u1 = new UserEntity(null, "Jose Neto", "neto@gmail.com", "988888888");
        UserEntity u2 = new UserEntity(null, "Deborah Cristina", "deborah@gmail.com", "977777777");
        userRepository.saveAll(Arrays.asList(u1,u2));

        OrderEntity o1 = new OrderEntity(null, "29/12/2021", WATTING_PAYMENT, u1);
        OrderEntity o2 = new OrderEntity(null,"29/12/2021", PAID, u2);
        OrderEntity o3 = new OrderEntity(null,"29/12/2021", CANCELED, u2);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet", 10.0);
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0);
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor",  1250.0);
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0);
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.0);

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));







    }
}
