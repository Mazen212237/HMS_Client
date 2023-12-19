/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import RMI.ReceptionServices;
import hms_client.Receptionist_Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ryusei
 */
public class ServiceController {
    Receptionist_Dashboard gui;
    Registry r;

    public ServiceController(Receptionist_Dashboard gui, Registry r) {
        this.gui = gui;
        this.r = r;
        
        gui.getAllRooms().addActionListener(new AllRoomsBtnAction());
        gui.getAvailRooms().addActionListener(new AvailRoomsBtnAction());
        gui.getMenu().addActionListener(new MenuBtnAction());
    }

    class AllRoomsBtnAction implements ActionListener {

        public AllRoomsBtnAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ReceptionServices rs = (ReceptionServices) r.lookup("getAllRooms");
                        } catch (RemoteException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    class AvailRoomsBtnAction implements ActionListener {

        public AvailRoomsBtnAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
                ReceptionServices rs = (ReceptionServices) r.lookup("getAvailRooms");
                        } catch (RemoteException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     class MenuBtnAction implements ActionListener {

        public MenuBtnAction() {
        } 

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
                ReceptionServices rs = (ReceptionServices) r.lookup("getMenu");
                        } catch (RemoteException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
