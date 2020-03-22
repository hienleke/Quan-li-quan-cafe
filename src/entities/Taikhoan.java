package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="taikhoans")
public class Taikhoan implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String password;





public Taikhoan(Long i) {
	super();
	this.id = i;
}
public Taikhoan(String password) {
	super();
	this.password = password;
}
public Taikhoan(Long id, String password) {
	super();
	this.id = id;
	this.password = password;
}
public Taikhoan() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
