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
import java.util.ArrayList;
import poo.campo.ui.Proyecto;


/**
 *
 * @author Normal
 */
public class proyectodao {

  
     public static Integer registrarProyecto(Proyecto pro) {
        String result = null, last = null;
        Integer id=0;               
        SimpleDateFormat d = new SimpleDateFormat("YYYY-mm-dd");  
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null; 
        String sql = "INSERT INTO proyecto values(null,?,?,?,?,?,?,?)"; //idproyecto,idlote,feinicio,fefin,idestadoproyecto,responsable,activo,idcultivo
          try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, pro.getidlote());   

            pst.setDate(2, (Date) pro.getFeinicio());
            pst.setDate(3, (Date) pro.getFefin());
            pst.setInt(4, pro.getidestadoproyecto());
            pst.setString(5, pro.getResponsable());
            pst.setBoolean(6, pro.isActivo());
            pst.setInt(7, pro.getidcultivo());   
            
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idproyecto) AS id FROM proyecto");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);       
                id=Integer.parseInt(last);           
            }
            
            result = "Campo registrado con exito, ID:" + last;
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
        return id;
    }
     
         public static String eliminarCampo(String clave) {
        String result = null;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM campo WHERE idcampo = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Campo eliminado con exito";
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

    public static ArrayList<Proyecto> getListProyectos() {
        ArrayList<Proyecto> arrProyecto = new ArrayList<Proyecto>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Proyecto c = null;
        String sql = "SELECT * FROM proyecto";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Proyecto();
                c.setIdproyecto(Integer.parseInt(rs.getString(1)));
              //  c.setDescripcion(rs.getString(2));
                if (arrProyecto.isEmpty()) {
                    arrProyecto.add(0, c);
                } else {
                    arrProyecto.add(c);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    cc.desconectar();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return arrProyecto;
    }
    
    
}
