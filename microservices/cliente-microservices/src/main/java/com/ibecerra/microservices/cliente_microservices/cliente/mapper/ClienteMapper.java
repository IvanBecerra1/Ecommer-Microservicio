package com.ibecerra.microservices.cliente_microservices.cliente.mapper;

import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteRequest;
import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteResponse;
import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteResponse.ClienteResponseBuilder;
import com.ibecerra.microservices.cliente_microservices.cliente.modelo.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public Cliente toCliente(ClienteRequest request) {
        return Cliente.builder()
                .id(request.id())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .correo(request.correo())
                .ciudad(request.ciudad())
                .telefono(request.telefono())
                .direccion(request.direccion())
                .build();
    }

    public ClienteResponse toClienteResponse(Cliente request){
        return ClienteResponse.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correo(request.getCorreo())
                .ciudad(request.getCiudad())
                .telefono(request.getTelefono())
                .direccion(request.getDireccion())
                .build();
    }

}
