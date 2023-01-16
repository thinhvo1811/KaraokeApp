package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.LoaiPhong;

public class LoaiPhong_DAO {
	public List<LoaiPhong> getAllLoaiPhong() {

		String sql = "select * from LoaiPhong";
		PreparedStatement statement = null;
		List<LoaiPhong> list = new ArrayList<LoaiPhong>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				LoaiPhong lp = new LoaiPhong(rs.getString("maLoai"), rs.getString("tenLoai"), Integer.parseInt(rs.getString("soNguoiToiDa")),Double.parseDouble(rs.getString("giaPhong")));
				list.add(lp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  void addLoaiPhong(LoaiPhong lp) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into LoaiPhong values(?,?,?,?)");
				statement.setString(1, lp.getMaLoai());
				statement.setString(2, lp.getTenloai());
				statement.setInt(3, lp.getSoNguoiToiDa());
				statement.setDouble(4, lp.getGiaPhong());
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
	public  void updateLoaiPhong(LoaiPhong lp) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update LoaiPhong set tenLoai=?, soNguoiToiDa=?, giaPhong=? where maLoai=?");
				statement.setString(1, lp.getTenloai());
				statement.setInt(2, lp.getSoNguoiToiDa());
				statement.setDouble(3, lp.getGiaPhong());
				statement.setString(4, lp.getMaLoai());
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
	public  void deleteLoaiPhong(String maLP) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from LoaiPhong where maLoai=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maLP);
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
	public String getMaLoaiPTheoTen(String ten) {
		String ma = "";
		String sql = "select maLoai from LoaiPhong where tenLoai = N'"+ten+"'";
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
	public String getMaLoaiP() {
		String maLP="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('LP', RIGHT(CONCAT('000',ISNULL(right(max(maLoai),3),0) + 1),3)) from [dbo].[LoaiPhong] where maLoai like 'LP%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maLP = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maLP;
	}
}
