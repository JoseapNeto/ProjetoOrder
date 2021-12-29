package br.com.application.service;


import br.com.application.entity.OrderEntity;
import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {




    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;



    public OrderEntity insert(OrderEntity order){
        return orderRepository.save(order);
    }



}
