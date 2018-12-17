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
import poo.campo.ui.Tiposuelo;

/**
 *
 * @author Normal
 */
public class tiposuelodao {
    
     public static ArrayList<Tiposuelo> getListTiposuelo() {
        ArrayList<Tiposuelo> arrts = new ArrayList<Tiposuelo>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Tiposuelo c = null;
        String sql = "SELECT * FROM tiposuelo";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Tiposuelo();
                c.setIdtiposuelo(Integer.parseInt(rs.getString(1)));
                c.setDescripcion(rs.getString(3));
                if (arrts.isEmpty()) {
                    arrts.add(0, c);
                } else {
                    arrts.add(c);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return arrts;
    }
}
