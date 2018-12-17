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
import poo.campo.ui.Lote;

/**
 *
 * @author Normal
 */
public class lotedao {
    
    public static ArrayList<Lote> getListLote(int idcampo) {
        ArrayList<Lote> arrLote = new ArrayList<Lote>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Lote l = null;
        String sql = "SELECT * FROM lote WHERE idcampo=" + idcampo;
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l = new Lote();
                    l.setIdlote(Integer.parseInt(rs.getString(1)));
                    l.setDescripcion(rs.getString(3));
                    
                if (arrLote.isEmpty()) {
                    arrLote.add(0, l);
                } else {
                    arrLote.add(l);
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
        return arrLote;
    }
    
     public static int BuscarTiposuelo(int id){
        int idTiposuelo=0;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
       
        String sql = "SELECT * FROM lote WHERE idlote="+id;
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();            
            while (rs.next()) {
                idTiposuelo=rs.getInt(5);
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
        return idTiposuelo;
    }
     
     public static String registrarLote(Lote lo) {
        String result = null, last = null;
        Integer id=0;
               
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null; 
        String sql = "INSERT INTO lote values(null,?,?,?,?,?)"; //numero,descripcion,superficie,idtiposuelo,idcampo
        
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, lo.getNumero());
            pst.setString(2, lo.getDescripcion());
            pst.setInt(3, lo.getSuperficie());    
            pst.setInt(4, lo.getidTipoSuelo());   
            pst.setInt(5, lo.getidCampo());   
            pst.execute();   
            
            pst = cn.prepareStatement("SELECT MAX(idlote) AS id FROM lote");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);       
                id=Integer.parseInt(last);           
            }
            
            result = "Lote registrado con exito, ID:" + last;
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
