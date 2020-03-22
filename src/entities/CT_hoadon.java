package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ct_hoadons")
@IdClass(CT_hoadon_pk.class)
public class CT_hoadon implements Serializable{
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idHoadon")
	private Hoadon hoadon;
	
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idSanpham")
	private Sanpham sanpham;
	
	private int soluong;
	@Id
	private Double giamgia;
public CT_hoadon(Hoadon hoadon, Sanpham sanpham, int soluong,double giamgia) {
	super();
	this.hoadon = hoadon;
	this.sanpham = sanpham;
	this.soluong = soluong;
	this.giamgia=giamgia;
}

public Double getGiamgia() {
	return giamgia;
}
public void setGiamgia(Double giamgia) {
	this.giamgia = giamgia;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public CT_hoadon() {
	super();
	// TODO Auto-generated constructor stub
}
public Hoadon getHoadon() {
	return hoadon;
}
public void setHoadon(Hoadon hoadon) {
	this.hoadon = hoadon;
}
public Sanpham getSanpham() {
	return sanpham;
}
public void setSanpham(Sanpham sanpham) {
	this.sanpham = sanpham;
}

@Override
public String toString() {
	return "CT_hoadon [hoadon=" + hoadon + ", sanpham=" + sanpham + ", soluong=" + soluong + ", giamgia=" + giamgia
			+ "]";
}




}
