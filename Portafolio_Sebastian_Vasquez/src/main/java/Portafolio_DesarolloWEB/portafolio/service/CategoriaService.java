
package Portafolio_DesarolloWEB.portafolio.service;

import Portafolio_DesarolloWEB.portafolio.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias(boolean activos);

}