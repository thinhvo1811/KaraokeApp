package entity;

import java.sql.Date;
import java.sql.Time;

public class HoaDon {
	private String maHoaDon;
	private Date ngayLapHD;
	private NhanVien nhanvien;
	private KhachHang khachhang;
	private Phong phong;
	private Time gioVao;
	private Time gioRa;
	private double tienPhong;
	private boolean trangThai;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	

	public HoaDon(String maHoaDon, Date ngayLapHD, NhanVien nhanVien, KhachHang khachhang, Phong phong, Time gioVao, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHD = ngayLapHD;
		this.nhanvien = nhanVien;
		this.khachhang = khachhang;
		this.phong = phong;
		this.gioVao = gioVao;
		this.trangThai = trangThai;
	}
	public HoaDon(String maHoaDon, Date ngayLapHD, NhanVien nhanvien, KhachHang khachhang, Phong phong, Time gioVao,
			Time gioRa, double tienPhong, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHD = ngayLapHD;
		this.nhanvien = nhanvien;
		this.khachhang = khachhang;
		this.phong = phong;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.tienPhong = tienPhong;
		this.trangThai = trangThai;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Time getGioVao() {
		return gioVao;
	}
	public void setGioVao(Time gioVao) {
		this.gioVao = gioVao;
	}
	public Time getGioRa() {
		return gioRa;
	}
	public void setGioRa(Time gioRa) {
		this.gioRa = gioRa;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHD=" + ngayLapHD + ", nhanvien=" + nhanvien + ", khachhang="
				+ khachhang + ", phong=" + phong + ", gioVao=" + gioVao + ", gioRa=" + gioRa + ", trangThai="
				+ trangThai + "]";
	}
	
	
}
