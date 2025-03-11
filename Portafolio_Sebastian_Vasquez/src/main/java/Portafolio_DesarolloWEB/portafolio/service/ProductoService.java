package Portafolio_DesarolloWEB.portafolio.service;

import Portafolio_DesarolloWEB.portafolio.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activo);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);

    public void delete(Producto producto);
}