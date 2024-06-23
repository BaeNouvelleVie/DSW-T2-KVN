package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.ProgramaTV;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.repository.ProgramaTVRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgramaTVService implements IProgramaTVService {

    private ProgramaTVRepository programaTVRepository;

    @Override
    public List<ProgramaTV> listarProgramaTVs() {
        return programaTVRepository.findAll();
    }

    @Override
    public ProgramaTV guardarProgramaTV(ProgramaTV programaTV) {
        return programaTVRepository.save(programaTV);
    }

    @Override
    public Optional<ProgramaTV> obtenerProgramaTV(Integer id) {
        Optional<ProgramaTV> programaTV = programaTVRepository.findById(id);
        if (programaTV.isEmpty()) {
            return Optional.empty();
        }
        return programaTV;
    }

}
