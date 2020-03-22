package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.TaikhoanDAO;
import entities.Taikhoan;
 
public class Taikhoanimpl extends UnicastRemoteObject implements TaikhoanDAO {
	private EntityManager em ;
	
	public Taikhoanimpl() throws Exception {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();;
	
	}
	@Override
	public boolean save(Taikhoan hd) throws RemoteException {
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
	public boolean remove(Taikhoan hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Taikhoan.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Taikhoan gd) throws RemoteException {
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
	public List<Taikhoan> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Hoadon", Taikhoan.class) //JPQL
				.getResultList();
		
	}

	@Override
	public Taikhoan getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Taikhoan ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Taikhoan.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	
	
	}



