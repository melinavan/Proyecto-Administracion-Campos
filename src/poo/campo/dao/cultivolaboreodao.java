/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.campo.dao;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poo.campo.ui.Cultivolaboreo;
import poo.campo.ui.Lote;

/**
 *
 * @author Normal
 */
public class cultivolaboreodao {
    
    public static ArrayList<Cultivolaboreo> buscarLaboreosSegunCultivoMatriz(int idcultivo) {
        
        ArrayList<Cultivolaboreo> arrcullab = new ArrayList<Cultivolaboreo>();
       
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Cultivolaboreo la = null;
        String sql = "SELECT cultivolaboreo.Idcultivolaboreo,cultivolaboreo.idcultivo, cultivolaboreo.idlaboreo, cultivolaboreo.orden,cultivo.descripcion,laboreo.descripcion,cultivolaboreo.orden FROM cultivolaboreo \n" +
            "left join cultivo \n" +
            "on cultivo.idcultivo=cultivolaboreo.idcultivo \n" +
            "left join laboreo \n" +
            "on laboreo.idlaboreo=cultivolaboreo.idlaboreo\n" +
            "Where cultivolaboreo.activo="+1 +" and cultivo.idcultivo ="+ idcultivo + " order by cultivolaboreo.orden" ;
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             
                la = new Cultivolaboreo();
                la.setIdcultivolaboreo(Integer.parseInt(rs.getString(1)));
                la.setidCultivo(Integer.parseInt(rs.getString(2)));
                la.setidLaboreo(Integer.parseInt(rs.getString(3)));
                la.setOrden(Integer.parseInt(rs.getString(4)));
                la.setDescLaboreo(rs.getString(6));
                la.setOrden(Integer.parseInt(rs.getString(7)));
                    
                if (arrcullab.isEmpty()) {
                    arrcullab.add(0, la);
                } else {
                    arrcullab.add(la);
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
        return arrcullab;
    }
      public static Integer getidCultivolaboreo(int idlaboreo, int idcultivo) {
        Integer id=0;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        
        String sql = "SELECT idcultivolaboreo FROM cultivolaboreo WHERE idlaboreo=" + idlaboreo + " and idcultivo="  +idcultivo; 
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {               
                id=(Integer.parseInt(rs.getString(1)));
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
        return id;
    }
    
    
    
}
