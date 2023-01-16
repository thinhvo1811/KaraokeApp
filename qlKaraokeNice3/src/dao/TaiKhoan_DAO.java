package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public List<TaiKhoan> getAllTaiKhoan() {

		String sql = "select tenDangNhap, matKhau, tk.maNhanVien from TaiKhoan tk join NhanVien nv on tk.maNhanVien = nv.maNhanVien";
		PreparedStatement statement = null;
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("tenDangNhap"),rs.getString("matKhau"), new NhanVien(rs.getString("maNhanVien")));
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addTaiKhoan(TaiKhoan tk) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into TaiKhoan values(?,?,?)");
				statement.setString(1, tk.getTenDangNhap());
				statement.setString(2, tk.getMatKhau());
				statement.setString(3, tk.getNhanVien().getMaNV());
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
	public  void updateTaiKhoan(TaiKhoan tk) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update TaiKhoan set matKhau=?, maNhanVien=? where tenDangNhap=?");
				statement.setString(1, tk.getMatKhau());
				statement.setString(2, tk.getNhanVien().getMaNV());
				statement.setString(3, tk.getTenDangNhap());
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
	public  void deleteTaiKhoan(String ten) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from TaiKhoan where tenDangNhap=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, ten);
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
	
	
	public String getTenDN() {
		String tenDN="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('TK', RIGHT(CONCAT('000',ISNULL(right(max(tenDangNhap),3),0) + 1),3)) from [dbo].[TaiKhoan] where tenDangNhap like 'TK%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				tenDN = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenDN;
	}
	
	public boolean DoiMK(TaiKhoan tk) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where tenDangNhap = ?");
			stmt.setString(2, tk.getTenDangNhap());
			stmt.setString(1, tk.getMatKhau());
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
	
	public  TaiKhoan getTaiKHoanTheoTenDN(String tenDN) {
		TaiKhoan tk = null;
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "select tenDangNhap, matKhau, tk.maNhanVien from TaiKhoan tk join NhanVien nv on tk.maNhanVien = nv.maNhanVien where tenDangNhap ='"+tenDN+"'";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				tk = new TaiKhoan(rs.getString("tenDangNhap"),rs.getString("matKhau"), new NhanVien(rs.getString("maNhanVien")));
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
		return tk;
	}
	
	public String getMKTheoTenDN(String tenDN) {
		String mk = "";
		String sql = "SELECT matKhau FROM TaiKhoan where tenDangNhap = N'"+tenDN+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			mk = r.getString(1);
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
		return mk;
	}
}
