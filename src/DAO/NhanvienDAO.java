package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entities.Nhanvien;
import entities.Taikhoan;

public interface NhanvienDAO extends Remote{
	boolean save(Nhanvien hd) throws RemoteException;
	boolean remove(Nhanvien hd) throws RemoteException;
	boolean update(Nhanvien gd) throws RemoteException;
	List<Nhanvien> getds (int max) throws RemoteException;
	Nhanvien getbyid(Long id) throws RemoteException;
	boolean savewithacc(Nhanvien hd, Taikhoan tk) throws RemoteException;
}
