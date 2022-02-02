package br.com.application.service.exceptions;

    public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(Object id){
        super("Usuario não encontrado Id: "+id);
    }


}
