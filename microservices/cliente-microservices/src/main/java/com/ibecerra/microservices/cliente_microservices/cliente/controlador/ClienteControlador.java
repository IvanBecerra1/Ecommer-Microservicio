package com.ibecerra.microservices.cliente_microservices.cliente.controlador;


import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteRequest;
import com.ibecerra.microservices.cliente_microservices.cliente.dto.ClienteResponse;
import com.ibecerra.microservices.cliente_microservices.cliente.servicio.ClienteServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import com.ibecerra.microservices.cliente_microservices.cliente.modelo.Cliente;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;


    @PostMapping("")
    public ResponseEntity<String> registrarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        String id = this.clienteServicio.crearCliente(clienteRequest);

        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable("id") String id){
        return ResponseEntity.ok(this.clienteServicio.buscarCliente(id));

    }

    @PutMapping("")
    public ResponseEntity<String> modificarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        return ResponseEntity.ok(this.clienteServicio.modificarCliente(clienteRequest));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ClienteResponse>> listarCliente(){
        return ResponseEntity.ok(this.clienteServicio.listaCliente());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") String id){
        this.clienteServicio.eliminarCliente(id);
        
        return ResponseEntity.ok("eliminado");
    }
}
