package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.CT_hoadon;
import entities.Hoadon;


public interface CT_HoadonDAO extends Remote {
	boolean save(CT_hoadon hd) throws RemoteException;
	boolean banhang(List<CT_hoadon> dshd , Hoadon hoadon) throws RemoteException;
	boolean remove(CT_hoadon hd) throws RemoteException;
	boolean update(CT_hoadon gd) throws RemoteException;
	List<CT_hoadon> getds(int max) throws RemoteException;

	List<CT_hoadon> getdsbyid(int max, int idHoadon) throws RemoteException;
	
	
	
}
