package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")

public class Personaje {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer idpersonaje;
    private String nompersonaje;
    private String apepersonaje;
    private String fechnacpersonaje;


}
