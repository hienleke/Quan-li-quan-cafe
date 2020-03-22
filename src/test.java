import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.bson.Document;

import com.google.gson.Gson;

import DAO.CT_HoadonDAO;
import DAO.ChucvuDAO;
import DAO.DanhmucDAO;
import DAO.HoadonDAO;
import DAO.NhacungcapDAO;
import DAO.NhanvienDAO;
import DAO.SanphamDAO;
import DAO.TaikhoanDAO;
import DAO.ThongkeDAO;
import entities.CT_hoadon;
import entities.Chucvu;
import entities.Danhmuc;
import entities.Hoadon;
import entities.Nhacungcap;
import entities.Nhanvien;
import entities.Sanpham;
import entities.Taikhoan;
import entities.Thongke;
import impls.CT_Hoadonimpl;
import impls.Chucvuimpl;
import impls.Danhmucimpl;
import impls.Hoadonimpl;
import impls.Nhacungcapimpl;
import impls.Nhanvienimpl;
import impls.Sanphamimpl;
import impls.Taikhoanimpl;
import impls.Thongkeimpls;

public class test {
public static void main(String[] args) throws Exception {
	
	
	//Creates and exports the remote object 
	
	HoadonDAO hddao = (HoadonDAO) Naming.lookup("rmi://JavaDev/hoadon");
	SanphamDAO spdao = (SanphamDAO) Naming.lookup("rmi://JavaDev/sanpham");
	DanhmucDAO dmdao  = (DanhmucDAO) Naming.lookup("rmi://JavaDev/danhmuc");
	NhacungcapDAO nccdao  = (NhacungcapDAO) Naming.lookup("rmi://JavaDev/nhacungcap");
	CT_HoadonDAO cthddao = (CT_HoadonDAO) Naming.lookup("rmi://JavaDev/cthoadon");
	NhanvienDAO nvdao = (NhanvienDAO) Naming.lookup("rmi://JavaDev/nhanvien");
	TaikhoanDAO tkdao  = (TaikhoanDAO) Naming.lookup("rmi://JavaDev/taikhoan");
	ChucvuDAO cvdao  = (ChucvuDAO) Naming.lookup("rmi://JavaDev/chucvu");
	 ThongkeDAO tkedao = (ThongkeDAO) Naming.lookup("rmi://JavaDev/thongke");
	Sanphamimpl spimpls = new Sanphamimpl();
	
	spdao.loctimkiem("-1", "a", "ng").forEach(x->System.out.println(x));
	//Thongkeimpls tkim = new Thongkeimpls();
	//tkim.thongke("2019-11-02");
	//spimpls.getEm().getTransaction().begin();
	// String q ="db.sanphams.aggregate([{'$lookup' : {from : 'nhacungcaps',localField:'Nhacungcap',foreignField:'_id' ,as : 'Nhacungcap' }} , {'$lookup' : { from : 'danhmucs',localField :'Danhmuc',foreignField:'_id',as : 'Danhmuc'}},{'$match' : { '_id' : {'$regex' : "+id+", '$options' : 'i'}}},{'$unwind' :'$Danhmuc' },{'$unwind':'$Nhacungcap'},{'$match' : { 'Nhacungcap.ten' : {'$regex' : '"+ncc+"', '$options' : 'i'}}},{'$match' : { 'Danhmuc.ten' : {'$regex' : '"+ten+"', '$options' : 'i'}}}])";
	//spdao.loc(1, "dfa", "", "").forEach(x->System.out.println(x));
	//Hoadonimpl hdimps = new Hoadonimpl();
	//System.out.println(tkedao.thongke("2019-11-02").toString());
	//hddao.loc(1, "e", "2019-11-1").forEach(x->System.out.println(x));
	/*CT_Hoadonimpl x = new CT_Hoadonimpl();
	EntityManager em = x.getEm();
	List<?> ds =  em.createNativeQuery("db.ct_hoadons.find({'_id.idHoadon': "+174+"})").getResultList();
	ds.forEach(q->{
		Object o[] = (Object[]) q;
		Document v = null;
		if(o[0] instanceof Document)
			 v = (Document) o[0];
			
		System.out.println(v.get("giamgia").toString());
		
	});*/
		
	//spdao.getdsphantrang(2, 1).forEach(x->System.out.println(x));
	//spdao.loc(12, "c", "").forEach(x->System.out.println(x));
	
	//cthddao.getdsbyid(12,  107).forEach(x->System.out.println(x));
	
	//spdao.getdsbyidncc(17).forEach(x->System.out.println(x));
	
	//System.out.println(spdao.getdsphantrang(213, 123));

	
	//System.out.println(spdao.getbyid((long) 82));
	//System.out.println(hddao.getbylastid());
	//Hoadon hd = new Hoadon(null);
	//spdao.save(new Sanpham(null, "Trà sữa kota", "Ly", 18000.0, 18000.0, "Bán chạy cho giới trẻ", nccdao.getbyid((long) 18), dmdao.getbyid((long) 21)));
	//spdao.save(new Sanpham( null, "Cà phê đen", "Ly", 12000.0, 12000.0, "Cà phê thường bán vào buổi sáng", new Nhacungcap((long) 17), dmdao.getbyid((long) 20)));
	
	Hoadon hd = new Hoadon(null);
	Sanpham sp = spdao.getbyid((long) 82);
	Sanpham sp1 = spdao.getbyid((long) 83);
	//hddao.save(hd);


	//List<CT_hoadon> ds = new ArrayList<CT_hoadon>();
	//ds.add(new CT_hoadon(null, sp, 12, 3.5));
	//ds.add(new CT_hoadon(null, sp1, 12, 3.5));
	//cthddao.banhang(ds, hddao.getbylastid());
	Taikhoan tk = new Taikhoan(null,"123");
	Nhanvien nv  = new Nhanvien(null, "Xx", "xxxx", "2324",null, new Chucvu((long) 16));
	nvdao.savewithacc(nv, tk);
	
	
	//ctimp.banhang(ds,hd);
	
	//System.setProperty("java.rmi.server.JavaDev","192.168.1.102");
	//Binding the Remote Object
	
	//System.out.println("Server is ready...");
	

	//Nhanvien add = new Nhanvien( null, "Lê Kế x", "Quảng Nam", "0762110602");
	//add.setTaikhoan(new Taikhoan((long) 14));
	
	//add.setChucvu( new Chucvu((long) 2));
	//nv.save(add);
	//System.out.println(nv.getbyid("12312").getTaikhoan().getId());
	//System.out.println(sanphamimp.getbyid("SP0001").getDanhmuc());
	//System.out.println(nv.getbyid("NV0001").getChucvu());
	//CT_Hoadonimpl cthd = new CT_Hoadonimpl();
	//cthd.save(new CT_hoadon(hoadon, sanpham, soluong, giamgia))
	//hdimp.save(new Hoadon("21312",2, LocalDate.now(), 120000, new Nhanvien("NV0003")));
	//ctimp.save(new CT_hoadon(new Hoadon("21312"), new Sanpham("SP0002"), 2, 5.5));
	
	//x.save(new Nhacungcap(null, "VINACOFFE", "Tây Nguyên", "vinacoffe@vncf.com", "11-231-4353"));
//	x.save(new Nhacungcap(null, "COFFEPhố", "Kontum", "phocoffe@vncf.com", "51-281-4583"));
	//x.save(new Nhacungcap(null, "Kota", "Hải phòng", "milkteakota@kt.com", "21-281-2353"));
	//dm.save(new Danhmuc(null, "Nước ngọt", "Sản phẩm phụ"));
	//dm.save(new Danhmuc(null, "Cafe", "Sản phẩm tiêu thụ chính"));
	//dm.save(new Danhmuc(null, "Trà", "Sản phẩm tiêu thụ chính hoặc đi kèm"));
	
	//
	
//sanphamimp.save(new Nhanvien(null, "Lê Kế Hiền", "Quảng nam", "23-342-123", tkdao.getbyid("NV0001"), dm.getbyid((long) 20)));
	
}
}
