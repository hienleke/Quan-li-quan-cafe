package DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.Thongke;

public interface ThongkeDAO extends Remote {


	Thongke thongke(String ngaylap) throws RemoteException;
	Thongke getds(Long id) throws RemoteException;
	
	
	
}
