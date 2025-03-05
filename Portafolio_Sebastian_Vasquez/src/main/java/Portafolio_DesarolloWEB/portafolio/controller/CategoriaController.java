package Portafolio_DesarolloWEB.portafolio.controller;

import Portafolio_DesarolloWEB.portafolio.domain.Categoria;
import Portafolio_DesarolloWEB.portafolio.service.CategoriaService;
import Portafolio_DesarolloWEB.portafolio.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
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