package entities;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="chucvus")
public class Chucvu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String ten;




public Chucvu(Long id) {
	super();
	this.id = id;
}

public Chucvu(Long id, String ten) {
	super();
	this.id = id;
	this.ten = ten;
}

public Chucvu() {
	super();
	// TODO Auto-generated constructor stub
}

public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@Override
public String toString() {
	return "Chucvu [id=" + id + ", ten=" + ten + "]";
}


}
