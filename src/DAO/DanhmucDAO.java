package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Danhmuc;

public interface DanhmucDAO  extends  Remote {
	boolean save(Danhmuc hd) throws RemoteException ;
	boolean remove(Danhmuc hd) throws RemoteException;
	boolean update(Danhmuc gd) throws RemoteException;
	List<Danhmuc> getds (int max) throws RemoteException;
	Danhmuc getbyid(Long id) throws RemoteException;
}
