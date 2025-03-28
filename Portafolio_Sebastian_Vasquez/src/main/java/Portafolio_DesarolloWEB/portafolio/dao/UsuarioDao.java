
package Portafolio_DesarolloWEB.portafolio.dao;
import Portafolio_DesarolloWEB.portafolio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}