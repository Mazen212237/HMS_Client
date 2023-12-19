/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class BookRoomController {
    BookRoom gui;
    Registry r;
    
    
    public BookRoomController(BookRoom gui, Registry r){
        this.gui=gui;
        this.r=r;

        //add action listener for the login button
        gui.BackToCD().addActionListener(new MoveToCDash());
        gui.BookRoombtn().addActionListener(new MoveToCDash());
    }
    
    class MoveToCDash implements ActionListener{
       
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            gui.dispose();
            
            ClientDashboard ClientDashboardGui  = new ClientDashboard();
            ClientDashboardGui .setLocationRelativeTo(null);
            ClientDashboardGui .setVisible(true);
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
    }

        
    
}
