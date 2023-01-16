package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.CT_HoaDon;
import entity.DichVu;
import entity.HoaDon;


public class CT_HoaDon_DAO {
	public List<CT_HoaDon> getAllCTHD() {

		String sql = "SELECT CT_HoaDon.maHoaDon, CT_HoaDon.maDichVu, DichVu.tenDichVu, CT_HoaDon.gia, CT_HoaDon.soLuong, CT_HoaDon.donViTinh FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu";
		PreparedStatement statement = null;
		List<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				CT_HoaDon cthd = new CT_HoaDon(new HoaDon(rs.getString("maHoaDon")), new DichVu(rs.getString("maDichVu"),rs.getString("tenDichVu"))
						, rs.getDouble("gia"), rs.getInt("soLuong"), rs.getString("donViTinh"));
				list.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<CT_HoaDon> getAllCTHDTheoMa(String ma) {

		String sql = "SELECT CT_HoaDon.maHoaDon, CT_HoaDon.maDichVu, DichVu.tenDichVu, CT_HoaDon.gia, CT_HoaDon.soLuong, CT_HoaDon.donViTinh FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		List<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				CT_HoaDon cthd = new CT_HoaDon(new HoaDon(rs.getString("maHoaDon")), new DichVu(rs.getString("maDichVu"),rs.getString("tenDichVu"))
						, rs.getDouble("gia"), rs.getInt("soLuong"), rs.getString("donViTinh"));
				list.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  void addCTHD(CT_HoaDon cthd) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into CT_HoaDon values(?,?,?,?,?)");
				statement.setString(1, cthd.getHoaDon().getMaHoaDon());
				statement.setString(2, cthd.getDichvu().getMaDichVu());
				statement.setDouble(3, cthd.getGiaBan());
				statement.setInt(4, cthd.getSoLuong());
				statement.setString(5, cthd.getDonViTinh());

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
	public  void updateCTHD(CT_HoaDon cthd) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update CT_HoaDon set soLuong=? where maHoaDon=? and maDichVu=?");
				statement.setInt(1, cthd.getSoLuong());
				statement.setString(2, cthd.getHoaDon().getMaHoaDon());
				statement.setString(3, cthd.getDichvu().getMaDichVu());
				
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
	
	public  void deleteCTHD(String maHD, String maDV) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		String sql = "delete from CT_HoaDon where maHoaDon=? and maDichVu=?";
		try {
				statement = con.prepareStatement(sql);
				statement.setString(1, maHD);
				statement.setString(2, maDV);
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
	
	public ArrayList<CT_HoaDon> getCTHDTheoMaDV(String maDV) {

		String sql = "SELECT CT_HoaDon.maHoaDon, CT_HoaDon.maDichVu, DichVu.tenDichVu, CT_HoaDon.gia, CT_HoaDon.soLuong, CT_HoaDon.donViTinh FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu INNER JOIN HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon where CT_HoaDon.maDichVu = '"+maDV+"' and HoaDon.trangThai =1";
		PreparedStatement statement = null;
		ArrayList<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				CT_HoaDon cthd = new CT_HoaDon(new HoaDon(rs.getString("maHoaDon")), new DichVu(rs.getString("maDichVu"),rs.getString("tenDichVu"))
						, rs.getDouble("gia"), rs.getInt("soLuong"), rs.getString("donViTinh"));
				list.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
