package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programatv")
public class ProgramaTV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdProgramaTv;

    private String Titulo;
    private String Resumen;
    private String FechaInicio;

    @ManyToOne
    @JoinColumn(name = "IdPersonaje", nullable = false)
    private Personaje personaje;
}
