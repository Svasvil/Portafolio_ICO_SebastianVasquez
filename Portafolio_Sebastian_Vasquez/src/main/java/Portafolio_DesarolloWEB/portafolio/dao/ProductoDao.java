package Portafolio_DesarolloWEB.portafolio.dao;

import Portafolio_DesarolloWEB.portafolio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
}