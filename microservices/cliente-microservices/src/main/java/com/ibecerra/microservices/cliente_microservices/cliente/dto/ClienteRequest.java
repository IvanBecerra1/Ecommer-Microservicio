package com.ibecerra.microservices.cliente_microservices.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
    String id,
    @NotNull (message = "El nombre es requerido")
    String nombre,
    @NotNull (message = "El apellido es requerido")
    String apellido,
    @NotNull(message = "El correo es requerido")
    @Email(message = "El correo no es valido")
    String correo,
    String telefono,
    String direccion,
    String ciudad
) {
}
