package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CT_hoadon_pk  implements Serializable {
private Long hoadon;
private Long sanpham;
private Double giamgia;


public CT_hoadon_pk() {
	super();
	// TODO Auto-generated constructor stub
}
public CT_hoadon_pk(Long hoadon, Long sanpham) {
	super();
	this.hoadon = hoadon;
	this.sanpham = sanpham;
}


public CT_hoadon_pk(Long hoadon, Long sanpham, Double giamgia) {
	super();
	this.hoadon = hoadon;
	this.sanpham = sanpham;
	this.setGiamgia(giamgia);
}
public Long getHoadon() {
	return hoadon;
}
public void setHoadon(Long hoadon) {
	this.hoadon = hoadon;
}
public Long getSanpham() {
	return sanpham;
}
public void setSanpham(Long sanpham) {
	this.sanpham = sanpham;
}
@Override
public String toString() {
	return "CT_hoadon_pk [hoadon=" + hoadon + ", sanpham=" + sanpham + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
	result = prime * result + ((sanpham == null) ? 0 : sanpham.hashCode());
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
	CT_hoadon_pk other = (CT_hoadon_pk) obj;
	if (hoadon == null) {
		if (other.hoadon != null)
			return false;
	} else if (!hoadon.equals(other.hoadon))
		return false;
	if (sanpham == null) {
		if (other.sanpham != null)
			return false;
	} else if (!sanpham.equals(other.sanpham))
		return false;
	return true;
}
public Double getGiamgia() {
	return giamgia;
}
public void setGiamgia(Double giamgia) {
	this.giamgia = giamgia;
}




}
