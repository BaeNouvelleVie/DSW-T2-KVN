package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProgramaTv")
public class ProgramaTV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramaTv;

    @Column(name = "Titulo", nullable = false, length = 250)
    private String titulo;

    @Column(name = "Resumen", nullable = false, length = 250)
    private String resumen;

    @Column(name = "FechaInicio", nullable = false)
    private String fechaInicio;

    @ManyToOne
    @JoinColumn(name = "IdPersonaje", nullable = false)
    private Personaje personaje;
}
