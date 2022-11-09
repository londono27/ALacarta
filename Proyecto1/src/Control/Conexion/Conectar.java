/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class Conectar {
    
    private static Connection cn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;


    /**
     * 
     */
    private Conectar() {
        
        url = "jdbc:mysql://localhost:3306/rotondacomida";
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuario, password);
            JOptionPane.showMessageDialog(null, "Conexión establecida con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión");
        }
    }
    
    public static void desconectar() {
        cn = null;
    }

    // SINGLETON - retorna una unica instancia de la conexion
    public static Connection getConexion(){
        if(cn == null){
            new Conectar();
        }
        return cn;
        
    }
}