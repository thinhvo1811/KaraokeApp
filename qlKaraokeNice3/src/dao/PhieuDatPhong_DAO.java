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
import entity.PhieuDatPhong;
import entity.Phong;

public class PhieuDatPhong_DAO {
	public List<PhieuDatPhong> getAllPhieuDatPhong() {

		String sql = "select maPhieuDatPhong, pdp.maKhachHang, tenKhachHang, soDT, pdp.maPhong, tenPhong, ngayDatPhong, gioDatPhong from (PhieuDatPhong pdp join KhachHang kh on pdp.maKhachHang = kh.maKhachHang) join Phong p on pdp.maPhong = p.maPhong";
		PreparedStatement statement = null;
		List<PhieuDatPhong> list = new ArrayList<PhieuDatPhong>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				PhieuDatPhong pdp = new PhieuDatPhong(rs.getString("maPhieuDatPhong"), new KhachHang(rs.getString("maKhachHang"),rs.getString("tenKhachHang"),rs.getString("soDT"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getDate("ngayDatPhong"), rs.getTime("gioDatPhong"));
				list.add(pdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  void addPhieuDatPhong(PhieuDatPhong pdp) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into PhieuDatPhong values(?,?,?,?,?)");
				statement.setString(1, pdp.getMaPhieuDatPhong());
				statement.setDate(2, pdp.getNgayDatPhong());
				statement.setTime(3, pdp.getGioDatPhong());
				statement.setString(4, pdp.getKhachhang().getMaKhachHang());
				statement.setString(5, pdp.getPhong().getMaPhong());

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
	public  void updatePDP(PhieuDatPhong pdp) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update PhieuDatPhong set ngayDatPhong=?, gioDatPhong=?, maKhachHang=?, maPhong=? where maPhieuDatPhong=?");
				statement.setDate(1, pdp.getNgayDatPhong());
				statement.setTime(2, pdp.getGioDatPhong());
				statement.setString(3, pdp.getKhachhang().getMaKhachHang());
				statement.setString(4, pdp.getPhong().getMaPhong());
				statement.setString(5, pdp.getMaPhieuDatPhong());
				
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
	
	public  void deletePhieuDatPhong(String maPDP) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from PhieuDatPhong where maPhieuDatPhong=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maPDP);
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
	public String getMaPDP() {
		String maPDP="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('PDP', RIGHT(CONCAT('000',ISNULL(right(max(maPhieuDatPhong),3),0) + 1),3)) from [dbo].[PhieuDatPhong] where maPhieuDatPhong like 'PDP%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maPDP = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maPDP;
	}
	
	public List<PhieuDatPhong> getPhieuDatPhong() {

		String sql = "select maPhieuDatPhong, pdp.maKhachHang, tenKhachHang, soDT, pdp.maPhong, tenPhong, ngayDatPhong, gioDatPhong from (PhieuDatPhong pdp join KhachHang kh on pdp.maKhachHang = kh.maKhachHang) join Phong p on pdp.maPhong = p.maPhong";
		PreparedStatement statement = null;
		List<PhieuDatPhong> list = new ArrayList<PhieuDatPhong>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				PhieuDatPhong pdp = new PhieuDatPhong(rs.getString("maPhieuDatPhong")
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getDate("ngayDatPhong"));
				list.add(pdp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
