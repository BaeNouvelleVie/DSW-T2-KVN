package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;


import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.ProgramaTV;

import java.util.List;
import java.util.Optional;

public interface IProgramaTVService {
    List<ProgramaTV> listarProgramaTVs();
    ProgramaTV guardarProgramaTV(ProgramaTV programaTV);
    Optional<ProgramaTV> obtenerProgramaTV(Integer id);
}
