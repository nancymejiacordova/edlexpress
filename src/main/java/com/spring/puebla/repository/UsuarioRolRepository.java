package com.spring.puebla.repository;

import java.util.List;
import com.spring.puebla.model.Usuariorol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRolRepository extends CrudRepository<Usuariorol, Integer>{
    @Query("SELECT o.rol.nombrerol FROM Usuariorol o WHERE o.usuario.codigousuario=?1")
    public List<String> getListroles(Integer codigo);

}
