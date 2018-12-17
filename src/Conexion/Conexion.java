/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Normal
 */
    
public class Conexion {

    Connection conectar  = null;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/camposadmin","root","Administra");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection(){
        return conectar;
    }
    public void desconectar(){
        conectar = null;
    }
}

