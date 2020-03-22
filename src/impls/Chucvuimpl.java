package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.ChucvuDAO;
import DAO.HoadonDAO;
import entities.Chucvu;
import entities.Chucvu;
 
public class Chucvuimpl extends UnicastRemoteObject implements ChucvuDAO {
	private EntityManager em ;
	
	public Chucvuimpl() throws Exception {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();;
	
	}
	@Override
	public boolean save(Chucvu hd) throws RemoteException {
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
	public boolean remove(Chucvu hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Chucvu.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Chucvu gd) throws RemoteException {
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
	public List<Chucvu> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Hoadon", Chucvu.class) //JPQL
				.getResultList();
		
	}

	@Override
	public Chucvu getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Chucvu ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Chucvu.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	
	
	}



