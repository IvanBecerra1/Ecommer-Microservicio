package com.ibecerra.microservices.cliente_microservices.cliente.excepciones;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ib.microservicio.general_excepcions.ErrorResponse;
import com.ib.microservicio.general_excepcions.GlobalExcepcionHandled;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Primary // hace que primero se ejecute este y despues el otro global
@Slf4j
public class ClienteExcepcionHandled extends GlobalExcepcionHandled {
    
    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handle (ClienteNoEncontradoException exception){
        HashMap errores = new HashMap<String, String>();

        String titulo = "cliente";
        errores.put(titulo, exception.getMessage());
        
        log.warn("Error cliente", exception.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errores));
    }
}
