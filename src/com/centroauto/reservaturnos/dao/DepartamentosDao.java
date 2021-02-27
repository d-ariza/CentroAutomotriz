/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.dao;

import com.centroauto.reservaturnos.conexion.Conexion;
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
public class DepartamentosDao {
    private Connection con;
    private Conexion conexion;
    
    public List<Departamentos> consultarDepartamentos() throws Exception{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        List<Departamentos> lstDeptos = new ArrayList<Departamentos>();
        Departamentos d = new Departamentos();
        try{          
            conexion = new Conexion();
            con = conexion.conectarBD();
        
          pstm = con.prepareStatement("select id_depto, nom_depto from departamentos");
          rs = pstm.executeQuery();
          while(rs.next()){
              d = new Departamentos();
              d.setIdDepto(rs.getInt("id_depto"));
              d.setNomDepto(rs.getString("nom_depto"));
              lstDeptos.add(d);
          }
          return lstDeptos;
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            rs.close();
            con.close();
        }
        
    }
}
