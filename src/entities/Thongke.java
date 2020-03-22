package entities;
import java.io.Serializable;

import org.bson.Document;


public class Thongke implements Serializable {
	private String ngay;
	private int soluong;
	private double doanhthu;
	private double lai;
	public Thongke() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Thongke(String ngay, int soluong, double doanhthu, double lai) {
		super();
		this.ngay = ngay;
		this.soluong = soluong;
		this.doanhthu = doanhthu;
		this.lai = lai;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getDoanhthu() {
		return doanhthu;
	}
	public void setDoanhthu(double doanhthu) {
		this.doanhthu = doanhthu;
	}
	public double getLai() {
		return lai;
	}
	public void setLai(double lai) {
		this.lai = lai;
	}
	@Override
	public String toString() {
		return "Thongke [ngay=" + ngay + ", soluong=" + soluong + ", doanhthu=" + doanhthu + ", lai=" + lai + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(doanhthu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lai);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ngay == null) ? 0 : ngay.hashCode());
		result = prime * result + soluong;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thongke other = (Thongke) obj;
		if (Double.doubleToLongBits(doanhthu) != Double.doubleToLongBits(other.doanhthu))
			return false;
		if (Double.doubleToLongBits(lai) != Double.doubleToLongBits(other.lai))
			return false;
		if (ngay == null) {
			if (other.ngay != null)
				return false;
		} else if (!ngay.equals(other.ngay))
			return false;
		if (soluong != other.soluong)
			return false;
		return true;
	}
	
	
	
	
	
	
}
