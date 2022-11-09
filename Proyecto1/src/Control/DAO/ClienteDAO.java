/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.DAO;

import Control.Conexion.Conectar;
import Controlador.Controlador;
import Modelo.ClienteVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Controlador cr;
    
    public ClienteDAO() {
        con = null;
        st = null;
        rs = null;
    }
    
    public ArrayList<ClienteVO> listaDeCliente() {
        ArrayList misClientes = new ArrayList();
        String consulta = "SELECT * FROM cliente";
        try {
            con = Conectar.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ClienteVO cliente = new ClienteVO();
                cliente.setCliente_ID(rs.getInt("Cliente_ID"));
                cliente.setNo_Of_Guest(rs.getInt("No_Of_Guest"));
                cliente.setCliente_Nombre(rs.getString("Cliente_Nombre"));
                misClientes.add(cliente);
            }
            st.close();
            Conectar.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la consulta");
        }
        return misClientes;
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
}
