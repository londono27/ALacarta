/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.DAO;

import Control.Conexion.Conectar;
import Controlador.Controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TablasDAO {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Controlador cr;
    
    public TablasDAO() {
        con = null;
        st = null;
        rs = null;
    }
    
    
    
    public ArrayList listaDeCliente() {
        ArrayList misUsuarios = new ArrayList();
        String consulta = "SELECT * FROM cliente";
        try {
            con = Conectar.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getInt("Cliente_ID"));
                System.out.println(rs.getInt("No_Of_Guest"));
                System.out.println(rs.getString("Cliente_Nombre"));
            }
            st.close();
            Conectar.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la consulta");
        }
        return null;
    }
    
    public void insertarCliente(int Cliente_ID, int No_Of_Guest, String Cliente_Nombre) {
        try {
            con = Conectar.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO cliente VALUES( " + Cliente_ID + 
                    "," + No_Of_Guest + ",'" + Cliente_Nombre+"')";
            st.executeUpdate(insercion);
            st.close();
        } catch (SQLException ex) {
           System.out.print("No se pudo realizar la insercion");
            System.out.println("Probablemente el usuario con id repetido.");
        }
    }
    
    public boolean modificarVino(int codigo, String dato, String cambio) {
        String consulta = "update vino set "+dato+"= '"+ cambio +"' where codigo=" + codigo + "";
        try {
            con = Conectar.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conectar.desconectar();
            return true;
        } catch (SQLException ex) {
            cr.mandarMensaje("No se pudo realizar la modifcacion");
        }
        return false;
    }
    
    public boolean eliminarDato(int codigo, String tabla) {
        String consulta = "DELETE FROM "+tabla+" where codigo=" + codigo +"";
        try {
            con = Conectar.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conectar.desconectar();
            return true;
        } catch (SQLException ex) {
            cr.mandarMensaje("No se pudo realizar la eliminacion");
        }
        return false;
    }
}
