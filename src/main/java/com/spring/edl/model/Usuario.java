package com.spring.edl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author dialv
 */
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGOUSUARIO")
    private Integer codigousuario;
    @Size(max = 50)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    @Size(max = 50)
    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Size(max = 100)
    @Column(name = "CONTRASENIAUSUARIO")
    private String contraseniausuario;
    @Column(name = "CONTROLCONTRASENIA")
    private String controlcontrasenia;
    @Column(name = "ESTADOUSUARIO")
    private Integer estadousuario;
    @Column(name = "FECHAINGRESO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "FECHACADUCIDAD")
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacaducidad;
    @Column(name = "FECHABAJA")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechabaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Usuariorol> usuariorolList;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dui")
    private String dui;

    public Usuario() {
    }

    public Usuario(Integer codigousuario) {
        this.codigousuario = codigousuario;
    }

    public Usuario(Integer codigousuario, String dui) {
        this.codigousuario = codigousuario;
        this.dui = dui;
    }

    public Integer getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(Integer codigousuario) {
        this.codigousuario = codigousuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContraseniausuario() {
        return contraseniausuario;
    }

    public void setContraseniausuario(String contraseniausuario) {
        this.contraseniausuario = contraseniausuario;
    }

    public String getControlcontrasenia() {
        return controlcontrasenia;
    }

    public void setControlcontrasenia(String controlcontrasenia) {
        this.controlcontrasenia = controlcontrasenia;
    }

    public Integer getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(Integer estadousuario) {
        this.estadousuario = estadousuario;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public List<Usuariorol> getUsuariorolList() {
        return usuariorolList;
    }

    public void setUsuariorolList(List<Usuariorol> usuariorolList) {
        this.usuariorolList = usuariorolList;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigousuario != null ? codigousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigousuario == null && other.codigousuario != null) || (this.codigousuario != null && !this.codigousuario.equals(other.codigousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.edl.model.Usuario[ codigousuario=" + codigousuario + " ]";
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
    
}
