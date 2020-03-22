import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import impls.CT_Hoadonimpl;
import impls.Chucvuimpl;
import impls.Danhmucimpl;
import impls.Hoadonimpl;
import impls.Nhacungcapimpl;
import impls.Nhanvienimpl;
import impls.Sanphamimpl;
import impls.Taikhoanimpl;
import impls.Thongkeimpls;

public class runningserver {
public static void main(String[] args) throws Exception {
	SecurityManager securityManager = System.getSecurityManager();
	if(securityManager == null) {
		System.setProperty("java.security.policy", "mypolicy\\policy.policy");
		System.setSecurityManager(new SecurityManager());
	}
	
	Registry re = LocateRegistry.createRegistry(1099); 
Naming.rebind("rmi://JavaDev/nhacungcap", new Nhacungcapimpl());
Naming.rebind("rmi://JavaDev/sanpham", new Sanphamimpl());
Naming.rebind("rmi://JavaDev/danhmuc", new Danhmucimpl());
Naming.rebind("rmi://JavaDev/hoadon", new Hoadonimpl());
Naming.rebind("rmi://JavaDev/cthoadon", new CT_Hoadonimpl());
Naming.rebind("rmi://JavaDev/nhanvien", new Nhanvienimpl());
Naming.rebind("rmi://JavaDev/taikhoan", new Taikhoanimpl());
Naming.rebind("rmi://JavaDev/chucvu", new Chucvuimpl());
Naming.rebind("rmi://JavaDev/thongke", new Thongkeimpls());
	
	//Naming.rebind("rmi://JavaDev/nhacungcap:1099", new Nhacungcapimpl());
	//Naming.rebind("rmi://JavaDev/sanpham:1099", new Sanphamimpl());
	//Naming.rebind("rmi://JavaDev/danhmuc:1099", new Danhmucimpl());
	//Naming.rebind("rmi://JavaDev/hoadon:1099", new Hoadonimpl());
//	Naming.rebind("rmi://JavaDev/cthoadon:1099", new CT_Hoadonimpl());
	//Naming.rebind("rmi://JavaDev/nhanvien:1099", new Nhanvienimpl());
	//Naming.rebind("rmi://JavaDev/taikhoan:1099", new Taikhoanimpl());
	//Naming.rebind("rmi://JavaDev/thongke:1099", new Thongkeimpls());
	//Naming.rebind("rmi://JavaDev/chucvu:1099", new Chucvuimpl());
	
	
	
	
	System.out.println("Server is ready...");
}
}
