/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.campo.dao;
import poo.campo.ui.Campo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Normal
 */
public class campodao {
    
    
    public static Integer registrarCampo(Campo c) {
        String result = null, last = null;
        Integer id=0;
               
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null; 
        String sql = "INSERT INTO campo values(null,?,?,?,?)";
        
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, c.getDescripcion());
            pst.setInt(2, c.getSuperficie());
            pst.setBoolean(3, c.isActivo());
            pst.setInt(4, c.getidestadocampo());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idcampo) AS id FROM campo");
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

    public static String actualizarCampo(Campo c) {
        String result = null;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE campo SET descripcion=?,superficie=?,activo=?,idestadocampo=? WHERE idcampo=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, c.getDescripcion());
            pst.setInt(2, c.getSuperficie());
            pst.setBoolean(3, c.isActivo());
            pst.setInt(4, c.getEstadocampo().getIdestadoCampo());
            pst.setInt(5, c.getIdcampo());
            pst.execute();

          //  result = "Proveedor actualizado con exito, ID:" + c.getId_ceedor();
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            
            try {
                if (cn != null) {
                    cn.close()
                            ;
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static Campo buscarCampo(String clave) {
        Campo c = new Campo();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM campo WHERE idcampo = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setIdcampo(Integer.parseInt(rs.getString(1)));
                c.setDescripcion(rs.getString(2));
                c.setSuperficie(Integer.parseInt(rs.getString(3)));
                c.setEstadocampo(null);
                c.setActivo(rs.getBoolean(4));
            }
            c.setResultado("Busqueda exitosa");
        } catch (SQLException e) {
            c.setResultado("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                c.setResultado("Error: " + e);
            }
        }
        return c;
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

    public static ArrayList<Campo> getListCampos() {
        ArrayList<Campo> arrCampos = new ArrayList<Campo>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Campo c = null;
        String sql = "SELECT * FROM campo";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Campo();
                c.setIdcampo(Integer.parseInt(rs.getString(1)));
                c.setDescripcion(rs.getString(2));
                if (arrCampos.isEmpty()) {
                    arrCampos.add(0, c);
                } else {
                    arrCampos.add(c);
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
        return arrCampos;
    }
    public static String VerReporte(String dir) throws JRException{
        String result = null;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
                             
        //C:\Users\Normal\Documents\NetBeansProjects\AdministraCampo\src\Reportes\JrCampos.jrxml

        JasperReport reporte = JasperCompileManager.compileReport(dir);
        
        JasperPrint mostrar = JasperFillManager.fillReport(reporte, null, cn);
        JasperViewer.viewReport(mostrar);
        return result;
        
    }    

    
    
}
