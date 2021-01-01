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
import entities.TaiKhoan;

public class QuanLySinhVien {
	private ArrayList<SinhVien> dsSinhVien;

	public QuanLySinhVien() {
		dsSinhVien = new ArrayList<>();
	}

	public ArrayList<SinhVien> getDS() {
		return dsSinhVien;
	}

	public int getMaSV() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maSV from SinhVien order by maSV desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<SinhVien> dsSinhVien() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from SinhVien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getNString(2);
				String tenTK = rs.getString(3);
				int gioiTinh = rs.getInt(4);
				String queQuan = rs.getNString(5);
				java.sql.Date ngaySinh = rs.getDate(6);
				int maKhoa = rs.getInt(7);
				SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, new TaiKhoan(tenTK), new Khoa(maKhoa), ngaySinh,
						queQuan);
				dsSinhVien.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSinhVien;
	}

	public void themSinhVien(SinhVien sv) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into SinhVien" + " values('" + sv.getMaSV() + "',N'" + sv.getHoTen() + "','"
				+ sv.getTaiKhoan().getTenTk() + "'," + sv.getGioitinh() + ",N'" + sv.getQueQuan() + "','"
				+ sv.getNgaySinh() + "'," + sv.getKhoa().getMaKhoa() + ")");
	}

	public SinhVien chiTietSinhVien(String masv_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from SinhVien where maSV = ?");
			st.setString(1, masv_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getNString(2);
				String tenTK = rs.getString(3);
				int gioiTinh = rs.getInt(4);
				String queQuan = rs.getNString(5);
				java.sql.Date ngaySinh = rs.getDate(6);
				int maKhoa = rs.getInt(7);
				SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, new TaiKhoan(tenTK), new Khoa(maKhoa), ngaySinh,
						queQuan);
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatSinhVien(SinhVien sv) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update SinhVien set hoTen = ?, gioiTinh = ?, queQuan = ?, ngaySinh = ?, maKhoa = ? where maSV = ? ");
			stmt.setNString(1, sv.getHoTen());
			stmt.setInt(2, sv.getGioitinh());
			stmt.setNString(3, sv.getQueQuan());
			stmt.setDate(4, sv.getNgaySinh());
			stmt.setInt(5, sv.getKhoa().getMaKhoa());
			stmt.setString(6, sv.getMaSV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(String masv) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from SinhVien where maSV = ?");
		stmt.setString(1, masv);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<SinhVien> tim_SinhVien(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from SinhVien where maSV like ? or hoTen like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getNString(2);
				String tenTK = rs.getString(3);
				int gioiTinh = rs.getInt(4);
				String queQuan = rs.getNString(5);
				java.sql.Date ngaySinh = rs.getDate(6);
				int maKhoa = rs.getInt(7);
				SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, new TaiKhoan(tenTK), new Khoa(maKhoa), ngaySinh,
						queQuan);
				dsSinhVien.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSinhVien;
	}

	public ArrayList<SinhVien> tim_SinhVienTheoKhoa(int maKhoa_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from SinhVien where maKhoa = ?");
			st.setInt(1, maKhoa_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getNString(2);
				String tenTK = rs.getString(3);
				int gioiTinh = rs.getInt(4);
				String queQuan = rs.getNString(5);
				java.sql.Date ngaySinh = rs.getDate(6);
				int maKhoa = rs.getInt(7);
				SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, new TaiKhoan(tenTK), new Khoa(maKhoa), ngaySinh,
						queQuan);
				dsSinhVien.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSinhVien;
	}

}
