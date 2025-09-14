package cliente.repositorio;

import cliente.modelo.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends MongoRepository<Cliente, String> {


}
