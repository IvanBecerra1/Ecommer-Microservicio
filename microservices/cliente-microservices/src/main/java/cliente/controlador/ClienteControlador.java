package cliente.controlador;


import cliente.dto.ClienteRequest;
import cliente.repositorio.ClienteRepositorio;
import cliente.servicio.ClienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cliente")
@RequiredArgsConstructor
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody @Valid ClienteRequest clienteRequest){
        String id = this.clienteServicio.crearCliente(clienteRequest);

        return ResponseEntity.ok(id);
    }
}
