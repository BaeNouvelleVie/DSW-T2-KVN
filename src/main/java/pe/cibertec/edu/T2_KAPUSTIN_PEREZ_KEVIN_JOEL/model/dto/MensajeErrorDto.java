package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class MensajeErrorDto {
    private Integer codigoEstado;
    private Date fechaError;
    private String mensaje;
    private String descripcion;

}
