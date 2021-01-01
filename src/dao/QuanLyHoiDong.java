package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import database.Database;
import entities.GiangVien;
import entities.Khoa;
import entities.LoaiHoiDong;
import entities.HoiDong;
import entities.TaiKhoan;

public class QuanLyHoiDong {
	private ArrayList<HoiDong> dsHoiDong;

	public QuanLyHoiDong() {
		dsHoiDong = new ArrayList<>();
	}

	public ArrayList<HoiDong> getDS() {
		return dsHoiDong;
	}

	public int getmaHD() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maHD from HoiDong order by maHD desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<HoiDong> dsHoiDong() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from HoiDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maLHD = rs.getInt(2);
				java.sql.Date ngayLap = rs.getDate(3);
				HoiDong hd = new HoiDong(maHD, new LoaiHoiDong(maLHD), ngayLap);
				dsHoiDong.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoiDong;
	}

	public void themHoiDong(HoiDong hd) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into HoiDong(maLHD,ngayLap)" + " values(" + hd.getLoaiHoiDong().getMaLHD()
					+ ",'"+hd.getNgayLap()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HoiDong chiTietHoiDong(int maHD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from HoiDong where maHD = ?");
			st.setInt(1, maHD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maLHD = rs.getInt(2);
				java.sql.Date ngayLap = rs.getDate(3);
				HoiDong hd = new HoiDong(maHD, new LoaiHoiDong(maLHD), ngayLap);
				return hd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatHoiDong(HoiDong hd) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update HoiDong set maLHD = ? where maHD = ? ");
			stmt.setInt(1, hd.getLoaiHoiDong().getMaLHD());
			stmt.setInt(2, hd.getMaHD());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int maHD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from HoiDong where maHD = ?");
		stmt.setInt(1, maHD);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<HoiDong> tim_HoiDong_Loai(int text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from HoiDong where maLHD = ?");
			st.setInt(1, text);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maLHD = rs.getInt(2);
				java.sql.Date ngayLap = rs.getDate(3);
				HoiDong hd = new HoiDong(maHD, new LoaiHoiDong(maLHD), ngayLap);
				dsHoiDong.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoiDong;
	}
	
	public ArrayList<HoiDong> tim_HoiDong(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from HoiDong where maHD like ?");
			st.setString(1, "%"+text+"%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maLHD = rs.getInt(2);
				java.sql.Date ngayLap = rs.getDate(3);
				HoiDong hd = new HoiDong(maHD, new LoaiHoiDong(maLHD), ngayLap);
				dsHoiDong.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoiDong;
	}
	
	public int tim_HoiDong_TrongPhieuDiem(int maHD_tim) {
		int sl = 0;
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select count(maHD) from PhieuDiem where maHD = ?");
			st.setInt(1, maHD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (Exception e) {
			sl = 0;
		}
		return sl;
	}

}
