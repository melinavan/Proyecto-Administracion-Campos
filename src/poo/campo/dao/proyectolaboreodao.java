/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.campo.dao;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import poo.campo.ui.Proyectolaboreo;

/**
 *
 * @author Normal
 */
public class proyectolaboreodao {
    public static String registrarProyectoLaboreo(Proyectolaboreo pl) {
        String result = null, last = null;
        Integer id=0;
        SimpleDateFormat d = new SimpleDateFormat("YYYY-mm-dd");              
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null; 
        String sql = "INSERT INTO Proyectolaboreo values(null,?,?,?,?,?,?)"; //idproyecto,idlaboreo,fecha,nota,idlaboreocultivo,activo
        try {
            pst = cn.prepareStatement(sql);            
            pst.setInt(1, pl.getidproyecto());
            pst.setInt(2, pl.getIdLaboreo()); 
            pst.setDate(3,(Date)pl.getFecha());
            pst.setString(4, pl.getNota());
            pst.setInt(5, pl.getIdlaboreocultivo());
            pst.setBoolean(6, true);     
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idproyectolaboreo) AS id FROM proyectolaboreo");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);       
                id=Integer.parseInt(last);           
            }
            result = "Labor registrado con exito, ID:" + last;
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }
}
