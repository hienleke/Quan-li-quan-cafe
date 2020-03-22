package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="hoadons")

public class Hoadon   implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int ban;
	private LocalDate ngaylap;
	private double thanhtien;
	

	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="Nhanvien")
	private Nhanvien nhanvien;

	public Hoadon(Long id) {
		super();
		this.id = id;
	}



	public Hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Hoadon(Long id, int ban, LocalDate ngaylap, double thanhtien, Nhanvien nhanvien) {
		super();
		this.id = id;
		this.ban = ban;
		this.ngaylap = ngaylap;
		this.thanhtien = thanhtien;
		this.nhanvien = nhanvien;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public LocalDate getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(LocalDate ngaylap) {
		this.ngaylap = ngaylap;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	
	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	@Override
	public String toString() {
		return "Hoadon [id=" + id + ", ban=" + ban + ", ngaylap=" + ngaylap + ", thanhtien=" + thanhtien + "]";
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
		Hoadon other = (Hoadon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
