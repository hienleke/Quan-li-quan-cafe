package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ConnectDB.MyEntityManager;
import DAO.HoadonDAO;
import entities.Hoadon;
 
public class Hoadonimpl extends UnicastRemoteObject implements HoadonDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em ;
	
	public Hoadonimpl() throws Exception {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();;
	
	}
	@Override
	public boolean save(Hoadon hd) throws RemoteException {
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
	public boolean remove(Hoadon hd) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Hoadon.class, hd.getId()));
		
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Hoadon gd) throws RemoteException {
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
	public List<Hoadon> getds(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("from Hoadon", Hoadon.class) //JPQL
				.setMaxResults(max).getResultList();
		
	}

	@Override
	public Hoadon getbyid(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Hoadon ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Hoadon.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	
	public List<String> getdsid()
	{
		EntityTransaction tr = em.getTransaction();
		 List<String> ncc =null;
		try {
			tr.begin();
			  ncc = em.createQuery("select hd.id from Hoadon hd").getResultList();
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
		 return ncc;
	}
	@Override
	public Hoadon getbylastid() throws RemoteException {
	
		Hoadon hd =null;
		em.getTransaction().begin();
		
		String sqlString = "from Hoadon hh order by hh.id desc";
		  hd = em.createQuery(sqlString, Hoadon.class).getResultList().get(0); 
		em.getTransaction().commit();
	
	if (hd==null)
		System.out.println("asdfas");
		return hd;
		
	}
	@Override
	public List<Hoadon> loc(long id ,String ten , String tg) throws RemoteException {
		// TODO Auto-generated method stub
		List<Hoadon> ds =new ArrayList<>();
		//String q ="db.sanphams.find({ten:{'$regex':'"+ten+"','$options':'$i'}})";
		String q ="db.hoadons.aggregate([{'$lookup' : {from : 'nhanviens' , localField :'Nhanvien' , foreignField :'_id' , as:'Nhanvien'}},{'$unwind':'$Nhanvien'},{'$match' : { 'Nhanvien.ten' : {'$regex' : '"+ten+"', '$options' : 'i'}}},{'$match' : { 'ngaylap' : {'$regex' : '"+tg+"', '$options' : 'i'}}}])";
		
				
				em.getTransaction().begin();
		List <?> ds1 = em.createNativeQuery(q).getResultList();
		em.getTransaction().commit();
		
		
				String idtest =String.valueOf(id);
				
					
				
					
				
				
		ds1.forEach(x -> {
			Object[] o = (Object[]) x;
			try {
				Hoadon sp = getbyid(Long.valueOf(o[0].toString()));
				
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
	
	
	
	
	}



