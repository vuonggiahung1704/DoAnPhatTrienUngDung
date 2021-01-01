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
import entities.HocKy;
import entities.HoiDong;
import entities.Khoa;
import entities.LuanVan;
import entities.ChiTietHoiDong;
import entities.TaiKhoan;

public class QuanLyChiTietHoiDong {
	private ArrayList<ChiTietHoiDong> dsChiTietHoiDong;

	public QuanLyChiTietHoiDong() {
		dsChiTietHoiDong = new ArrayList<>();
	}

	public ArrayList<ChiTietHoiDong> getDS() {
		return dsChiTietHoiDong;
	}

	public void themChiTietHoiDong(ChiTietHoiDong cthd) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into ChiTietHoiDong" + " values(" + cthd.getHoiDong().getMaHD() + ",'"
				+ cthd.getGiangVien().getMaGV() + "')");
	}

	public boolean delete(ChiTietHoiDong cthd) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from ChiTietHoiDong where maHD = ? and maGV = ?");
		stmt.setInt(1, cthd.getHoiDong().getMaHD());
		stmt.setString(2, cthd.getGiangVien().getMaGV());
		n = stmt.executeUpdate();
		return n > 0;
	}
	
	public boolean delete_CTHD_HoiDong(int maHD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from ChiTietHoiDong where maHD = ?");
		stmt.setInt(1, maHD);
		n = stmt.executeUpdate();
		return n > 0;
	}
	
	public int demChiTietHoiDong_HoiDong(int maHD) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select count(maHD) from ChiTietHoiDong where maHD = ?");
		st.setInt(1, maHD);
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}

	public ArrayList<ChiTietHoiDong> tim_ChiTietHoiDong_HoiDong(int maHD_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietHoiDong where maHD = ?");
			st.setInt(1, maHD_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maHD = rs.getInt(1);
				String maGV = rs.getString(2);
				ChiTietHoiDong hd = new ChiTietHoiDong(new HoiDong(maHD), new GiangVien(maGV));
				dsChiTietHoiDong.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoiDong;
	}

}
