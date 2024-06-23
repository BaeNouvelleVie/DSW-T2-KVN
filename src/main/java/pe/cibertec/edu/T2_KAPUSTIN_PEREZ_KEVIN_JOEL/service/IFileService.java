package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    void guardarArchivo(MultipartFile archivo) throws Exception;

    void guardarArchivos(List<MultipartFile> archivosList) throws Exception;

}
