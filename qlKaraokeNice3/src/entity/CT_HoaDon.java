package entity;


public class CT_HoaDon {
	private HoaDon hoaDon;
	private DichVu dichvu;
	private int soLuong;
	private double giaBan;
	private String donViTinh;
	public CT_HoaDon() {
		super();
	}
	public CT_HoaDon(HoaDon hoaDon) {
		super();
		this.hoaDon = hoaDon;
	}
	public CT_HoaDon(HoaDon hoaDon, DichVu dichvu, double giaBan, int soLuong, String donViTinh) {
		super();
		this.hoaDon = hoaDon;
		this.dichvu = dichvu;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	@Override
	public String toString() {
		return "CT_HoaDon [hoaDon=" + hoaDon + ", dichvu=" + dichvu + ", soLuong=" + soLuong + ", giaBan=" + giaBan
				+ ", donViTinh=" + donViTinh + "]";
	}
	
	
}
