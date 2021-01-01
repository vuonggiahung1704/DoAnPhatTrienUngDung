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
import entities.TaiKhoan;
import entities.Khoa;
import entities.TaiKhoan;
import entities.TaiKhoan;

public class QuanLyTaiKhoan {
	private ArrayList<TaiKhoan> dsTaiKhoan;

	public QuanLyTaiKhoan() {
		dsTaiKhoan = new ArrayList<>();
	}

	public ArrayList<TaiKhoan> getDS() {
		return dsTaiKhoan;
	}

	public ArrayList<TaiKhoan> dsTaiKhoan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from TaiKhoan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String tenTk = rs.getString(1);
				String matKhau = rs.getString(2);
				int quyen = rs.getInt(3);
				TaiKhoan tk = new TaiKhoan(tenTk, matKhau, quyen);
				dsTaiKhoan.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public ArrayList<TaiKhoan> tim_TaiKhoan(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TaiKhoan where tenTK like ?");
			st.setString(1, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String tenTk = rs.getString(1);
				String matKhau = rs.getString(2);
				int quyen = rs.getInt(3);
				TaiKhoan tk = new TaiKhoan(tenTk, matKhau, quyen);
				dsTaiKhoan.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public void themTaiKhoan(TaiKhoan tk) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into TaiKhoan" + " values('" + tk.getTenTk() + "','" + tk.getMatKhau() + "',"
					+ tk.getQuyen() + ")");
		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public boolean capNhatMatKhau(TaiKhoan tk) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where tenTK = ? ");
		stmt.setString(1, tk.getMatKhau());
		stmt.setString(2, tk.getTenTk());
		n = stmt.executeUpdate();

		return n > 0;
	}

	public TaiKhoan chiTietTaiKhoan(String matk_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from TaiKhoan where tenTK = ?");
			st.setString(1, matk_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String tenTk = rs.getString(1);
				String matKhau = rs.getString(2);
				int quyen = rs.getInt(3);
				TaiKhoan tk = new TaiKhoan(tenTk, matKhau, quyen);
				return tk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(String matk) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from TaiKhoan where tenTK = ?");
		stmt.setString(1, matk);
		n = stmt.executeUpdate();
		return n > 0;
	}

}
