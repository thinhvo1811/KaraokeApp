package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connect.Connect;
import entity.ChucVu;
import entity.NhanVien;

public class NhanVien_DAO {
	public List<NhanVien> getAllNhanVien() {

		String sql = "select maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, nv.maChucVu, tenChucVu from NhanVien nv join ChucVu cv on nv.maChucVu = cv.maChucVu";
		PreparedStatement statement = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  void addNhanVien(NhanVien nv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?)");
				statement.setString(1, nv.getMaNV());
				statement.setString(2, nv.getTenNV());
				statement.setBoolean(3, nv.isGioiTinh());
				statement.setDate(4, nv.getNgaySinh());
				statement.setString(5, nv.getSoCMND());
				statement.setString(6, nv.getSoDT());
				statement.setString(7, nv.getDiaChi());
				statement.setString(8, nv.getChucVu().getMaChucVu());
				statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	public  void updateNhanVien(NhanVien nv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update NhanVien set tenNhanVien=?, gioiTinh=?, ngaySinh=?, soCMND=?, soDT=?, diaChi=?, maChucVu=? where maNhanVien=?");
				statement.setString(1, nv.getTenNV());
				statement.setBoolean(2, nv.isGioiTinh());
				statement.setDate(3, nv.getNgaySinh());
				statement.setString(4, nv.getSoCMND());
				statement.setString(5, nv.getSoDT());
				statement.setString(6, nv.getDiaChi());
				statement.setString(7, nv.getChucVu().getMaChucVu());
				statement.setString(8, nv.getMaNV());
				statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}	
	public  void deleteNhanVien(String maNV) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from NhanVien where maNhanVien=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maNV);
				statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	
	public  ArrayList<NhanVien> getNhanVien(String maNV, String tenNV, String gioiTinh, String ngaySinh, String soCMND, String soDT, String diaChi, String tenChucVu) {
		
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, NhanVien.maChucVu, tenChucVu FROM ChucVu INNER JOIN NhanVien ON ChucVu.maChucVu = NhanVien.maChucVu WHERE maNhanVien like ? and tenNhanVien like ? and gioiTinh like ? and ngaySinh like ? and soCMND like ? and soDT like ? and diaChi like ? and tenChucVu like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+maNV+"%");
			statement.setString(2, "%"+tenNV+"%");
			statement.setString(3, "%"+gioiTinh+"%");
			statement.setString(4, "%"+ngaySinh+"%");
			statement.setString(5, "%"+soCMND+"%");
			statement.setString(6, "%"+soDT+"%");
			statement.setString(7, "%"+diaChi+"%");
			statement.setString(8, "%"+tenChucVu+"%");
			// Thá»±c thi cÃ¢u lá»‡nh SQL tráº£ vá»� Ä‘á»‘i tÆ°á»£ng ResultSet.
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return dsNV;
	}
	
	public String getMaNV() {
		String maNV="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(maNhanVien),3),0) + 1),3)) from [dbo].[NhanVien] where maNhanVien like 'NV%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maNV = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maNV;
	}
	
	public NhanVien getNVtheoMa(String maNV) {
		NhanVien nv = null;
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
			
			String sql = "SELECT maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, NhanVien.maChucVu, tenChucVu FROM ChucVu INNER JOIN NhanVien ON ChucVu.maChucVu = NhanVien.maChucVu WHERE maNhanVien ='"+maNV+"'";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				 nv=new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return nv;
	}

	public boolean DoiSDT(NhanVien nv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update NhanVien set soDT = ? where maNhanVien = ?");
			stmt.setString(2, nv.getMaNV());
			stmt.setString(1, nv.getSoDT());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean DoiNgaySinh(NhanVien nv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update NhanVien set ngaySinh = ? where maNhanVien = ?");
			stmt.setString(2, nv.getMaNV());
			stmt.setDate(1, nv.getNgaySinh());
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public  ArrayList<NhanVien> getNhanVienTK(String tenNV, String sdtNV) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, NhanVien.maChucVu, tenChucVu FROM ChucVu INNER JOIN NhanVien ON ChucVu.maChucVu = NhanVien.maChucVu WHERE tenNhanVien like ? and soDT like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+tenNV+"%");
			statement.setString(2, "%"+sdtNV+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return dsNV;
	}
	
	public  ArrayList<NhanVien> getNhanVienTheoSDT(String sdtNV) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, NhanVien.maChucVu, tenChucVu FROM ChucVu INNER JOIN NhanVien ON ChucVu.maChucVu = NhanVien.maChucVu WHERE soDT like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+sdtNV+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return dsNV;
	}
	
	public  ArrayList<NhanVien> getNhanVienTheoTenNV(String tenNV) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, NhanVien.maChucVu, tenChucVu FROM ChucVu INNER JOIN NhanVien ON ChucVu.maChucVu = NhanVien.maChucVu WHERE tenNhanVien like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+tenNV+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")
						, rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("soCMND")
						, rs.getString("soDT"), rs.getString("diaChi"), new ChucVu(rs.getString("maChucVu"),rs.getString("tenChucVu")));
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return dsNV;
	}
}
