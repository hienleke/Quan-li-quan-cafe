package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="nhanviens")
public class Nhanvien implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String ten;
private String diachi;

@ManyToOne
@JoinColumn(name="chucvu")
private Chucvu chucvu;


@OneToOne()
@JoinColumn(name="taikhoan")
private Taikhoan taikhoan;

private String  sdt;







public Nhanvien(Long id) {
	super();
	this.id = id;
}


public Nhanvien(Long id, String ten, String diachi, String sdt) {
	super();
	this.id = id;
	this.ten = ten;
	this.diachi = diachi;
	this.sdt = sdt;
}


public Nhanvien(Long id, String ten, String diachi, String sdt, Taikhoan taikhoan, Chucvu chucvu) {
	super();
	this.id = id;
	this.ten = ten;
	this.diachi = diachi;
	this.sdt = sdt;
	this.taikhoan = taikhoan;
	this.chucvu = chucvu;
}


public Taikhoan getTaikhoan() {
	return taikhoan;
}


public void setTaikhoan(Taikhoan taikhoan) {
	this.taikhoan = taikhoan;
}


public Chucvu getChucvu() {
	return chucvu;
}


public void setChucvu(Chucvu chucvu) {
	this.chucvu = chucvu;
}


public Nhanvien() {
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
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}

public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
@Override
public String toString() {
	return "Nhanvien [id=" + id + ", ten=" + ten + ", diachi=" + diachi +  ", sdt=" + sdt
			+ "]";
}


}
