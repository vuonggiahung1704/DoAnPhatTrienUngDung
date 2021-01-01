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
import entities.Khoa;
import entities.SinhVien;
import entities.GiangVien;
import entities.TaiKhoan;

public class QuanLyGiangVien {
	private ArrayList<GiangVien> dsGiangVien;

	public QuanLyGiangVien() {
		dsGiangVien = new ArrayList<>();
	}

	public ArrayList<GiangVien> getDS() {
		return dsGiangVien;
	}

	public int getMaGV() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maGV from GiangVien order by maGV desc";
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

	public ArrayList<GiangVien> dsGiangVien() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from GiangVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maGV = rs.getString(1);
				String hoTen = rs.getNString(2);
				int gioiTinh = rs.getInt(3);
				int maKhoa = rs.getInt(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				GiangVien GV = new GiangVien(maGV, hoTen, gioiTinh, sdt, email, new Khoa(maKhoa));
				dsGiangVien.add(GV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGiangVien;
	}

	public void themGiangVien(GiangVien GV) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate(
				"insert into GiangVien" + " values('" + GV.getMaGV() + "',N'" + GV.getHoTen() + "'," + GV.getGioiTinh()
						+ "," + GV.getKhoa().getMaKhoa() + ",'" + GV.getSdt() + "','" + GV.getEmail() + "')");
	}

	public GiangVien chiTietGiangVien(String maGV_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from GiangVien where maGV = ?");
			st.setString(1, maGV_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maGV = rs.getString(1);
				String hoTen = rs.getNString(2);
				int gioiTinh = rs.getInt(3);
				int maKhoa = rs.getInt(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				GiangVien GV = new GiangVien(maGV, hoTen, gioiTinh, sdt, email, new Khoa(maKhoa));
				return GV;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatGiangVien(GiangVien GV) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement(
				"update GiangVien set hoTen = ?, gioiTinh = ?, maKhoa = ?, sdt = ?, email = ? where maGV = ?");
		stmt.setNString(1, GV.getHoTen());
		stmt.setInt(2, GV.getGioiTinh());
		stmt.setInt(3, GV.getKhoa().getMaKhoa());
		stmt.setString(4, GV.getSdt());
		stmt.setString(5, GV.getEmail());
		stmt.setString(6, GV.getMaGV());
		n = stmt.executeUpdate();

		return n > 0;
	}

	public boolean delete(String maGV) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from GiangVien where maGV = ?");
		stmt.setString(1, maGV);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<GiangVien> tim_GiangVien(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from GiangVien where maGV like ? or hoTen like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maGV = rs.getString(1);
				String hoTen = rs.getNString(2);
				int gioiTinh = rs.getInt(3);
				int maKhoa = rs.getInt(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				GiangVien GV = new GiangVien(maGV, hoTen, gioiTinh, sdt, email, new Khoa(maKhoa));
				dsGiangVien.add(GV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGiangVien;
	}

	public ArrayList<GiangVien> tim_GiangVienTheoKhoa(int maKhoa_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from GiangVien where maKhoa = ?");
			st.setInt(1, maKhoa_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maGV = rs.getString(1);
				String hoTen = rs.getNString(2);
				int gioiTinh = rs.getInt(3);
				int maKhoa = rs.getInt(4);
				String sdt = rs.getString(5);
				String email = rs.getString(6);
				GiangVien GV = new GiangVien(maGV, hoTen, gioiTinh, sdt, email, new Khoa(maKhoa));
				dsGiangVien.add(GV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsGiangVien;
	}
}
