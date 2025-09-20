package com.ibecerra.microservices.cliente_microservices.cliente.excepciones;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) // para utilizar las super clases
@Data
public class ClienteNoEncontradoException extends RuntimeException{
    private final String message;

}
