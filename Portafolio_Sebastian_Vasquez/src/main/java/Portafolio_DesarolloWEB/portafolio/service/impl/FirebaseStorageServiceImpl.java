package Portafolio_DesarolloWEB.portafolio.service.impl;

import Portafolio_DesarolloWEB.portafolio.service.FirebaseStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FirebaseStorageServiceImpl implements FirebaseStorageService {

    private final Path rootFolder = Paths.get("uploads");

    @Override
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        try {
            String nombreOriginal = archivoLocalCliente.getOriginalFilename();
            String extension = nombreOriginal.substring(nombreOriginal.lastIndexOf("."));
            String nombreArchivo = UUID.randomUUID() + extension;
            Path carpetaFinal = rootFolder.resolve(carpeta);
            Path archivoFinal = carpetaFinal.resolve(nombreArchivo);
            if (!Files.exists(rootFolder)) {
                Files.createDirectory(rootFolder);
            }
            if (!Files.exists(carpetaFinal)) {
                Files.createDirectory(carpetaFinal);
            }
            Files.copy(archivoLocalCliente.getInputStream(), archivoFinal);
            return nombreArchivo;
        } catch (IOException e) {
            // Manejar la excepción adecuadamente (log, lanzar excepción personalizada, etc.)
            e.printStackTrace();
            return null;
        }
    }
}