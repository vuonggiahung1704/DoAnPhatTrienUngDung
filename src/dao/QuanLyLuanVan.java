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
import entities.Khoa;
import entities.LuanVan;
import entities.TaiKhoan;

public class QuanLyLuanVan {
	private ArrayList<LuanVan> dsLuanVan;

	public QuanLyLuanVan() {
		dsLuanVan = new ArrayList<>();
	}

	public ArrayList<LuanVan> getDS() {
		return dsLuanVan;
	}

	public int getmaLV() throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		String sql = "select top 1 maLV from LuanVan order by maLV desc";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		int ID = 0;
		while (rs.next()) {
			ID = rs.getInt(1);
		}
		return ID + 1;
	}

	public ArrayList<LuanVan> dsLuanVan() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from LuanVan";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maLV = rs.getInt(1);
				String tenLV = rs.getNString(2);
				int soLuongDk = rs.getInt(3);
				String maGV = rs.getString(4);
				int maKhoa = rs.getInt(5);
				int maHK = rs.getInt(6);
				LuanVan lv = new LuanVan(maLV, tenLV, new GiangVien(maGV), new Khoa(maKhoa), soLuongDk,
						new HocKy(maHK));
				dsLuanVan.add(lv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLuanVan;
	}

	public void themLuanVan(LuanVan lv) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into LuanVan(tenLV,soLuongDK,maGV,maKhoa,maHK)" + " values(N'" + lv.getTenLV()
					+ "'," + lv.getSoLuongDk() + ",'" + lv.getGiangVien().getMaGV() + "'," + lv.getKhoa().getMaKhoa()
					+ "," + lv.getHocKy().getMaHK() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public LuanVan chiTietLuanVan(int maLV_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from LuanVan where maLV = ?");
			st.setInt(1, maLV_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maLV = rs.getInt(1);
				String tenLV = rs.getNString(2);
				int soLuongDk = rs.getInt(3);
				String maGV = rs.getString(4);
				int maKhoa = rs.getInt(5);
				int maHK = rs.getInt(6);
				LuanVan lv = new LuanVan(maLV, tenLV, new GiangVien(maGV), new Khoa(maKhoa), soLuongDk,
						new HocKy(maHK));
				return lv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatLuanVan(LuanVan lv) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update LuanVan set tenLV = ?, soLuongDK = ?, maGV = ?, maKhoa = ?, maHK = ? where maLV = ? ");
			stmt.setNString(1, lv.getTenLV());
			stmt.setInt(2, lv.getSoLuongDk());
			stmt.setString(3, lv.getGiangVien().getMaGV());
			stmt.setInt(4, lv.getKhoa().getMaKhoa());
			stmt.setInt(5, lv.getHocKy().getMaHK());
			stmt.setInt(6, lv.getMaLV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int maLV) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from LuanVan where maLV = ?");
		stmt.setInt(1, maLV);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public ArrayList<LuanVan> tim_LuanVan(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from LuanVan where maLV like ? or tenLV like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maLV = rs.getInt(1);
				String tenLV = rs.getNString(2);
				int soLuongDk = rs.getInt(3);
				String maGV = rs.getString(4);
				int maKhoa = rs.getInt(5);
				int maHK = rs.getInt(6);
				LuanVan lv = new LuanVan(maLV, tenLV, new GiangVien(maGV), new Khoa(maKhoa), soLuongDk,
						new HocKy(maHK));
				dsLuanVan.add(lv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLuanVan;
	}

	public ArrayList<LuanVan> tim_LuanVanTheoKhoa(int maKhoa_tim,int maHK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from LuanVan where maKhoa = ? and maHK = ?");
			st.setInt(1, maKhoa_tim);
			st.setInt(2, maHK_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maLV = rs.getInt(1);
				String tenLV = rs.getNString(2);
				int soLuongDk = rs.getInt(3);
				String maGV = rs.getString(4);
				int maKhoa = rs.getInt(5);
				int maHK = rs.getInt(6);
				LuanVan lv = new LuanVan(maLV, tenLV, new GiangVien(maGV), new Khoa(maKhoa), soLuongDk,
						new HocKy(maHK));
				dsLuanVan.add(lv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLuanVan;
	}

	public ArrayList<LuanVan> tim_LuanVan_Trong_Khoa(String txt, int maKhoa_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from LuanVan where tenLV like ? and maKhoa = ?");
			st.setNString(1, "%" + txt + "%");
			st.setInt(2, maKhoa_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maLV = rs.getInt(1);
				String tenLV = rs.getNString(2);
				int soLuongDk = rs.getInt(3);
				String maGV = rs.getString(4);
				int maKhoa = rs.getInt(5);
				int maHK = rs.getInt(6);
				LuanVan lv = new LuanVan(maLV, tenLV, new GiangVien(maGV), new Khoa(maKhoa), soLuongDk,
						new HocKy(maHK));
				dsLuanVan.add(lv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLuanVan;
	}
}
