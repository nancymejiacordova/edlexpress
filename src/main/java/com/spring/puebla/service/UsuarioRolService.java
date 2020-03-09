package com.spring.puebla.service;
import java.util.List;
import java.util.Optional;
import com.spring.puebla.model.Usuariorol;

/**
 *
 * @author dialv
 */
public interface UsuarioRolService {
    Iterable <Usuariorol> listAllUsuariosrol();
    
    Optional<Usuariorol> getUsuariorolById(Integer id);

    Usuariorol saveUsuariorol(Usuariorol usuariorol);

    void deleteUsuariorol(Integer id);

    public List<String> getListroles(Integer usuario);
    
}
