/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.dao;

import com.centroauto.reservaturnos.conexion.Conexion;
import com.centroauto.reservaturnos.dto.CiudadesDTO;
import com.centroauto.reservaturnos.entidades.Departamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jlrodriguez
 */
public class CiudadesDao {
    private Connection con;
    private Conexion conexion;
    
    public List<CiudadesDTO> consultarCiudadesPorDepto(Integer idDepto) throws Exception{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List<CiudadesDTO> lstCiudades = new ArrayList<CiudadesDTO>();
        CiudadesDTO c = new CiudadesDTO();
        try{          
            conexion = new Conexion();
            con = conexion.conectarBD();
        
          pstm = con.prepareStatement("select c.id_ciudad, c.nom_ciudad,"
                  + "d.id_depto, d.nom_depto "
                  + " from departamentos d inner join ciudades c "
                  + " on (d.id_depto = c.id_depto)"
                  + " where d.id_depto = ?");
          pstm.setInt(1, idDepto);
          rs = pstm.executeQuery();
          while(rs.next()){
              c = new CiudadesDTO();
              c.setIdCiudad(rs.getInt("id_ciudad"));
              c.setNomCiudad(rs.getString("nom_ciudad"));
              c.setIdDepto(rs.getInt("id_depto"));
              c.setNomDepto(rs.getString("nom_depto"));
              lstCiudades.add(c);
          }
          return lstCiudades;
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            rs.close();
            con.close();
        }
        
    }
}
