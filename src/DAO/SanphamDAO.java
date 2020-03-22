package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Sanpham;

public interface SanphamDAO extends Remote {
	boolean save(Sanpham hd) throws RemoteException;
	boolean remove(Sanpham hd) throws RemoteException;
	boolean update(Sanpham gd) throws RemoteException;
	List<Sanpham> getds(int max) throws RemoteException;
	Sanpham getbyid(Long id) throws RemoteException;
	List<Sanpham> getdsphantrang(int max , int vt) throws RemoteException;
	List<Sanpham> getdsbyidncc(long id) throws RemoteException;
	
	List<Sanpham> loc(long id, String ten, String ncc, String tendm) throws RemoteException;
	List<Sanpham> loctimkiem(String id, String ten, String danhmuc) throws RemoteException;
}
