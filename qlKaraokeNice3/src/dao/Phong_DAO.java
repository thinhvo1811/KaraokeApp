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
import entity.Phong;

public class Phong_DAO {
	public List<Phong> getAllPhong() {

		String sql = "select maPhong, tenPhong, trangThai,p.maLoai,tenLoai,soNguoiToiDa,giaPhong from Phong p join LoaiPhong lp on p.maLoai = lp.maLoai";
		PreparedStatement statement = null;
		List<Phong> list = new ArrayList<Phong>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Phong p = new Phong(rs.getString("maPhong"), rs.getString("tenPhong")
						, rs.getBoolean("trangThai"),new LoaiPhong(rs.getString("maLoai"), rs.getString("tenLoai"), rs.getInt("soNguoiToiDa"), rs.getDouble("giaPhong")));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
		public void addPhong(Phong p) {

			Connect.getInstance();
			Connection con = Connect.getCon();
			PreparedStatement statement = null;
			try {
					statement = con.prepareStatement("insert into Phong values(?,?,?,?)");
					statement.setString(1, p.getMaPhong());
					statement.setString(2, p.getTenPhong());
					statement.setString(3, p.getLoaiPhong().getMaLoai());
					statement.setBoolean(4, p.getTrangThai());
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
		public  void updatePhong(Phong nv) {
			Connect.getInstance();
			Connection con = Connect.getCon();
			PreparedStatement statement = null;
			try {
					statement = con.prepareStatement("update Phong set tenPhong=?, trangThai=?,maLoai=? where maPhong=?");
					statement.setString(1, nv.getTenPhong());
					statement.setBoolean(2, nv.getTrangThai());
					statement.setString(3, nv.getLoaiPhong().getMaLoai());
					statement.setString(4, nv.getMaPhong());
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
		public  void deletePhong(String maPhong) {
			Connect.getInstance();
			Connection con = Connect.getCon();
			PreparedStatement statement = null;
			String sql = "delete from Phong where maPhong=?";
			try {
					statement = con.prepareStatement(sql);
					statement.setString(1, maPhong);
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
		
		public  ArrayList<Phong> getPhong(String maP, String tenP, String loaiP, String trangThai) {
			
			ArrayList<Phong> dsP = new ArrayList<Phong>();
			Connect.getInstance();
			Connection con = Connect.getCon();
			PreparedStatement statement = null;
			try {
			
				String sql = "select maPhong, tenPhong,p.maLoai,tenLoai,soNguoiToiDa,giaPhong,trangThai from Phong p join LoaiPhong lp on p.maLoai = lp.maLoai WHERE maPhong like ? and tenPhong like ? and tenLoai like ? and trangThai like ? ";
				statement=con.prepareStatement(sql);
				statement.setString(1, "%"+maP+"%");
				statement.setString(2, "%"+tenP+"%");
				statement.setString(3, "%"+loaiP+"%");
				statement.setString(4, "%"+trangThai+"%");
				// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					Phong p = new Phong(rs.getString("maPhong"), rs.getString("tenPhong")
							, rs.getBoolean("trangThai"),new LoaiPhong(rs.getString("maLoai"), rs.getString("tenLoai"), rs.getInt("soNguoiToiDa"), rs.getDouble("giaPhong")));
					dsP.add(p);
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
			return dsP;
		}
		
		public String getMaPhong() {
			String maP="";
			Connect.getInstance();
			Connection con = Connect.getCon();
			String sql = "select CONCAT('P', RIGHT(CONCAT('000',ISNULL(right(max(maPhong),3),0) + 1),3)) from [dbo].[Phong] where maPhong like 'P%'";
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					maP = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return maP;
		}
		public double getGiaTheoTenP(String ten) {
			double gia = 0;
			String sql = "SELECT LoaiPhong.giaPhong FROM LoaiPhong INNER JOIN Phong ON LoaiPhong.maLoai = Phong.maLoai Where tenPhong = N'"+ten+"'";
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
		public  void updateTTP(boolean tt, String tenP) {
			Connect.getInstance();
			Connection con = Connect.getCon();
			PreparedStatement statement = null;
			try {
					statement = con.prepareStatement("update Phong set trangThai=?  where tenPhong=?");
					statement.setBoolean(1, tt);
					statement.setString(2, tenP);
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
		public String getMaTheoTenP(String ten) {
			String ma = "";
			String sql = "SELECT maPhong FROM Phong Where tenPhong = N'"+ten+"'";
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
}
