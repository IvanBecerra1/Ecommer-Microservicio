package com.ibecerra.microservices.cliente_microservices.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder // lombok necesario para el mapper
public record ClienteResponse(
    String id,
    String nombre,
    String apellido,
    String correo,
    String telefono,
    String direccion,
    String ciudad
) {
    
}
