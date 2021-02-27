/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jlrodriguez
 */
@Embeddable
public class SucursalesAreasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private int idSucursal;
    @Basic(optional = false)
    @Column(name = "id_area")
    private int idArea;

    public SucursalesAreasPK() {
    }

    public SucursalesAreasPK(int idSucursal, int idArea) {
        this.idSucursal = idSucursal;
        this.idArea = idArea;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSucursal;
        hash += (int) idArea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalesAreasPK)) {
            return false;
        }
        SucursalesAreasPK other = (SucursalesAreasPK) object;
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idArea != other.idArea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservaturnos.entidades.SucursalesAreasPK[ idSucursal=" + idSucursal + ", idArea=" + idArea + " ]";
    }
    
}
