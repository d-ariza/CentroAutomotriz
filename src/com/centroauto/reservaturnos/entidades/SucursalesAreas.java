/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jlrodriguez
 */
@Entity
@Table(name = "sucursales_areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SucursalesAreas.findAll", query = "SELECT s FROM SucursalesAreas s")
    , @NamedQuery(name = "SucursalesAreas.findByIdSucursal", query = "SELECT s FROM SucursalesAreas s WHERE s.sucursalesAreasPK.idSucursal = :idSucursal")
    , @NamedQuery(name = "SucursalesAreas.findByIdArea", query = "SELECT s FROM SucursalesAreas s WHERE s.sucursalesAreasPK.idArea = :idArea")
    , @NamedQuery(name = "SucursalesAreas.findByEstadoArea", query = "SELECT s FROM SucursalesAreas s WHERE s.estadoArea = :estadoArea")})
public class SucursalesAreas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SucursalesAreasPK sucursalesAreasPK;
    @Basic(optional = false)
    @Column(name = "estado_area")
    private String estadoArea;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Areas areas;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sucursales sucursales;

    public SucursalesAreas() {
    }

    public SucursalesAreas(SucursalesAreasPK sucursalesAreasPK) {
        this.sucursalesAreasPK = sucursalesAreasPK;
    }

    public SucursalesAreas(SucursalesAreasPK sucursalesAreasPK, String estadoArea) {
        this.sucursalesAreasPK = sucursalesAreasPK;
        this.estadoArea = estadoArea;
    }

    public SucursalesAreas(int idSucursal, int idArea) {
        this.sucursalesAreasPK = new SucursalesAreasPK(idSucursal, idArea);
    }

    public SucursalesAreasPK getSucursalesAreasPK() {
        return sucursalesAreasPK;
    }

    public void setSucursalesAreasPK(SucursalesAreasPK sucursalesAreasPK) {
        this.sucursalesAreasPK = sucursalesAreasPK;
    }

    public String getEstadoArea() {
        return estadoArea;
    }

    public void setEstadoArea(String estadoArea) {
        this.estadoArea = estadoArea;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalesAreasPK != null ? sucursalesAreasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalesAreas)) {
            return false;
        }
        SucursalesAreas other = (SucursalesAreas) object;
        if ((this.sucursalesAreasPK == null && other.sucursalesAreasPK != null) || (this.sucursalesAreasPK != null && !this.sucursalesAreasPK.equals(other.sucursalesAreasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservaturnos.entidades.SucursalesAreas[ sucursalesAreasPK=" + sucursalesAreasPK + " ]";
    }
    
}
