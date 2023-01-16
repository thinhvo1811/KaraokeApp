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



public class ChucVu_DAO {
	public List<ChucVu> getAllChucVu() {

		String sql = "select * from ChucVu";
		PreparedStatement statement = null;
		List<ChucVu> list = new ArrayList<ChucVu>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				ChucVu cv = new ChucVu(rs.getString("maChucVu"), rs.getString("tenChucVu"));
				list.add(cv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addChucVu(ChucVu cv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into ChucVu values(?,?)");
				statement.setString(1, cv.getMaChucVu());
				statement.setString(2, cv.getTenChucVu());
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
	public  void updateChucVu(ChucVu cv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update ChucVu set tenChucVu=? where maChucVu=?");
				statement.setString(1, cv.getTenChucVu());
				statement.setString(2, cv.getMaChucVu());
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
	public  void deleteChucVu(String maCV) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from ChucVu where maChucVu=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maCV);
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
	public String getMaCVTheoTen(String ten) {
		String ma = "";
		String sql = "select maChucVu from ChucVu where tenChucVu = N'"+ten+"'";
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
	public String getMaCV() {
		String maCV="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('CV', RIGHT(CONCAT('000',ISNULL(right(max(maChucVu),3),0) + 1),3)) from [dbo].[ChucVu] where maChucVu like 'CV%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maCV = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCV;
	}
}
