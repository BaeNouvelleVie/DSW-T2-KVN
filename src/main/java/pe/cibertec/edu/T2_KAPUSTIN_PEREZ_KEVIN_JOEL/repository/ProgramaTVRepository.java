package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.bd.ProgramaTV;

@Repository
public interface ProgramaTVRepository extends JpaRepository<ProgramaTV, Integer> {

}
