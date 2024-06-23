package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.controller;


import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.exception.ResourceNotFoundException;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.ProgramaTV;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service.ProgramaTVService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/programasTVs")


public class ProgramaTVController {

    private ProgramaTVService programaTVService;

    @GetMapping("")
    public ResponseEntity<List<ProgramaTV>> listarProgramaTV(){
        List<ProgramaTV> programaTVList = programaTVService.listarProgramaTVs();
        if(programaTVList.isEmpty()){
            return new ResponseEntity<>(programaTVList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(programaTVList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTV> obtenerProgramaTVxId(@PathVariable Integer id){
        ProgramaTV programaTV = programaTVService
                .obtenerProgramaTV(id).orElseThrow(
                ()-> new ResourceNotFoundException("ProgramaTV con el id: "
                        + id + " no existe")
        );
        return new ResponseEntity<>(programaTV, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProgramaTV> guardarProgramaTV(ProgramaTV programaTV){
        return new ResponseEntity<>(
                programaTVService.guardarProgramaTV(programaTV), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTV> actualizarProgramaTV(
            @PathVariable Integer id,
            @RequestBody ProgramaTV programaTV
    ){
        ProgramaTV newProgramaTV = programaTVService.obtenerProgramaTV(id)
                .orElseThrow(()-> new ResourceNotFoundException("ProgramaTV con el id: "
                        + id + " no existe"));
        newProgramaTV.setTitulo(programaTV.getTitulo());
        newProgramaTV.setResumen(programaTV.getResumen());
        newProgramaTV.setFechaInicio(programaTV.getFechaInicio());
        return new ResponseEntity<>(
                programaTVService.guardarProgramaTV(newProgramaTV), HttpStatus.OK);
    }

}
