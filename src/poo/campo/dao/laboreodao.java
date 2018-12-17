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
import poo.campo.ui.Laboreo;
import poo.campo.ui.Lote;

/**
 *
 * @author Normal
 */
public class laboreodao {
    
    
   public static ArrayList<Laboreo> buscarLaboreosConMatriz() {
        ArrayList<Laboreo> arrLaboreo = new ArrayList<Laboreo>();
       
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Laboreo la = null;
        String sql = "SELECT * FROM laboreo" ;
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             
                la = new Laboreo();
                la.setIdlaboreo(Integer.parseInt(rs.getString(1)));
                la.setDescripcion(rs.getString(3));
                    
                if (arrLaboreo.isEmpty()) {
                    arrLaboreo.add(0, la);
                } else {
                    arrLaboreo.add(la);
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
        return arrLaboreo;
    }
   
     public static ArrayList<Laboreo> buscarLaboreosNoAsignados(Integer idcultivo) {
        ArrayList<Laboreo> arrLaboreo = new ArrayList<Laboreo>();
        Integer id=0;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Laboreo la = null;
        String sql = "select  laboreo.idlaboreo,laboreo.descripcion, (select IFNULL(cultivolaboreo.idcultivolaboreo,0))\n" +
        "from laboreo\n" +
        "left join cultivolaboreo on laboreo.idlaboreo = cultivolaboreo.idlaboreo\n" +
        "left join cultivo on cultivolaboreo.idcultivo= cultivo.idcultivo\n" +
        "where  (cultivolaboreo.idcultivo=" + idcultivo + " or cultivolaboreo.idcultivo is null) and  laboreo.activo=1" ;
         try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id=Integer.parseInt(rs.getString(3));
                //SI NO ES UN LABOR ASIGNADO AL CULTIVO
                if (id==0){
                    la = new Laboreo();
                    la.setIdlaboreo(Integer.parseInt(rs.getString(1)));
                    la.setDescripcion(rs.getString(2));

                    if (arrLaboreo.isEmpty()) {
                        arrLaboreo.add(0, la);
                    } else {
                        arrLaboreo.add(la);
                    }
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
        return arrLaboreo;
    }
   /*
   
   select laboreo.idlaboreo,laboreo.descripcion, ( select IFNULL(cultivolaboreo.idcultivolaboreo,0) )
from laboreo
left join cultivolaboreo on laboreo.idlaboreo = cultivolaboreo.idlaboreo
left join cultivo on cultivolaboreo.idcultivo= cultivo.idcultivo

where laboreo.activo=1

   */
   
   
}
