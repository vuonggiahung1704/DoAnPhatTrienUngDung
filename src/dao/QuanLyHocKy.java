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
import entities.HocKy;

public class QuanLyHocKy {
	private ArrayList<HocKy> dsHocKy;

	public QuanLyHocKy() {
		dsHocKy = new ArrayList<>();
	}

	public ArrayList<HocKy> getDS() {
		return dsHocKy;
	}

	public int getmaHK() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maHK from HocKy order by maHK desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public ArrayList<HocKy> dsHocKy() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from HocKy order by maHK desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maHK = rs.getInt(1);
				String tenHocKy = rs.getNString(2);
				HocKy HocKy = new HocKy(maHK, tenHocKy);
				dsHocKy.add(HocKy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHocKy;
	}

	public void themHocKy(HocKy HocKy) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into HocKy(tenHK)" + " values(N'" + HocKy.getTenHK() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public HocKy chiTietHocKy(int maHK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from HocKy where maHK = ?");
			st.setInt(1, maHK_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maHK = rs.getInt(1);
				String tenHocKy = rs.getNString(2);
				HocKy HocKy = new HocKy(maHK, tenHocKy);
				return HocKy;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delete(int maHK) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from HocKy where maHK = ?");
		stmt.setInt(1, maHK);
		n = stmt.executeUpdate();
		return n > 0;
	}

}
