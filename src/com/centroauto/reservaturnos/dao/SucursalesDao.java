/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservaturnos.dao;

import com.centroauto.reservaturnos.conexion.Conexion;
import com.centroauto.reservaturnos.dto.SucursalesDTO;
import com.centroauto.reservaturnos.entidades.Sucursales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 * Clase que contiene las operaciones CRUD para la entidad Sucursales
 * @since 25/08/2020
 * @version 1.0
 * @author jlrodriguez
 */
public class SucursalesDao {
    private Connection con;
    private Conexion conexion;
    
    public List<SucursalesDTO> consultarSucursales(String nomSucursal, Integer idCiudad) throws Exception{
        List<SucursalesDTO> lstSucursales = new ArrayList<>();
        SucursalesDTO sucursal = new SucursalesDTO();
        
        String sql = "";
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        //Conectar a la BD
        conexion = new Conexion();
        con = conexion.conectarBD();
        
        //Sentecia para devolver TODOS los registros de sucursales
        sql = "select s.id_sucursal, s.nom_sucursal, s.dir_sucursal, s.tel_sucursal, " +
              "c.id_ciudad, c.nom_ciudad, d.id_depto, d.nom_depto " +
              "from sucursales s INNER JOIN ciudades c ON (s.id_ciudad = c.id_ciudad) " +
              "INNER JOIN departamentos d ON (d.id_depto = c.id_depto) WHERE 1=1 ";
        //Filtro para nomSucursal
        if(nomSucursal != null){
            sql += "AND nom_sucursal LIKE '%"+nomSucursal+"%' ";
        }
        //Filtro para idCiudad
        if(idCiudad != null){
            sql += "AND c.id_ciudad = "+idCiudad;
        }
        
        try{
            //Preparar consulta para ejecutar en BD
            pstm = con.prepareStatement(sql);
            //Ejecutar consulta y obtener resultado en el ResultSet
            rs = pstm.executeQuery();
            //Recorrer los resultados para armar la Lista de Sucursales
            while(rs.next()){
                //Armar cada objeto de sucursal
                sucursal = new SucursalesDTO();
                sucursal.setIdSucursal(rs.getInt("id_sucursal"));
                sucursal.setNomSucursal(rs.getString("nom_sucursal"));
                sucursal.setDirSucursal(rs.getString("dir_sucursal"));
                sucursal.setTelSucursal(rs.getLong("tel_sucursal"));
                sucursal.setIdCiudad(rs.getInt("id_ciudad"));
                sucursal.setNomCiudad(rs.getString("nom_ciudad"));
                sucursal.setIdDepto(rs.getInt("id_depto"));
                sucursal.setNomDepto(rs.getString("nom_depto"));
                //Agregar a la lista de sucursales
                lstSucursales.add(sucursal);                
            }
            return lstSucursales;            
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            rs.close();
            con.close();
        }
    }
    
    public void insertarSucursal(SucursalesDTO sucursal) throws Exception{
        //Conectar a la BD
        conexion = new Conexion();
        con = conexion.conectarBD();
        
        PreparedStatement pstm = null;
        
        try{
            //Preparar la sentencia insert
            pstm =con.prepareStatement("INSERT INTO sucursales (nom_sucursal, "
                    + "dir_sucursal, tel_sucursal, id_ciudad) VALUES (?,?,?,?) ");
            //Reemplazar parametros por valores que ingresan en sucursal
            pstm.setString(1, sucursal.getNomSucursal());
            pstm.setString(2, sucursal.getDirSucursal());
            pstm.setLong(3, sucursal.getTelSucursal());
            pstm.setInt(4, sucursal.getIdCiudad());
            //Ejecutar la sentencia insert en la BD
            pstm.executeUpdate();
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            con.close();
        }
    }
    
    public void actualizarSucursal(SucursalesDTO sucursal) throws Exception{
        //Conectar a la BD
        conexion = new Conexion();
        con = conexion.conectarBD();
        
        PreparedStatement pstm = null;
        
        try{
            pstm = con.prepareStatement("update sucursales set nom_sucursal = ?, " +
                        "dir_sucursal = ?, tel_sucursal = ? " +
                        "where id_sucursal = ? ");
            pstm.setString(1, sucursal.getNomSucursal());
            pstm.setString(2, sucursal.getDirSucursal());
            pstm.setLong(3, sucursal.getTelSucursal());
            pstm.setInt(4, sucursal.getIdSucursal());
            //Ejecutar sentencia en BD
            pstm.executeUpdate();
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            con.close();
        }
    }
    
    public void eliminarSucursal(Integer idSucursal) throws Exception{
       //Conectar a la BD
       conexion = new Conexion();
       con = conexion.conectarBD();
       
       PreparedStatement pstm = null;
       
       try{
           pstm = con.prepareStatement("delete from sucursales where id_sucursal = ?");
           pstm.setInt(1, idSucursal);           
           pstm.executeUpdate();           
       }catch(Exception e){
           throw new Exception(e);
       }finally{
           pstm.close();
           con.close();
       }
    }
}
