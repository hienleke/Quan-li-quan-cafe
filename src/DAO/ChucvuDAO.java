package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Chucvu;

public interface ChucvuDAO  extends  Remote {
	boolean save(Chucvu hd) throws RemoteException ;
	boolean remove(Chucvu hd) throws RemoteException;
	boolean update(Chucvu gd) throws RemoteException;
	List<Chucvu> getds (int max) throws RemoteException;
	Chucvu getbyid(Long id) throws RemoteException;
}
