package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.Personaje;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.repository.PersonajeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonajeService implements IPersonajeService {

    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> listarPersonajes() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Optional<Personaje> obtenerPersonajexId(Integer id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()) {
            return Optional.empty();
        }
        return personaje;
    }
}
