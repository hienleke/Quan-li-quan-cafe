package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.NhanvienDAO;
import entities.Nhanvien;
import entities.Taikhoan;
 
public class Nhanvienimpl extends UnicastRemoteObject implements NhanvienDAO {
	/**
	 * 
	 */

	private EntityManager em = null;
	
	public Nhanvienimpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();
	
	}
	@Override
	public boolean save(Nhanvien hd) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hd);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}
	@Override
	public boolean savewithacc(Nhanvien hd,Taikhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(tk);
			hd.setTaikhoan(tk);
			em.persist(hd);
			
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Nhanvien hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Nhanvien.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Nhanvien gd) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(gd);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public List<Nhanvien> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Nhanvien", Nhanvien.class) //JPQL
				.getResultList();
		
	}

	@Override
	public Nhanvien getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Nhanvien ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Nhanvien.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}


}
