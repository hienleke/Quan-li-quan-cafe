package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entities.Hoadon;

public interface HoadonDAO extends Remote {
	boolean save(Hoadon hd) throws RemoteException;
	boolean remove(Hoadon hd) throws RemoteException;
	boolean update(Hoadon gd) throws RemoteException;
	List<Hoadon> getds (int max) throws RemoteException;
	Hoadon getbyid(Long id) throws RemoteException;
	Hoadon getbylastid() throws RemoteException;
	List<Hoadon> loc(long id, String ten, String tg) throws RemoteException;
	
	
}
