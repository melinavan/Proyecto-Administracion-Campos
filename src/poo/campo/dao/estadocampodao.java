package poo.campo.dao;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poo.campo.ui.Estadocampo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Normal
 */
public class estadocampodao {
    private final String tabla = "estadocampo"; 

    
    
     public void guardar(Connection conexion, Estadocampo ec) throws SQLException{
      try{
         PreparedStatement consulta;
         if(ec.getIdestadoCampo() == null){
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(descripcion, activo) VALUES(?, ?)");
            consulta.setString(1, ec.getDescripcion());
            consulta.setBoolean(2, ec.isActivo());
         }else{
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET  descripcion = ?, activo = ? WHERE idestadoCampo = ?");
            consulta.setString(1, ec.getDescripcion());
            consulta.setBoolean(2, ec.isActivo());
            consulta.setInt(3, ec.getIdestadoCampo());
         }
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public Estadocampo recuperarPorId(Connection conexion, int idestadoCampo) throws SQLException {
      Estadocampo ec = null;
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT descripcion, activo FROM " + this.tabla + " WHERE idestadoCampo = ?" );
         consulta.setInt(1, idestadoCampo);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            ec = new Estadocampo(resultado.getString("descripcion"), resultado.getBoolean("activo"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return ec;
   }
   public void eliminar(Connection conexion, Estadocampo ec) throws SQLException{
      try{
         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idestadoCampo = ?");
         consulta.setInt(1, ec.getIdestadoCampo());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public List<Estadocampo> recuperarTodas(Connection conexion) throws SQLException{
      List<Estadocampo> ecLista = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT  descripcion, activo FROM " + this.tabla + " ORDER BY descripcion");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            ecLista.add(new Estadocampo(  resultado.getString("descripcion"), resultado.getBoolean("activo")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return ecLista;
   }
    
        public static ArrayList<Estadocampo> getListEstadocampo() {
        ArrayList<Estadocampo> arrCampos = new ArrayList<Estadocampo>();
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        Estadocampo c = null;
        String sql = "SELECT * FROM estadocampo";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Estadocampo();
                c.setIdestadoCampo(Integer.parseInt(rs.getString(1)));
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
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return arrCampos;
    }
}
