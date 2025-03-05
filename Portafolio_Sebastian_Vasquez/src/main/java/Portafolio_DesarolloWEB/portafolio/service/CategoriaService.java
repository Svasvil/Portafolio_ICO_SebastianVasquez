
package Portafolio_DesarolloWEB.portafolio.service;

import Portafolio_DesarolloWEB.portafolio.domain.Categoria;
import java.util.List;

public interface CategoriaService {

      public List<Categoria> getCategorias(boolean activos);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Categoria getCategoria(Categoria categoria);

    // Se inserta un nuevo categoria si el id del categoria esta vacio
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Categoria categoria);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);
}