package com.spring.edl.repository;

import com.spring.edl.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    @Query("SELECT o FROM Usuario o WHERE o.estadousuario != 0 and o.nombreusuario=?1")
    public Usuario findbyusername(String username);
    
    @Query("SELECT o FROM Usuario o WHERE o.estadousuario != 0")
    public Iterable<Usuario> listAllActivos(); 
}
