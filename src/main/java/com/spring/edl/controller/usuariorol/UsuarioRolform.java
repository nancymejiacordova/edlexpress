package com.spring.edl.controller.usuariorol;

import java.io.Serializable;
import com.spring.edl.model.Rol;
import com.spring.edl.model.Usuario;
import com.spring.edl.model.Usuariorol;

/**
 *
 * @author root
 */
public class UsuarioRolform implements Serializable{
    
    private Iterable<Usuario> usuarios ;
    private Iterable<Rol> roles ;
    private Usuariorol usuariorol ;

    public Iterable<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Iterable<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Iterable<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Iterable<Rol> roles) {
        this.roles = roles;
    }

    public Usuariorol getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(Usuariorol usuariorol) {
        this.usuariorol = usuariorol;
    }
    
    
}
