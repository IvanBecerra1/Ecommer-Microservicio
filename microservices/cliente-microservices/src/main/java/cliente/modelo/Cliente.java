package cliente.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document // mongo db
public class Cliente {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String ciudad;
}
