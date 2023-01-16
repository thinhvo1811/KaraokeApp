package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;

public class HoaDon_DAO {
	public List<HoaDon> getAllHoaDon() {

		String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, KhachHang.soDT, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong";
		PreparedStatement statement = null;
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {

			statement = Connect.getCon().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getString("soDT"))
							, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
							, rs.getBoolean("trangThai"));
				list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  void addHoaDonKCoNVVaGR(HoaDon hd) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,'00:00:59',0,0)");
				statement.setString(1, hd.getMaHoaDon());
				statement.setDate(2, hd.getNgayLapHD());
				statement.setString(3, hd.getNhanvien().getMaNV());
				statement.setString(4, hd.getKhachhang().getMaKhachHang());
				statement.setString(5, hd.getPhong().getMaPhong());
				statement.setTime(6, hd.getGioVao());
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
	
	public  ArrayList<HoaDon> getHoaDon(String maHD, String ngayLapHD, String tenNV, String tenKH, String tenP, String trangThai) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE maHoaDon like ? and ngayLapHD like ? and tenNhanVien like ? and tenKhachHang like ? and tenPhong like ? and HoaDon.trangThai like ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+maHD+"%");
			statement.setString(2, "%"+ngayLapHD+"%");
			statement.setString(3, "%"+tenNV+"%");
			statement.setString(4, "%"+tenKH+"%");
			statement.setString(5, "%"+tenP+"%");
			statement.setString(6, "%"+trangThai+"%");
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public String getMaHoaDon() {
		String maHD="";
		Connect.getInstance();
		Connection con = Connect.getCon();
		String sql = "select CONCAT('HD', RIGHT(CONCAT('000',ISNULL(right(max(maHoaDon),3),0) + 1),3)) from [dbo].[HoaDon] where maHoaDon like 'HD%'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				maHD = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maHD;
	}
	
	
	public  ArrayList<HoaDon> getHDTheoPhong(String tenP) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.trangThai, HoaDon.tongTienPhong FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE tenPhong like ? and HoaDon.trangThai = 0";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+tenP+"%");
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  void updateGioRa(Time gioRa, double tongTienPhong, String maHD) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update HoaDon set gioRa=?, tongTienPhong=? where maHoaDon=?");
				statement.setTime(1, gioRa);
				statement.setDouble(2, tongTienPhong);
				statement.setString(3, maHD);
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
	
	public  void updateTTHD(boolean tt, String maHD) {
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
				statement = con.prepareStatement("update HoaDon set trangThai=?  where maHoaDon=?");
				statement.setBoolean(1, tt);
				statement.setString(2, maHD);
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
	
	public NhanVien getNVTheoHD(String ma) {
		NhanVien nv = null;
		String sql = "SELECT HoaDon.maNhanVien, NhanVien.tenNhanVien FROM HoaDon INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			nv = new NhanVien(r.getString(1), r.getString(2));
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
		return nv;
	}
	
	public Date getNgayLapHD(String ma) {
		Date ngay = null;
		String sql = "SELECT ngayLapHD FROM HoaDon where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			ngay = r.getDate(1);
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
		return ngay;
	}
	
	public KhachHang getKHTheoHD(String ma) {
		KhachHang kh = null;
		String sql = "SELECT HoaDon.maKhachHang, KhachHang.tenKhachHang FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			kh = new KhachHang(r.getString(1), r.getString(2)); 
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
		return kh;
	}
	
	public Time getGioVao(String ma) {
		Time gio = null;
		String sql = "SELECT gioVao FROM HoaDon where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			gio = r.getTime(1);
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
		return gio;
	}
	
	public Time getGioRa(String ma) {
		Time gio = null;
		String sql = "SELECT gioRa FROM HoaDon where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			gio = r.getTime(1);
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
		return gio;
	}
	
	public double getTienPhong(String ma) {
		double tienPhong = 0;
		String sql = "SELECT tongTienPhong FROM HoaDon where maHoaDon = N'"+ma+"'";
		PreparedStatement statement = null;
		try {
			statement = Connect.getCon().prepareStatement(sql);
			ResultSet r = statement.executeQuery();
			r.next();
			tienPhong = r.getDouble(1);
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
		return tienPhong;
	}
	
	public  ArrayList<HoaDon> getHDTheoNgay(Date ngay) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE ngayLapHD like ? and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+ngay+"%");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoNgayvaNV(Date ngay, String maNV) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE ngayLapHD like ? and NhanVien.maNhanVien like ? and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			statement.setString(1, "%"+ngay+"%");
			statement.setString(2, "%"+maNV+"%");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoThang(int mounth, int year, int day) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE MONTH(ngayLapHD)='"+mounth+"' and YEAR(ngayLapHD)='"+year+"' and DAY(ngayLapHD)='"+day+"' and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoThangvaNV(int mounth, int year, int day, String maNV) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE MONTH(ngayLapHD)='"+mounth+"' and YEAR(ngayLapHD)='"+year+"' and DAY(ngayLapHD)='"+day+"' and NhanVien.maNhanVien ='"+maNV+"' and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoNam(int mounth, int year) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE MONTH(ngayLapHD)='"+mounth+"' and YEAR(ngayLapHD)='"+year+"' and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoNamvaNV(int mounth, int year, String maNV) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE MONTH(ngayLapHD)='"+mounth+"' and YEAR(ngayLapHD)='"+year+"' and NhanVien.maNhanVien ='"+maNV+"' and HoaDon.trangThai=1";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
	
	public  ArrayList<HoaDon> getHDTheoMaKH(String maKH) {
		
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		Connect.getInstance();
		Connection con = Connect.getCon();
		PreparedStatement statement = null;
		try {
		
			String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.tongTienPhong, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE KhachHang.maKhachHang ='"+maKH+"'";
			statement=con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"), rs.getDate("ngayLapHD"), new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien")), new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"))
						, new Phong(rs.getString("maPhong"), rs.getString("tenPhong")), rs.getTime("gioVao"), rs.getTime("gioRa"), rs.getDouble("tongTienPhong")
						, rs.getBoolean("trangThai"));
				dsHD.add(hd);
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
		return dsHD;
	}
}
