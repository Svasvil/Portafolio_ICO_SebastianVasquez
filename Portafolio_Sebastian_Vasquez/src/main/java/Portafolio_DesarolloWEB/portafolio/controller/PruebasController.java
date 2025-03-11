package Portafolio_DesarolloWEB.portafolio.controller;

import Portafolio_DesarolloWEB.portafolio.domain.Categoria;
import Portafolio_DesarolloWEB.portafolio.service.CategoriaService;
import Portafolio_DesarolloWEB.portafolio.service.ProductoService; // Importación corregida
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Importación agregada
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, @PathVariable("idCategoria") Long idCategoria) {
        var productos = productoService.getProductos(false).stream()
                .filter(producto -> producto.getCategoria().getIdCategoria().equals(idCategoria))
                .toList();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
}