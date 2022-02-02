package br.com.application.service;


import br.com.application.entity.UserEntity;
import br.com.application.repository.OrderRepository;
import br.com.application.repository.UserRepository;
import br.com.application.service.exceptions.DatabaseException;
import br.com.application.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
                new NotFoundException("Usuario não encontrado"));
    }

    public void delete(Integer id){
        try {
            userRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
           throw new DatabaseException("Usuario não pode ser excluido, verificar orders pendentes ID: "+id);
        }
        }

    public UserEntity update(Integer id, UserEntity user){
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Usuario não encontrado"));
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        return userRepository.save(userEntity);
    }


}
