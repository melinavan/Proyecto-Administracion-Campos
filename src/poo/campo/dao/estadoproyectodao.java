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
import poo.campo.ui.Estadocampo;
import poo.campo.ui.Estadoproyecto;

/**
 *
 * @author Normal
 */
public class estadoproyectodao {
        public static ArrayList<Estadoproyecto> getListEstadoproyecto() {
        ArrayList<Estadoproyecto> arrEstadoproyecto = new ArrayList<Estadoproyecto>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Estadoproyecto ep = null;
        String sql = "SELECT * FROM estadoproyecto";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ep = new Estadoproyecto();
                ep.setIdestadoproyecto(Integer.parseInt(rs.getString(1)));
                ep.setDescripcion(rs.getString(2));
                if (arrEstadoproyecto.isEmpty()) {
                    arrEstadoproyecto.add(0, ep);
                } else {
                    arrEstadoproyecto.add(ep);
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
        return arrEstadoproyecto;
    }
}
