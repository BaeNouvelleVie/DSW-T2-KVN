package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.exception.ResourceNotFoundException;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.Personaje;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service.PersonajeService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/personajes")

public class PersonajeController {

    private PersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<List<Personaje>> listarPersonaje() {
        List<Personaje> personajeList = new ArrayList<>(personajeService.listarPersonajes());
        if (personajeList.isEmpty()) {
            return new ResponseEntity<>(personajeList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personajeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> obtenerPersonajexId(@PathVariable Integer id) {
        Personaje personaje = personajeService
                .obtenerPersonajexId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Personaje con el id: "
                                + id + " no existe")
                );
        return new ResponseEntity<>(personaje, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Personaje> registrarPersonaje(@RequestBody Personaje personaje) {
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(personaje), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(
            @PathVariable Integer id,
            @RequestBody Personaje personaje
    ){
        Personaje newPersonaje = personajeService.obtenerPersonajexId(id)
                .orElseThrow(()-> new ResourceNotFoundException("Personaje con el id: "
                        + id + " no existe"));
        newPersonaje.setNompersonaje(personaje.getNompersonaje());
        newPersonaje.setApepersonaje(personaje.getApepersonaje());
        newPersonaje.setFechnacpersonaje(personaje.getFechnacpersonaje());
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(newPersonaje), HttpStatus.OK);
    }


}

