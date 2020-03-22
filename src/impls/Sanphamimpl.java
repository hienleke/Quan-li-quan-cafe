package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.SanphamDAO;
import entities.Sanpham;
 
public class Sanphamimpl extends UnicastRemoteObject implements SanphamDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em ;
	public Sanphamimpl() throws Exception {
		em= MyEntityManager.getInstance().getEntityManager();
		
		
	}
	public Sanphamimpl(EntityManager e) throws Exception {
		// TODO Auto-generated constructor stub
		this.em = e;
	
	}
	@Override
	public boolean save(Sanpham hd) throws RemoteException {
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
	public boolean remove(Sanpham hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Sanpham.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Sanpham gd) throws RemoteException {
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
	public List<Sanpham> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Sanpham", Sanpham.class).setMaxResults(max)//JPQL
				.getResultList();
		
	}
	@Override
	public List<Sanpham> getdsphantrang(int max , int vt) throws RemoteException {
		// TODO Auto-generated method stub
		List<Sanpham> ds =null;
		
		em.getTransaction().begin();
		ds = em.createQuery("from Sanpham",Sanpham.class).setFirstResult(vt*max).setMaxResults(max).getResultList();
		em.getTransaction().commit();
			
		
	

		return ds;
		
	}
	@Override
	public List<Sanpham> getdsbyidncc(long id) throws RemoteException {
		// TODO Auto-generated method stub
		List<Sanpham> ds =null;
		String q ="db.sanphams.find({'Nhacungcap':"+id+"})";
		em.getTransaction().begin();
		ds = em.createNativeQuery(q, Sanpham.class).getResultList();
		em.getTransaction().commit();
				
		
	

		return ds;
		
	}
	@Override
	public List<Sanpham> loc(long id ,String ten , String ncc , String tendm) throws RemoteException {
		// TODO Auto-generated method stub
		List<Sanpham> ds =new ArrayList<Sanpham>();
		//String q ="db.sanphams.find({ten:{'$regex':'"+ten+"','$options':'$i'}})";
		String q ="db.sanphams.aggregate([{'$lookup' : {from : 'nhacungcaps',localField:'Nhacungcap',foreignField:'_id' ,as : 'Nhacungcap' }} , {'$lookup' : { from : 'danhmucs',localField :'Danhmuc',foreignField:'_id',as : 'Danhmuc'}},{'$match' : { 'ten' : {'$regex' : '"+ten+"', '$options' : 'i'}}},{'$unwind' :'$Danhmuc' },{'$unwind':'$Nhacungcap'},{'$match' : { 'Nhacungcap.ten' : {'$regex' : '"+ncc+"', '$options' : 'i'}}},{'$match' : { 'Danhmuc.ten' : {'$regex' : '"+tendm+"', '$options' : 'i'}}}])";
		em.getTransaction().begin();
		List <?> ds1 = em.createNativeQuery(q).getResultList();
		em.getTransaction().commit();
		
		
				String idtest =String.valueOf(id);
				
					
				
					
				
				
		ds1.forEach(x -> {
			Object[] o = (Object[]) x;
			try {
				Sanpham sp = getbyid(Long.valueOf(o[0].toString()));
				if(id==-1)
				{if(sp.getId().toString().matches(".*"))
				{
					
					ds.add(sp);
				}
				}
				else
				{
					if(sp.getId().toString().matches(".*"+idtest+".*"))
					{
						
						ds.add(sp);
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			});
		
	

		return ds;
		
	}
	
	@Override
	public Sanpham getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Sanpham ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Sanpham.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	@Override
	public List<Sanpham> loctimkiem(String id, String ten , String danhmuc)
	{
		String q ="db.sanphams.aggregate([{'$lookup' : { from : 'danhmucs' ,localField :'Danhmuc', foreignField :'_id' , as :'Danhmuc'}},{'$unwind':'$Danhmuc'},{'$match': {ten : {'$regex': '"+ten+"','$options' : 'i'}}},{'$match': {'Danhmuc.ten' : {'$regex': '"+danhmuc+"','$options' : 'i'}}}])";
		
				List<Sanpham> ds =new ArrayList<Sanpham>();
		//String q ="db.sanphams.find({ten:{'$regex':'"+ten+"','$options':'$i'}})";
		
		em.getTransaction().begin();
		List <?> ds1 = em.createNativeQuery(q).getResultList();
		em.getTransaction().commit();
		
		
				String idtest =String.valueOf(id);
				
					
				
					
				
				
		ds1.forEach(x -> {
			Object[] o = (Object[]) x;
			try {
				Sanpham sp = getbyid(Long.valueOf(o[0].toString()));
				if(Long.valueOf(id)==-1)
				{
					
					if(sp.getId().toString().matches(".*"))
				{
					
					ds.add(sp);
				}
				}
				else
				{
					if(sp.getId().toString().matches(".*"+idtest+".*"))
					{
						
						ds.add(sp);
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			});
		
	

		return ds;
		
	}
	
	}



