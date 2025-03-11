package Portafolio_DesarolloWEB.portafolio.service;
/**
 * Define los servicios para gestionar productos.
 * Permite obtener, guardar y eliminar productos.
 */

import Portafolio_DesarolloWEB.portafolio.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activo);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);

    public void delete(Producto producto);
}