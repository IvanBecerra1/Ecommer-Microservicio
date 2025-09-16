package com.ibecerra.microservices.cliente_microservices.cliente.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteRequest;
import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteResponse;
import com.ibecerra.microservices.cliente_microservices.cliente.mapper.ClienteMapper;
import com.ibecerra.microservices.cliente_microservices.cliente.modelo.Cliente;
import com.ibecerra.microservices.cliente_microservices.cliente.repositorio.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicio {
    private final ClienteRepositorio clienteRepositorio;
    private final ClienteMapper clienteMapper;

    public String crearCliente(ClienteRequest clienteRequest){
        Cliente cliente = this.clienteMapper.toCliente(clienteRequest);
        Cliente clienteResponse = this.clienteRepositorio.save(cliente);

        return clienteResponse.getId();
    }

    public String modificarCliente(ClienteRequest clienteRequest){
        Cliente cliente = this.clienteRepositorio.findById(clienteRequest.id())
                                    .orElseThrow();

        cliente = clienteMapper.toCliente(clienteRequest);

        this.clienteRepositorio.save(cliente);
        
        return cliente.getId();
    }
    public ClienteResponse buscarCliente(String id){
        return this.clienteRepositorio.findById(id)
                    .map(clienteMapper::toClienteResponse).orElseThrow();
    }

    public List<ClienteResponse> listaCliente(){
        return this.clienteRepositorio
            .findAll()
            .stream()
            .map(clienteMapper::toClienteResponse)
            .toList();
    }

    public void eliminarCliente(String id){
        this.clienteRepositorio.findById(id)
            .orElseThrow();

        this.clienteRepositorio.deleteById(id);


    }
}
