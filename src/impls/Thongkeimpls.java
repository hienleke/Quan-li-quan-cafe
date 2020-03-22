package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.Document;

import ConnectDB.MyEntityManager;
import DAO.ThongkeDAO;
import entities.Thongke;
 
public class Thongkeimpls extends UnicastRemoteObject implements ThongkeDAO {
	private EntityManager em ;
	
	public Thongkeimpls() throws Exception {
		// TODO Auto-generated constructor stub
		this.em = MyEntityManager.getInstance().getEntityManager();;
	
	}
	@Override
	public Thongke thongke(String ngaylap)
	{
		
		 String q = "db.ct_hoadons.aggregate([{'$lookup' : {from:'hoadons' ,localField :'_id.idHoadon',foreignField:'_id',as:'Hoadon'}},{'$lookup':{from:'sanphams',localField:'_id.idSanpham',foreignField:'_id',as :'Sanpham'}},{'$unwind':'$Hoadon'},{'$unwind':'$Sanpham'},{'$match' : {'Hoadon.ngaylap':'"+ngaylap+"'}},{'$group' : {'_id':'$Hoadon.ngaylap',tonghang:{'$sum':'$soluong'},goc:{'$sum':{'$multiply':['$Sanpham.dongiagoc','$soluong']}}}}])";
			Document d = new Document();
			 Object o ;
		 em.getTransaction().begin();
			List <?> ds1 = em.createNativeQuery(q).getResultList();
			String q2 = "db.hoadons.aggregate([{'$group' : { '_id':'$ngaylap',danhthu :{'$sum':'$thanhtien'}}},{'$match':{'_id':'"+ngaylap+"'}}])";
			List <?> ds2 =  em.createNativeQuery(q2).getResultList();
			em.getTransaction().commit();
			
			System.out.println("123sadfasdfasdfasdf");
		Object[] j = (Object[]) ds1.get(0);
		Object[] k = (Object[]) ds2.get(0);
			
			
			d.append("ngay", j[0]).append("luonghangdaban", j[1]).append("doanhthu", k[1]).append("lai",(double)k[1] - (double) j[2] );
			Thongke tk = new Thongke(j[0].toString(), Integer.valueOf(j[1].toString()), Double.valueOf(k[1].toString()), (double)k[1] - (double) j[2]);
		return tk ;
	}
	
	
	
	

	@Override
	public Thongke getds(Long id) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Thongke ncc= null;
		try {
			tr.begin();
			ncc =  em.find(Thongke.class, id);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			
		}
	
		return ncc;
	}
	
	
	}



