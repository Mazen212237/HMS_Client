package rmi;

import hms_client.Food;
import hms_client.Room;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ReceptionServices extends Remote {

    List<Room> displayRoomAvailability() throws RemoteException;

    List<Food> getMenu() throws RemoteException;
    
    List<Room> getAllRooms() throws RemoteException;
     
}
