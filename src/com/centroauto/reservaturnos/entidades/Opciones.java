/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jlrodriguez
 */
@Entity
@Table(name = "opciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o")
    , @NamedQuery(name = "Opciones.findByIdOpcion", query = "SELECT o FROM Opciones o WHERE o.idOpcion = :idOpcion")
    , @NamedQuery(name = "Opciones.findByFuncionalidad", query = "SELECT o FROM Opciones o WHERE o.funcionalidad = :funcionalidad")
    , @NamedQuery(name = "Opciones.findByRuta", query = "SELECT o FROM Opciones o WHERE o.ruta = :ruta")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private Integer idOpcion;
    @Basic(optional = false)
    @Column(name = "funcionalidad")
    private String funcionalidad;
    @Basic(optional = false)
    @Column(name = "ruta")
    private String ruta;
    @JoinTable(name = "opciones_usuarios", joinColumns = {
        @JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion")}, inverseJoinColumns = {
        @JoinColumn(name = "nro_doc_usu", referencedColumnName = "nro_doc_usu")})
    @ManyToMany
    private List<Usuarios> usuariosList;

    public Opciones() {
    }

    public Opciones(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Opciones(Integer idOpcion, String funcionalidad, String ruta) {
        this.idOpcion = idOpcion;
        this.funcionalidad = funcionalidad;
        this.ruta = ruta;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservaturnos.entidades.Opciones[ idOpcion=" + idOpcion + " ]";
    }
    
}
