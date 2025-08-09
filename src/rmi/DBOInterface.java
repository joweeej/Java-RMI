package rmi;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

// Server side - Skeleton
public interface  DBOInterface extends Remote{
  
     public String insertOperation(int id, String name, String course) throws RemoteException;
     public String[] selectOperation(int id) throws RemoteException;
     public ArrayList<String> selectAllOperation()  throws RemoteException;
     public String updateOperation(int oldId, int newId, String name, String course)  throws RemoteException;
   public void deleteOperation(int id)  throws RemoteException;
   
}