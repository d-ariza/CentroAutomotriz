package com.centroauto.reservaturnos.model;

import com.centroauto.reservaturnos.dto.SucursalesDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase que representa el modelo para la tabla de sucursales
 * @author jlrodriguez
 */
public class SucursalesModel extends AbstractTableModel{
    public static final int COL_ID_SUCURSAL = 0;
    public static final int COL_NOM_SUCURSAL = 1;
    public static final int COL_DIR_SUCURSAL = 2;
    public static final int COL_TEL_SUCURSAL = 3;
    public static final int COL_NOM_CIUDAD = 4;
    public static final int COL_NOM_DEPTO = 5;
    public static final int COL_OBJECT = -1;

    private String[] columnNames = {"ID", "NOMBRE", "DIRECCIÓN", "TELÉFONO",
                                    "CIUDAD", "DEPARTAMENTO"};
    private List<SucursalesDTO> lstSucursales;

    public SucursalesModel(List<SucursalesDTO> lstSucursales) {
        this.lstSucursales = lstSucursales;
    }
      
    public int getColumnCount(){
        return columnNames.length;
    }  
    
    public int getRowCount(){
        if(lstSucursales != null && lstSucursales.size() > 0){
            return lstSucursales.size();
        }else{
            return 0;
        }
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
      
    public Object getValueAt(int row, int col){
        SucursalesDTO s = lstSucursales.get(row);
        switch(col){
            case COL_ID_SUCURSAL:
                return s.getIdSucursal();
            case COL_NOM_SUCURSAL:
                return s.getNomSucursal();
            case COL_DIR_SUCURSAL:
                return s.getDirSucursal();
            case COL_TEL_SUCURSAL:
                return s.getTelSucursal();
            case COL_NOM_CIUDAD:
                return s.getNomCiudad();
            case COL_NOM_DEPTO:
                return s.getNomDepto();
            case COL_OBJECT:
                return s;
            default:
                return s;                        
        }
    }
}
