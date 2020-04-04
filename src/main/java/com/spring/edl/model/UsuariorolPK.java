
package com.spring.edl.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dialv
 */
@Embeddable
public class UsuariorolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOUSUARIO")
    private int codigousuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOROL")
    private int codigorol;

    public UsuariorolPK() {
    }

    public UsuariorolPK(int codigousuario, int codigorol) {
        this.codigousuario = codigousuario;
        this.codigorol = codigorol;
    }

    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }

    public int getCodigorol() {
        return codigorol;
    }

    public void setCodigorol(int codigorol) {
        this.codigorol = codigorol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigousuario;
        hash += (int) codigorol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariorolPK)) {
            return false;
        }
        UsuariorolPK other = (UsuariorolPK) object;
        if (this.codigousuario != other.codigousuario) {
            return false;
        }
        if (this.codigorol != other.codigorol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.edl.model.UsuariorolPK[ codigousuario=" + codigousuario + ", codigorol=" + codigorol + " ]";
    }
    
}
