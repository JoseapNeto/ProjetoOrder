package br.com.application.service;


import br.com.application.entity.OrderEntity;
import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {




    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;


    public UserEntity insert(UserEntity user){
        user = userRepository.save(user);
        for(OrderEntity order : user.getListOrder()){
            order.setUser(user);
            orderRepository.save(order);
        }
        return user;
    }



}
