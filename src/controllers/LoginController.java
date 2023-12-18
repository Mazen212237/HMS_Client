package controllers;

import hms_client.LoginWindow;
import RMI.LoginInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    LoginWindow gui;
    Registry r;

    public LoginController(LoginWindow gui, Registry r){
        this.gui=gui;
        this.r=r;

        //add action listener for the login button
        gui.getLoginButton().addActionListener(new LognBtnAction());
    }
    class LognBtnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            try {
                LoginInterface li = (LoginInterface) r.lookup("Login");
                //get username and password from textfield and passwordfield

                String username=gui.getUsernameField().getText();
                String password=String.valueOf(gui.getjPasswordField1().getPassword());
                if(username==null){
                    gui.getValidationUsernameLabel().setText("Please Enter the username as you can't leave it Empty");
                    System.out.println("Empty username");
                }
                else if(password==null){
                    gui.getValidationPasswordLabel().setText("Please Enter the password as you can't leave it Empty");
                    System.out.println("Empty Password");
                }
                else{
                String result= li.Login(username,password);
                    if(result==null){
                        gui.getValidationPasswordLabel().setText("Username doesn't exist");
                        System.out.println("No account exist");
                    }
                    else{
                        gui.getValidationPasswordLabel().setText(result);
                        System.out.println("Account Found");
                    }
                }

            } catch (RemoteException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            } catch (NotBoundException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
