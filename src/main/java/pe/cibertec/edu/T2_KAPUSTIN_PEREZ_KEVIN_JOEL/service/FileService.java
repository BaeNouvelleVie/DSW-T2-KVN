package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("uploads");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        if (!archivo.isEmpty()) {
            validarExtension(archivo.getOriginalFilename());
            validarTamano(archivo);
            Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
        }
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        for (MultipartFile archivo : archivosList) {
            this.guardarArchivo(archivo);
        }
    }

    private void validarExtension(String nombreArchivo) throws Exception {
        String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toLowerCase();
        if (!List.of("pdf", "png", "docx").contains(extension)) {
            throw new Exception("Formato de archivo no permitido.");
        }
    }

    private void validarTamano(MultipartFile archivo) throws Exception {
        if (archivo.getSize() > 25 * 1024 * 1024) {
            throw new Exception("El archivo excede el tamaño máximo permitido.");
        }
    }
}
