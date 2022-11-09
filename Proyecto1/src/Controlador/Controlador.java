/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Control.DAO.ClienteDAO;
import Control.DAO.TablasDAO;
import Modelo.ClienteVO;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public final class Controlador {
    
    ClienteDAO tablaCliente;
    TablasDAO tablitas; 

    public Controlador() {
        tablitas = new TablasDAO();
        tablaCliente = new ClienteDAO();
        System.out.println("");
//        Connection cn = (Connection) Conectar.getConexion();
//        if (cn != null){
//            JOptionPane.showInputDialog("CONEXION ESTABLECIDA");
//        }
        mirarClientes();
        crearCliente();
        mirarClientes();
    }
    
    public void crearCliente(){
        Scanner sc = new Scanner(System.in);
        int id, guest;
        String nombre; 
        
        System.out.println("Ingrese el id: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el guest: ");
        guest = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre: ");
        nombre = sc.nextLine();
        tablaCliente.insertarCliente(id, guest, nombre);        
    }
    
    public void mirarClientes(){
        ArrayList<ClienteVO> lClientes = new ArrayList();
        lClientes = tablaCliente.listaDeCliente();
        for (int i = 0; i < lClientes.size(); i++) {
            System.out.println("->"+lClientes.get(i).getCliente_ID());
            System.out.println("->"+lClientes.get(i).getNo_Of_Guest());
            System.out.println("->"+lClientes.get(i).getCliente_Nombre());
        }
    }
    
    public void mandarMensaje(String msj){
        System.out.println(""+msj);
    }
    
    
}
