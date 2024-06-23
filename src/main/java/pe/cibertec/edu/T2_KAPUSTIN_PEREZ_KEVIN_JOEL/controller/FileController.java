package pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.model.dto.ArchivoDto;
import pe.cibertec.edu.T2_KAPUSTIN_PEREZ_KEVIN_JOEL.service.FileService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private FileService fileService;

    @PostMapping("/uploadMultiple")
    public ResponseEntity<ArchivoDto> subirVariosArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList) throws Exception {
        if (multipartFileList.size() != 3) {
            throw new Exception("Debe subir exactamente tres archivos.");
        }
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivos subidos correctamente").build(), HttpStatus.OK);
    }

    @PostMapping("/uploadSingle")
    public ResponseEntity<ArchivoDto> subirUnArchivo(
            @RequestParam("file") MultipartFile archivo) throws Exception {
        fileService.guardarArchivo(archivo);
        return new ResponseEntity<>(ArchivoDto.builder().mensaje("Archivo subido correctamente").build(), HttpStatus.OK);
    }
}
