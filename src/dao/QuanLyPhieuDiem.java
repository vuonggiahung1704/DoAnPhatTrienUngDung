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
import entities.HoiDong;
import entities.PhanCong;
import entities.PhieuDangKy;
import entities.PhieuDiem;

public class QuanLyPhieuDiem {
	private ArrayList<PhieuDiem> dsPhieuDiem;

	public QuanLyPhieuDiem() {
		dsPhieuDiem = new ArrayList<>();
	}

	public ArrayList<PhieuDiem> getDS() {
		return dsPhieuDiem;
	}
	
	public int getmaPD() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maPD from PhieuDiem order by maPD desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int ID = rs.getInt(1);
				return ID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public ArrayList<PhieuDiem> dsPhieuDiem() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from PhieuDiem";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maPD = rs.getInt(1);
				int mapd = rs.getInt(2);
				int maPDK = rs.getInt(3);
				float diemTB = rs.getFloat(4);
				PhieuDiem pd = new PhieuDiem(maPD, new PhanCong(new PhieuDangKy(maPDK), new HoiDong(mapd)), diemTB);
				dsPhieuDiem.add(pd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDiem;
	}

	public void themPhieuDiem(PhieuDiem pd) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into PhieuDiem(maHD,maPDK)" + " values("
				+ pd.getPhanCong().getHoiDong().getMaHD() + "," + pd.getPhanCong().getPhieuDangKy().getMaPDK() + ")");

	}

	public PhieuDiem chiTietPhieuDiem(int mapd_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDiem where maPD = ?");
			st.setInt(1, mapd_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPD = rs.getInt(1);
				int maPDK = rs.getInt(3);
				int mapd = rs.getInt(2);
				float diemTB = rs.getFloat(4);
				PhieuDiem pd = new PhieuDiem(maPD, new PhanCong(new PhieuDangKy(maPDK), new HoiDong(mapd)), diemTB);
				return pd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PhieuDiem chiTietPhieuDiem_HD_PDK(int maHD_tim,int maPDK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDiem where maHD = ? and maPDK = ?");
			st.setInt(1, maHD_tim);
			st.setInt(2, maPDK_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPD = rs.getInt(1);
				int maPDK = rs.getInt(3);
				int mahd = rs.getInt(2);
				float diem = rs.getFloat(4);
				PhieuDiem pd = new PhieuDiem(maPD, new PhanCong(new PhieuDangKy(maPDK), new HoiDong(mahd)), diem);
				return pd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatPhieuDiem(PhieuDiem pd) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update PhieuDiem set diemTB = ? where maPD = ? ");
			stmt.setFloat(1, pd.getDiemTrungBinh());
			stmt.setInt(2, pd.getMaPD());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int maPD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from PhieuDiem where maPD = ?");
		stmt.setInt(1, maPD);
		n = stmt.executeUpdate();
		return n > 0;
	}
	
	public boolean delete(int maPDK,int maHD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from PhieuDiem where maPDK = ? and maHD = ?");
		stmt.setInt(1, maPDK);
		stmt.setInt(1, maHD);
		n = stmt.executeUpdate();
		return n > 0;
	}
	
	public ArrayList<PhieuDiem> ds_DiemThamDinh(int maPDK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDiem pd join HoiDong hd on pd.maHD = hd.maHD where maPDK = ? and maLHD = 1");
			st.setInt(1, maPDK_tim);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPD = rs.getInt(1);
				int maPDK = rs.getInt(3);
				int mahd = rs.getInt(2);
				float diem = rs.getFloat(4);
				PhieuDiem pd = new PhieuDiem(maPD, new PhanCong(new PhieuDangKy(maPDK), new HoiDong(mahd)), diem);
				dsPhieuDiem.add(pd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDiem;
	}
}
