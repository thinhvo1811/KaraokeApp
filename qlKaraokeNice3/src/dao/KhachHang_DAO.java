package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.KhachHang;

public class KhachHang_DAO {
	public List<KhachHang> getAllKhachHang() {

		String sql = "select * from KhachHang";
		PreparedStatement statement = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),rs.getBoolean("gioiTinh"),rs.getString("soDT"));
				list.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<KhachHang> getKhachHangTiemNang() {

		String sql = "SELECT  maKhachHang, tenKhachHang, soDT, soLan = COUNT(tenKhachHang), tongHoaDon = SUM(tongTien)\r\n"
				+ "FROM TKKH_VIEW\r\n"
				+ "WHERE trangThai != 0\r\n"
				+ "GROUP BY maKhachHang, tenKhachHang, soDT\r\n"
				+ "ORDER BY tongHoaDon DESC";
		PreparedStatement statement = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),rs.getString("soDT"));
				list.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addKhachHang(KhachHang kh) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into KhachHang values(?,?,?,?)");
				statement.setString(1, kh.getMaKhachHang());
				statement.setString(2, kh.getTenKhachHang());
				statement.setBoolean(3, kh.isGioiTinh());
				statement.setString(4, kh.getSoDT());
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
	public  void updateKhachHang(KhachHang kh) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update KhachHang set tenKhachHang=?, gioiTinh=?, soDT=? where maKhachHang=?");
				statement.setString(1, kh.getTenKhachHang());
				statement.setBoolean(2, kh.isGioiTinh());
				statement.setString(3, kh.getSoDT());
				statement.setString(4, kh.getMaKhachHang());
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
	public  void deleteKhachHang(String maKH) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from KhachHang where maKhachHang=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maKH);
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
 
	
	public  ArrayList<KhachHang> getKhachHang(String maKH, String tenKH, String gioiTinh, String soDT) {
		
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT * FROM KhachHang WHERE maKhachHang like ? and tenKhachHang like ? and gioiTinh like ? and soDT like ? ";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+maKH+"%");
			statement.setString(2, "%"+tenKH+"%");
			statement.setString(3, "%"+gioiTinh+"%");
			statement.setString(4, "%"+soDT+"%");
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),rs.getBoolean("gioiTinh"),rs.getString("soDT"));
				dsKH.add(kh);
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
		return dsKH;
	}
	
	public String getMaKH() {
		String maKH="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('KH', RIGHT(CONCAT('000',ISNULL(right(max(maKhachHang),3),0) + 1),3)) from [dbo].[KhachHang] where maKhachHang like 'KH%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maKH = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maKH;
	}
	
	public KhachHang getKHTheoSDT(String soDT){
		KhachHang kh = null;
		Connect.getInstance();
		Connection con=Connect.getCon();
		PreparedStatement statement=null;
		try {
			String sql="Select * from KhachHang where soDT=?";
			statement=con.prepareStatement(sql);
			statement.setString(1,soDT);
			
			ResultSet rs=statement.executeQuery();
			
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),rs.getBoolean("gioiTinh"),rs.getString("soDT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kh;
	}
	
	public String getMaKHTheoSoDT(String sdt) {
		String ma = "";
		String sql = "select maKhachHang from KhachHang where soDT = N'"+sdt+"'";
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
	
	public String getSDTTheoMaHD(String maHoaDon) {
		String sdt = "";
		String sql = "SELECT KhachHang.soDT FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong where maHoaDon = N'"+maHoaDon+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			sdt = r.getString(1);
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
		return sdt;
	}
	
	public KhachHang getKHTheoMaKH(String maKH){
		KhachHang kh = null;
		Connect.getInstance();
		Connection con=Connect.getCon();
		PreparedStatement statement=null;
		try {
			String sql="Select * from KhachHang where maKhachHang ='"+maKH+"'";
			statement=con.prepareStatement(sql);
			ResultSet rs=statement.executeQuery();
			
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),rs.getBoolean("gioiTinh"),rs.getString("soDT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kh;
	}
	
	public int getSoLanDenTheoMa(String ma) {
		int soLan = 0;
		String sql = "SELECT  soLan = COUNT(tenKhachHang)\r\n"
				+ "FROM TKKH_VIEW\r\n"
				+ "WHERE maKhachHang = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			soLan = r.getInt(1);
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
		return soLan;
	}
	
	public double getTongHoaDonTheoMa(String ma) {
		double dt = 0;
		String sql = "SELECT  tongHoaDon = SUM(tongTien)\r\n"
				+ "FROM TKKH_VIEW\r\n"
				+ "WHERE maKhachHang = N'"+ma+"'";
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

