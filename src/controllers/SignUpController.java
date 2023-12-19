package controllers;

import RMI.LoginInterface;
import hms_client.LoginWindow;
import hms_client.SignUpWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author gamer
 */
public class SignUpController {
    SignUpWindow gui;
    Registry r;

    public SignUpController(SignUpWindow gui, Registry r){
        this.gui=gui;
        this.r=r;
        
        gui.getSignUpButton().addActionListener(new SignUpBtnAction());
        gui.getLoginButton().addActionListener(new LoginBtnAction());
    }
    
    class LoginBtnAction implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae){
            try {
                LoginInterface li=(LoginInterface) r.lookup("Login");
                LoginWindow lw=new LoginWindow();
                lw.setLocationRelativeTo(null);
                lw.setVisible(true);
                LoginController lc=new LoginController(lw,r);
                gui.dispose();
                
                
            } catch (RemoteException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    class SignUpBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            try {
                LoginInterface li = (LoginInterface) r.lookup("Login");
                
                //get all info from textFields
                String name=gui.getNameField().getText();
                String username=gui.getUserNameField().getText();
                String password=String.valueOf(gui.getPasswordField().getPassword());
                String confirmPassword=String.valueOf(gui.getConfrimPasswordField().getPassword());
                String email=gui.getEmailField().getText();
                String phoneNumber=gui.getPhoneNumberField().getText();
                String DOB=gui.getDOBField().getText();
                String address=gui.getAddressField().getText();
                boolean empty=false;
                Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                

                
                
                
                
                if (gui.getNameField().getText().isEmpty() 
                        || gui.getUserNameField().getText().isEmpty()
                        || String.valueOf(gui.getPasswordField().getPassword()).isEmpty()
                        ||String.valueOf(gui.getConfrimPasswordField().getPassword()).isEmpty()
                        ||gui.getEmailField().getText().isEmpty()
                        ||gui.getPhoneNumberField().getText().isEmpty()
                        ||gui.getDOBField().getText().isEmpty()
                        ||gui.getAddressField().getText().isEmpty()){
                    
                    JOptionPane.showMessageDialog(null, "All fields must be filled to continue.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                        if(!password.equals(confirmPassword)){
                            JOptionPane.showMessageDialog(null, "Passwords needs to be the same.", "Error", JOptionPane.ERROR_MESSAGE);                
                        } else{
                            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(gui.getEmailField().getText());
                            if(!matcher.matches()){
                                JOptionPane.showMessageDialog(null, "Incorrect Email Format, Try again", "Error", JOptionPane.ERROR_MESSAGE);                
                            } else{
                                
                                    li.Signup(name, username, password, email, phoneNumber, DOB, address);
                                    LoginWindow lw=new LoginWindow();
                                    lw.setLocationRelativeTo(null);
                                    lw.setVisible(true);
                                    LoginController lc=new LoginController(lw,r);
                                    gui.dispose();
                                }
                            }

                
                }
                
         
                    
                    
                    
                
                
                
            } catch (RemoteException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
