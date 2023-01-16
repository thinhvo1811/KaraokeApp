package entity;

import java.util.Objects;

public class ChucVu {
	@Override
	public int hashCode() {
		return Objects.hash(maChucVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChucVu other = (ChucVu) obj;
		if (maChucVu == null) {
			if (other.maChucVu != null)
				return false;
		} else if (!maChucVu.equals(other.maChucVu))
			return false;
		return true;
	}
	private String maChucVu;
	private String tenChucVu;
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	public ChucVu(String maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}
}
