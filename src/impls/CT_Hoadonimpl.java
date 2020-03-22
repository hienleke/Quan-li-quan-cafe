package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.Document;

import ConnectDB.MyEntityManager;
import DAO.CT_HoadonDAO;
import entities.CT_hoadon;
import entities.Hoadon;
 
public class CT_Hoadonimpl extends UnicastRemoteObject implements CT_HoadonDAO {
	/**
	 * 
	 */

	private EntityManager em = null;
	
	public CT_Hoadonimpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();
	
	}
	@Override
	public boolean save(CT_hoadon hd) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hd);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(CT_hoadon hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(CT_hoadon.class, hd.getHoadon().getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(CT_hoadon gd) throws RemoteException {
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
	public List<CT_hoadon> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from CT_hoadon", CT_hoadon.class) //JPQL
				.getResultList();
		
	}

	@Override
	public List<CT_hoadon> getdsbyid(int max, int idHoadon) throws RemoteException {
		// TODO Auto-generated method stub
		List<CT_hoadon> ds =  em.createNativeQuery("db.ct_hoadons.find({'_id.idHoadon': "+Long.valueOf(idHoadon)+"})",CT_hoadon.class).getResultList();
		List<?> dsx =  em.createNativeQuery("db.ct_hoadons.find({'_id.idHoadon': "+Long.valueOf(idHoadon)+"})").getResultList();
		
		for (int i=0 ; i < ds.size() ; i++) {
			Object o[] = (Object[]) dsx.get(i);
			Document v = null;
			if(o[0] instanceof Document)
				 v = (Document) o[0];
			double giamgia  = (double) v.get("giamgia");
			ds.get(i).setGiamgia(giamgia);
		}
	
		return ds;
	}
	@Override
	public boolean banhang(List<CT_hoadon> dshd , Hoadon hd) throws RemoteException {
		em.getTransaction().begin();
		
		for (CT_hoadon ct_hoadon : dshd) {
			
			ct_hoadon.setHoadon(hd);
			em.persist(ct_hoadon);
		}
		
		em.getTransaction().commit();
		return false;
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}


}
