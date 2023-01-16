package entity;

import java.util.Objects;

public class LoaiPhong {
	private String maLoai;
	private String tenloai;
	private int soNguoiToiDa;
	private double giaPhong;

	public LoaiPhong(String maLoai, String tenloai, int soNguoiToiDa, double giaPhong) {
		super();
		this.maLoai = maLoai;
		this.tenloai = tenloai;
		this.soNguoiToiDa = soNguoiToiDa;
		this.giaPhong = giaPhong;
	}
	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}
	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
	}
	public LoaiPhong(String maLoai) {
		super();
		this.maLoai = maLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}
	
}
