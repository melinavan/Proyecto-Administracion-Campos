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
import poo.campo.ui.Cultivo;


/**
 *
 * @author Normal
 */
public class cultivodao {
    public static ArrayList<Cultivo> getListCultivo(int idsuelo ) {
        ArrayList<Cultivo> arrCultivo = new ArrayList<Cultivo>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Cultivo cu = null;
        String sql = "SELECT * FROM camposadmin.tiposuelocultivo left join cultivo on tiposuelocultivo.idcultivo= cultivo.idcultivo Where idtiposuelo="+idsuelo ;
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cu = new Cultivo();
                cu.setIdcultivo(Integer.parseInt(rs.getString(5)));
                cu.setDescripcion(rs.getString(6));
                if (arrCultivo.isEmpty()) {
                    arrCultivo.add(0, cu);
                } else {
                    arrCultivo.add(cu);
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
        return arrCultivo;
    }
    
    
   
}
