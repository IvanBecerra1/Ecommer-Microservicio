package com.ib.microservicio.general_excepcions;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component // para la inyeccion de dependencia y sea reconocida como componente
@RestControllerAdvice // se utiliza para manejar las excepciones
// de nuestras apis rest 
public class GlobalExcepcionHandled {
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handledException(MethodArgumentNotValidException exception){
        HashMap errores = new HashMap<String, String>();
        
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            String titulo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(titulo, mensaje);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errores));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handledException(Exception exception){
        HashMap errors = new HashMap<String, String>();

        String titulo = "mensaje";
        String errorMensaje = "Se ha producido un error, porfavor contacte al adminstrador e intente mas tarde.";

        errors.put(titulo, errorMensaje);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(errors));
    }
}
