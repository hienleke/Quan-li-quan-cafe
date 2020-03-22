package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import entities.Taikhoan;


public interface TaikhoanDAO  extends  Remote {
	boolean save(Taikhoan hd) throws RemoteException ;
	boolean remove(Taikhoan hd) throws RemoteException;
	boolean update(Taikhoan gd) throws RemoteException;
	List<Taikhoan> getds (int max) throws RemoteException;
	Taikhoan getbyid(Long id) throws RemoteException;
}
