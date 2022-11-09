/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class ClienteVO {
    int Cliente_ID;
    int No_Of_Guest;
    String Cliente_Nombre;

    public ClienteVO() {
    }
    
    public ClienteVO(int Cliente_ID, int No_Of_Guest, String Cliente_Nombre) {
        this.Cliente_ID = Cliente_ID;
        this.No_Of_Guest = No_Of_Guest;
        this.Cliente_Nombre = Cliente_Nombre;
    }

    public int getCliente_ID() {
        return Cliente_ID;
    }

    public void setCliente_ID(int Cliente_ID) {
        this.Cliente_ID = Cliente_ID;
    }

    public int getNo_Of_Guest() {
        return No_Of_Guest;
    }

    public void setNo_Of_Guest(int No_Of_Guest) {
        this.No_Of_Guest = No_Of_Guest;
    }

    public String getCliente_Nombre() {
        return Cliente_Nombre;
    }

    public void setCliente_Nombre(String Cliente_Nombre) {
        this.Cliente_Nombre = Cliente_Nombre;
    }

    
}
