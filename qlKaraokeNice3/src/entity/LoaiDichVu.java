package entity;

public class LoaiDichVu {
	private String maLoai;
	private String tenLoai;
	public LoaiDichVu() {
		super();
	}
	public LoaiDichVu(String maLoai) {
		super();
		this.maLoai = maLoai;
	}
	public LoaiDichVu(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
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
		LoaiDichVu other = (LoaiDichVu) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoaiDichVu [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
}
