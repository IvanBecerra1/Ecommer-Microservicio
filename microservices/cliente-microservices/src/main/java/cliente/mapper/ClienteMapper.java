package cliente.mapper;

import cliente.dto.ClienteRequest;
import cliente.modelo.Cliente;
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

}
