package Portafolio_DesarolloWEB.portafolio.controller;

import Portafolio_DesarolloWEB.portafolio.domain.Categoria;
import Portafolio_DesarolloWEB.portafolio.service.CategoriaService;
import Portafolio_DesarolloWEB.portafolio.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria,
                                   @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Guarda primero para obtener el ID
            categoriaService.save(categoria);
            
            // Carga la imagen y actualiza la ruta
            categoria.setRutaImagen(
                firebaseStorageService.cargaImagen(
                    imagenFile, 
                    "categoria", 
                    categoria.getIdCategoria()
                )
            );
            
            // Guarda con la ruta de imagen actualizada
            categoriaService.save(categoria);
        } else {
            // Si no hay imagen, guarda directamente
            categoriaService.save(categoria);
        }
        
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(@PathVariable("idCategoria") Long idCategoria) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(@PathVariable("idCategoria") Long idCategoria, Model model) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}