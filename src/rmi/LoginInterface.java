<<<<<<< HEAD

package RMI;
=======
package rmi;
>>>>>>> 0f59855abae173153c0400da806c94e2f425d02a

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface LoginInterface extends Remote{
    String Login(String username, String password) throws RemoteException;
    void Signup(String name, String userName, String password, String email, String phoneNumber, String DOB, String Address) throws RemoteException;
}
