/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hms_client;

import controllers.LoginController;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gamer
 */
public class HMS_Client {

    public static void main(String[] args) throws RemoteException {
        LoginWindow gui = new LoginWindow();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

        Registry r= LocateRegistry.getRegistry(1099);
        System.out.println("connected to Port from client");

        LoginController gui_Controller= new LoginController(gui,r);
        //
    }
    
}
