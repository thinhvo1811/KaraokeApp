package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;

import entity.LoaiDichVu;


public class LoaiDichVu_DAO {
	public List<LoaiDichVu> getAllLoaiDichVu() {

		String sql = "select * from LoaiDichVu";
		PreparedStatement statement = null;
		List<LoaiDichVu> list = new ArrayList<LoaiDichVu>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				LoaiDichVu ldv = new LoaiDichVu(rs.getString("maLoai"), rs.getString("tenLoai"));
				list.add(ldv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addLoaiDichVu(LoaiDichVu ldv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into LoaiDichVu values(?,?)");
				statement.setString(1, ldv.getMaLoai());
				statement.setString(2, ldv.getTenLoai());
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
	
	public  void updateLoaiDichVu(LoaiDichVu ldv) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update LoaiDichVu set tenLoai=? where maLoai=?");
				statement.setString(1, ldv.getTenLoai());
				statement.setString(2, ldv.getMaLoai());
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
	
	public  void deleteLoaiDichVu(String maLDV) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from LoaiDichVu where maLoai=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maLDV);
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
	
	public String getMaLoaiDVTheoTen(String ten) {
		String ma = "";
		String sql = "select maLoai from LoaiDichVu where tenLoai = N'"+ten+"'";
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
	public String getMaLoaiDV() {
		String maLDV="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('LDV', RIGHT(CONCAT('000',ISNULL(right(max(maLoai),3),0) + 1),3)) from [dbo].[LoaiDichVu] where maLoai like 'LDV%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maLDV = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maLDV;
	}
}
