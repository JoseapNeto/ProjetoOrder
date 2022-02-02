package br.com.application.service;


import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.UserRepository;
import br.com.application.service.exceptions.UserNotFoundException;
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


    /*
    public UserEntity findById(Integer userId){
        return userRepository.findById(userId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente nao encontrado"){});
    }
*/

    public UserEntity findById(Integer userId){
        return userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(userId));
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public UserEntity update(Integer id, UserEntity user){
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"){});
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        return userRepository.save(userEntity);

    }


}
