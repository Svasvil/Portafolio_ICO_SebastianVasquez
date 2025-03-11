package Portafolio_DesarolloWEB.portafolio.dao;

/**
 * Interfaz para acceder a los datos de los productos en la base de datos.
 * Extiende JpaRepository para facilitar operaciones CRUD.
 */

import Portafolio_DesarolloWEB.portafolio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
}