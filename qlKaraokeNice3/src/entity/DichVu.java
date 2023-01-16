package entity;

import java.sql.Date;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private double gia;
	private String donViTinh;
	private int soLuong;
	private Date hanSuDung;
	private boolean trangThaiKD;
	private LoaiDichVu loaiDichVu;
	public DichVu() {
		super();
	}
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}
	public DichVu(String maDichVu, String tenDichVu, double gia, String donViTinh, int soLuong, Date hanSuDung,
			boolean trangThaiKD, LoaiDichVu loaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.gia = gia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.hanSuDung = hanSuDung;
		this.trangThaiKD = trangThaiKD;
		this.loaiDichVu = loaiDichVu;
	}
	
	public DichVu(String maDichVu, String tenDichVu, double gia, String donViTinh, boolean trangThaiKD,
			LoaiDichVu loaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.gia = gia;
		this.donViTinh = donViTinh;
		this.trangThaiKD = trangThaiKD;
		this.loaiDichVu = loaiDichVu;
	}
	
	
	public DichVu(String maDichVu, String tenDichVu, double gia, String donViTinh) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.gia = gia;
		this.donViTinh = donViTinh;
	}
	public DichVu(String maDichVu, String tenDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	
	public boolean isTrangThaiKD() {
		return trangThaiKD;
	}
	public void setTrangThaiKD(boolean trangThaiKD) {
		this.trangThaiKD = trangThaiKD;
	}
	public LoaiDichVu getLoaiDichVu() {
		return loaiDichVu;
	}
	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
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
		DichVu other = (DichVu) obj;
		if (maDichVu == null) {
			if (other.maDichVu != null)
				return false;
		} else if (!maDichVu.equals(other.maDichVu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", gia=" + gia + ", donViTinh=" + donViTinh
				+ ", soLuong=" + soLuong + ", hanSuDung=" + hanSuDung + ", trangThaiKD=" + trangThaiKD + ", loaiDichVu="
				+ loaiDichVu + "]";
	}
	
}