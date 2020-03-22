package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.NhacungcapDAO;
import entities.Nhacungcap;
 
public class Nhacungcapimpl extends UnicastRemoteObject implements NhacungcapDAO {
	private EntityManager em ;
	
	public Nhacungcapimpl() throws Exception {
		em = MyEntityManager.getInstance().getEntityManager();
	
	}
	@Override
	public boolean save(Nhacungcap hd) throws RemoteException {
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
	public boolean remove(Nhacungcap hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Nhacungcap.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Nhacungcap gd) throws RemoteException {
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
	public List<Nhacungcap> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Nhacungcap lh", Nhacungcap.class) //JPQL
				.getResultList();
		
	}

	@Override
	public Nhacungcap getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Nhacungcap ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Nhacungcap.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	
	
	
	
	}



