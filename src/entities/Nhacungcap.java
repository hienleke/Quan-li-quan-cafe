package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="nhacungcaps")
public class Nhacungcap  implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String ten;
private String diachi;
private String email;
private String sdt;

public Nhacungcap(Long id) {
	super();
	this.id = id;
}
public Nhacungcap(Long id, String ten, String diachi, String email, String sdt) {
	super();
	this.id = id;
	this.ten = ten;
	this.diachi = diachi;
	this.email = email;
	this.sdt = sdt;
}
public Nhacungcap() {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}

}
