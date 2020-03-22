package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="sanphams")
public class Sanpham  implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String ten;
private String donvi;
private double dongiagoc;
private double dongiatrenhoadon;
private String mota;


@ManyToOne//(cascade=CascadeType.ALL)
@JoinColumn(name="Nhacungcap")
private Nhacungcap nhacungcap;
@ManyToOne//(cascade=CascadeType.ALL)
@JoinColumn(name="Danhmuc")
private Danhmuc danhmuc;

public Danhmuc getDanhmuc() {
	return danhmuc;
}
public void setDanhmuc(Danhmuc danhmuc) {
	this.danhmuc = danhmuc;
}


public Sanpham(Long id) {
	super();
	this.id = id;
}
public Sanpham(Long id, String ten, String donvi, double dongiagoc, double dongiatrenhoadon, String mota,
		Nhacungcap nhacungcap, Danhmuc danhmuc) {
	super();
	this.id = id;
	this.ten = ten;
	this.donvi = donvi;
	this.dongiagoc = dongiagoc;
	this.dongiatrenhoadon = dongiatrenhoadon;

	this.mota = mota;
	this.nhacungcap = nhacungcap;
	this.danhmuc = danhmuc;
}
public Nhacungcap getNhacungcap() {
	return nhacungcap;
}
public void setNhacungcap(Nhacungcap nhacungcap) {
	this.nhacungcap = nhacungcap;
}

public Sanpham() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getDonvi() {
	return donvi;
}
public void setDonvi(String donvi) {
	this.donvi = donvi;
}
public double getDongiagoc() {
	return dongiagoc;
}
public void setDongiagoc(double dongiagoc) {
	this.dongiagoc = dongiagoc;
}
public double getDongiatrenhoadon() {
	return dongiatrenhoadon;
}
public void setDongiatrenhoadon(double dongiatrenhoadon) {
	this.dongiatrenhoadon = dongiatrenhoadon;
}


public String getMota() {
	return mota;
}
public void setMota(String mota) {
	this.mota = mota;
}
@Override
public String toString() {
	return "Sanpham [id=" + id + ", ten=" + ten + ", donvi=" + donvi + ", dongiagoc=" + dongiagoc
			+ ", dongiatrenhoadon=" + dongiatrenhoadon + ", mota=" + mota
			+ "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Sanpham other = (Sanpham) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
