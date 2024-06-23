package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;

import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.Personaje;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService
{
    List<Personaje> listarPersonajes();
    Personaje guardarPersonaje(Personaje personaje);
    Optional<Personaje> obtenerPersonajexId(Integer id);


}
