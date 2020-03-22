package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Nhacungcap;


public interface NhacungcapDAO  extends Remote {
	boolean save(Nhacungcap hd) throws RemoteException;
	boolean remove(Nhacungcap hd) throws RemoteException;
	boolean update(Nhacungcap gd) throws RemoteException;
	List<Nhacungcap> getds (int max) throws RemoteException;
	Nhacungcap getbyid(Long id) throws RemoteException;
}
