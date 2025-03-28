package Portafolio_DesarolloWEB.portafolio.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService extends UserDetailsService {
    
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}