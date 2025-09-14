package cliente.servicio;

import cliente.dto.ClienteRequest;
import cliente.mapper.ClienteMapper;
import cliente.modelo.Cliente;
import cliente.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
