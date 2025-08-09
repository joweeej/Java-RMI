package rmi;
 
import database.DBOperations;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
 
import java.util.ArrayList;
 
public class DBOInterfaceImpl extends UnicastRemoteObject implements DBOInterface {

    DBOperations dbo;

    public DBOInterfaceImpl()throws RemoteException{

        super();

        dbo= new DBOperations();

    }

    @Override

    public String insertOperation(int id, String name, String course) throws RemoteException {

        return dbo.insertOperation(id, name, course);

    }
 
    @Override

    public String[] selectOperation(int id) throws RemoteException {

        return dbo.selectOperation(id);

    }
 
    @Override

    public ArrayList<String> selectAllOperation() throws RemoteException {

        return dbo.selectAllOperation();

    }
 
    @Override

    public String updateOperation(int oldId, int newId, String name, String course) throws RemoteException {

        return dbo.updateOperation(oldId, newId, name, course);

    }
 
    @Override

    public void deleteOperation(int id) throws RemoteException {

        dbo.deleteOperation(id);

    }

}

 