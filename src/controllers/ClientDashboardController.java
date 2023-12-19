
package controllers;

import hms_client.BookRoom;
import hms_client.ClientDashboard;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class ClientDashboardController {
    ClientDashboard gui;
    Registry r;
    
    
    public ClientDashboardController(ClientDashboard gui, Registry r){
        this.gui=gui;
        this.r=r;

        //add action listener for the login button
        gui.BookRoomPortal().addActionListener(new MoveToBook());
    }
    
    class MoveToBook implements ActionListener{
        
        
        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            gui.dispose();
            
            BookRoom bookRoomGui  = new BookRoom();
            bookRoomGui .setLocationRelativeTo(null);
            bookRoomGui .setVisible(true);
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
}
