package com.spring.edl.service;

import java.util.Optional;
import com.spring.edl.model.Usuario;

/**
 *
 * @author dialv
 */
public interface UsuarioService {
    Iterable <Usuario> listAllUsuarios();
    
    Optional<Usuario> getUsuarioById(Integer id);

    Usuario saveUsuario(Usuario usuario);

    void deleteUsuario(Integer id);

    Iterable<Usuario> listAllActivos();
    
    Usuario findbyUser(String
            usuario);
}
