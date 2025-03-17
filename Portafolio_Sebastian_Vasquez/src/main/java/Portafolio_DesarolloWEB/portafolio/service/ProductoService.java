package Portafolio_DesarolloWEB.portafolio.service;

import Portafolio_DesarolloWEB.portafolio.domain.Producto;
import java.util.List;

/**
 * Define los servicios para gestionar productos.
 * Permite obtener, guardar y eliminar productos.
 */
public interface ProductoService {

    List<Producto> getProductos(boolean activo);

    Producto getProducto(Producto producto);

    void save(Producto producto);

    void delete(Producto producto);

    // Lista de productos con precio entre ordenados por descripción ConsultaAmpliada
    List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Lista de productos utilizando consultas con JPQL
    List<Producto> metodoJPQL(double precioInf, double precioSup);

    // Lista de productos utilizando consultas con SQL Nativo
    List<Producto> metodoNativo(double precioInf, double precioSup);
    
    //Lista para filtrar los productos por activo
     public List<Producto> findByActivoOrderByDescripcion(boolean activo);
}