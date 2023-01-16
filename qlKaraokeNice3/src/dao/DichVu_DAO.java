package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.DichVu;
import entity.LoaiDichVu;

public class DichVu_DAO {
	public List<DichVu> getAllDichVu() {

		String sql = "select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai";
		PreparedStatement statement = null;
		List<DichVu> list = new ArrayList<DichVu>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
					DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
							, rs.getDouble("gia"), rs.getString("donViTinh"), rs.getInt("soLuong")
							, rs.getDate("hanSuDung"), rs.getBoolean("trangThaiKD"), new LoaiDichVu(rs.getString("maLoai"),rs.getString("tenLoai")));
					list.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DichVu> getDichVuUaThich() {

		String sql = "SELECT CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia, soLuongBan = SUM(CT_HoaDon.soLuong), tongDoanhThu=SUM(CT_HoaDon.soLuong)*DichVu.gia\r\n"
				+ "FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu \r\n"
				+ "GROUP BY CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia\r\n"
				+ "ORDER BY soLuongBan DESC";
		PreparedStatement statement = null;
		List<DichVu> list = new ArrayList<DichVu>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
					DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
							, rs.getDouble("gia"), rs.getString("donViTinh"));
					list.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addDichVu(DichVu dv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into DichVu values(?,?,?,?,?,?,?,?)");
				statement.setString(1, dv.getMaDichVu());
				statement.setString(2, dv.getTenDichVu());
				statement.setDouble(3, dv.getGia());
				statement.setString(4, dv.getDonViTinh());
				statement.setInt(5, dv.getSoLuong());
				statement.setDate(6, dv.getHanSuDung());
				statement.setBoolean(7, dv.isTrangThaiKD());
				statement.setString(8, dv.getLoaiDichVu().getMaLoai());
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
	
	public  void addDichVuKCoHSD(DichVu dv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into DichVu values(?,?,?,?,-1,'',?,?)");
				statement.setString(1, dv.getMaDichVu());
				statement.setString(2, dv.getTenDichVu());
				statement.setDouble(3, dv.getGia());
				statement.setString(4, dv.getDonViTinh());
				statement.setBoolean(5, dv.isTrangThaiKD());
				statement.setString(6, dv.getLoaiDichVu().getMaLoai());
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
	
	public  void updateDichVuKCoHSD(DichVu dv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update DichVu set tenDichVu=?, gia=?, donViTinh=?, soLuong=-1, hanSuDung='', trangThaiKD=?, maLoai=? where maDichVu=?");
				statement.setString(1, dv.getTenDichVu());
				statement.setDouble(2, dv.getGia());
				statement.setString(3, dv.getDonViTinh());
				statement.setBoolean(4, dv.isTrangThaiKD());
				statement.setString(5, dv.getLoaiDichVu().getMaLoai());
				statement.setString(6, dv.getMaDichVu());
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
	
	public  void updateDichVu(DichVu dv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update DichVu set tenDichVu=?, gia=?, donViTinh=?, soLuong=?, hanSuDung=?, trangThaiKD=?, maLoai=? where maDichVu=?");
				statement.setString(1, dv.getTenDichVu());
				statement.setDouble(2, dv.getGia());
				statement.setString(3, dv.getDonViTinh());
				statement.setInt(4, dv.getSoLuong());
				statement.setDate(5, dv.getHanSuDung());
				statement.setBoolean(6, dv.isTrangThaiKD());
				statement.setString(7, dv.getLoaiDichVu().getMaLoai());
				statement.setString(8, dv.getMaDichVu());
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
	
	public  void deleteDichVu(String maDV) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from DichVu where maDichVu=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maDV);
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
	
	public  ArrayList<DichVu> getDichVu(String maDV, String tenDV, String gia, String donViTinh, String soLuong, String HSD, String trangThaiKD, String loaiDV) {
		
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai WHERE maDichVu like ? and tenDichVu like ? and gia like ? and donViTinh like ? and soLuong like ? and hanSuDung like ? and trangThaiKD like ? and tenLoai like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+maDV+"%");
			statement.setString(2, "%"+tenDV+"%");
			statement.setString(3, "%"+gia+"%");
			statement.setString(4, "%"+donViTinh+"%");
			statement.setString(5, "%"+soLuong+"%");
			statement.setString(6, "%"+HSD+"%");
			statement.setString(7, "%"+trangThaiKD+"%");
			statement.setString(8, "%"+loaiDV+"%");
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
						, rs.getDouble("gia"), rs.getString("donViTinh"), rs.getInt("soLuong")
						, rs.getDate("hanSuDung"), rs.getBoolean("trangThaiKD"), new LoaiDichVu(rs.getString("maLoai"),rs.getString("tenLoai")));
				dsDV.add(dv);
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
		return dsDV;
	}
	
	public String getMaDV() {
		String maDV="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('DV', RIGHT(CONCAT('000',ISNULL(right(max(maDichVu),3),0) + 1),3)) from [dbo].[DichVu] where maDichVu like 'DV%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maDV = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maDV;
	}
	
	public  ArrayList<DichVu> getDichVuSHH() {
		
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		
		try {
		
			String sql = "select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai where DATEDIFF(DAY, GETDATE(), hanSuDung) <= 15 and soLuong>0";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
						, rs.getDouble("gia"), rs.getString("donViTinh"), rs.getInt("soLuong")
						, rs.getDate("hanSuDung"), rs.getBoolean("trangThaiKD"), new LoaiDichVu(rs.getString("maLoai"),rs.getString("tenLoai")));
				dsDV.add(dv);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	
	public  ArrayList<DichVu> getDichVuHetSL() {
		
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		
		try {
		
			String sql = "select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai where soLuong <= 10";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
						, rs.getDouble("gia"), rs.getString("donViTinh"), rs.getInt("soLuong")
						, rs.getDate("hanSuDung"), rs.getBoolean("trangThaiKD"), new LoaiDichVu(rs.getString("maLoai"),rs.getString("tenLoai")));
				dsDV.add(dv);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDV;
	}
	
	
	public List<DichVu> getDichVuTheoLoai(String loai) {

		String sql = "SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.maLoai, LoaiDichVu.tenLoai FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoai = LoaiDichVu.maLoai where tenLoai = N'"+loai+"'";
		PreparedStatement statement = null;
		List<DichVu> list = new ArrayList<DichVu>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
					DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"));
					list.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getDVTTheoTen(String ten) {
		String dvt = "";
		String sql = "SELECT donViTinh FROM DichVu where tenDichVu = N'"+ten+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			dvt = r.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dvt;
	}
	
	public double getGiaTheoTen(String ten) {
		double gia = 0;
		String sql = "SELECT gia FROM DichVu where tenDichVu = N'"+ten+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			gia = r.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gia;
	}
	
	public String getMaTheoTen(String ten) {
		String ma = "";
		String sql = "SELECT maDichVu FROM DichVu where tenDichVu = N'"+ten+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			ma = r.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ma;
	}
	
	public DichVu getDichVuTheoMaDV(String maDV) {
		DichVu dv = null;
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.gia, DichVu.donViTinh, DichVu.soLuong, DichVu.hanSuDung, DichVu.trangThaiKD, LoaiDichVu.maLoai, LoaiDichVu.tenLoai FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoai = LoaiDichVu.maLoai where DichVu.maDichVu = '"+maDV+"'";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu")
						, rs.getDouble("gia"), rs.getString("donViTinh"), rs.getInt("soLuong")
						, rs.getDate("hanSuDung"), rs.getBoolean("trangThaiKD"), new LoaiDichVu(rs.getString("maLoai"),rs.getString("tenLoai")));
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
		return dv;
	}
	
	public  void updateSoLuong(int sl, String ma) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update DichVu set soLuong=? where maDichVu=?");
				statement.setInt(1, sl);
				statement.setString(2, ma);
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
	
	public int getSLTheoTen(String ten) {
		int sl = 0;
		String sql = "SELECT soLuong FROM DichVu where tenDichVu = N'"+ten+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			sl = r.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sl;
	}
	
	public int getSLBanTheoMa(String ma) {
		int sl = 0;
		String sql = "SELECT soLuongBan = SUM(CT_HoaDon.soLuong)\r\n"
				+ "FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu \r\n"
				+ "WHERE CT_HoaDon.maDichVu =  N'"+ma+"'\r\n"
				+ "GROUP BY CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia\r\n"
				+ "ORDER BY soLuongBan DESC";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			sl = r.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sl;
	}

	public double getTongDTTheoMa(String ma) {
		double dt = 0;
		String sql = "SELECT tongDoanhThu=SUM(CT_HoaDon.soLuong)*DichVu.gia\r\n"
				+ "FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu \r\n"
				+ "WHERE CT_HoaDon.maDichVu =  N'"+ma+"'\r\n"
				+ "GROUP BY CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia\r\n";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			dt = r.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dt;
	}
}
