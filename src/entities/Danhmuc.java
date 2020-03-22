package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="danhmucs")
public class Danhmuc  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String ten;
	private String mota;

	
	public Danhmuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Danhmuc(Long id) {
		super();
		this.id = id;
	}

	public Danhmuc(Long id, String ten, String mota) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Override
	public String toString() {
		return "Danhmuc [id=" + id + ", ten=" + ten + ", mota=" + mota + "]";
	}

}
