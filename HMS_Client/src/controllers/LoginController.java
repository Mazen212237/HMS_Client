package controllers;

import rmi.LoginInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class LoginController {
    LoginWindow gui;
    Registry r;

    public LoginController(LoginWindow gui, Registry r){
        this.gui=gui;
        this.r=r;

        //add action listener for the login button
    }
    class LognBtnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            try {
                LoginInterface li = (LoginInterface) r.lookup("login");
                //get username and password from textfield and passwordfield

                String result= li.Login(username,password);

            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
