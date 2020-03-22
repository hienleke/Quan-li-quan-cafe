package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.DanhmucDAO;
import entities.Danhmuc;
 
public class Danhmucimpl extends UnicastRemoteObject implements DanhmucDAO {
	/**
	 * 
	 */

	private EntityManager em = null;
	
	public Danhmucimpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();
	
	}
	@Override
	public boolean save(Danhmuc hd) throws RemoteException {
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
	public boolean remove(Danhmuc hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Danhmuc.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Danhmuc gd) throws RemoteException {
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
	public List<Danhmuc> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Danhmuc", Danhmuc.class) //JPQL
				.getResultList();
		
	}

	@Override
	public Danhmuc getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Danhmuc ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Danhmuc.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}


}
