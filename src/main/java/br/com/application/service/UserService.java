package br.com.application.service;


import br.com.application.entity.OrderEntity;
import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;


    public UserEntity insert(UserEntity user){
        userRepository.save(user);
        return user;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(Integer userId){
     return userRepository.findById(userId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente nao encontrado"){});
    }

    public UserEntity findUserIdOrderId(Integer userId, Integer orderId){
        UserEntity user = findById(userId);
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Order não encontrada"){});
        user.getListOrder().add(order);
        return user;
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }



}
