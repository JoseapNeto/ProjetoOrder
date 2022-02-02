package br.com.application.controller.exceptions;


import br.com.application.service.exceptions.DatabaseException;
import br.com.application.service.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<StandardError> userNotFound(NotFoundException e, HttpServletRequest request){
            String error = "Not Found ";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }


        @ExceptionHandler(DatabaseException.class)
        public ResponseEntity<StandardError> userIntedrityViolation(DatabaseException e, HttpServletRequest request){
            String error = "Database Exception";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
        }
}
