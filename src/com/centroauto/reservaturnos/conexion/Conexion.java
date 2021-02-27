package com.centroauto.reservaturnos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Clase que realiza la conexión a la base de datos
 * @version 1.0
 * @since 25/08/2020
 * @author jlrodriguez
 */
public class Conexion {
    /**
     * Objeto que almacena la conexión a la BD
     */
    private Connection con;
    
    public Connection conectarBD() throws Exception{
        Properties prop = new Properties();
        prop.load(getClass().getResourceAsStream("/com/centroauto/reservaturnos/propiedades/Conexion.properties"));
        
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        //Abrir conexión
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
}
