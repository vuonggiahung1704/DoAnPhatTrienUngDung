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
import entities.PhieuDiem;
import entities.ChiTietHoiDong;
import entities.ChiTietPhieuDiem;
import entities.TaiKhoan;

public class QuanLyChiTietPhieuDiem {
	private ArrayList<ChiTietPhieuDiem> dsChiTietPhieuDiem;

	public QuanLyChiTietPhieuDiem() {
		dsChiTietPhieuDiem = new ArrayList<>();
	}

	public ArrayList<ChiTietPhieuDiem> getDS() {
		return dsChiTietPhieuDiem;
	}

	public void themChiTietPhieuDiem(ChiTietPhieuDiem ctpd) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into ChiTietPhieuDiem(maPD,maGV,maHD)" + " values(" + ctpd.getPhieuDiem().getMaPD() + ",'"
				+ ctpd.getChiTietHoiDong().getGiangVien().getMaGV() + "',"+ctpd.getChiTietHoiDong().getHoiDong().getMaHD()+")");
	}

	public boolean delete_ctpd_PhieuDiem(int maPD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from ChiTietPhieuDiem where maPD = ?");
		stmt.setInt(1, maPD);
		n = stmt.executeUpdate();
		return n > 0;
	}
	
	public boolean capNhatDiem(ChiTietPhieuDiem ct) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update ChiTietPhieuDiem set diem = ? where maPD = ? and maGV = ? and maHD = ?");
			stmt.setFloat(1, ct.getDiem());
			stmt.setInt(2, ct.getPhieuDiem().getMaPD());
			stmt.setString(3, ct.getChiTietHoiDong().getGiangVien().getMaGV());
			stmt.setInt(4, ct.getChiTietHoiDong().getHoiDong().getMaHD());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<ChiTietPhieuDiem> tim_ChiTietPhieuDiem_PD(int maPD_tim) {
		dsChiTietPhieuDiem = new ArrayList<>();
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from ChiTietPhieuDiem where maPD = ?");
			st.setInt(1, maPD_tim);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPD = rs.getInt(1);
				String maGV = rs.getString(2);
				int maHD = rs.getInt(3);
				float diem = rs.getFloat(4);
				ChiTietPhieuDiem hd = new ChiTietPhieuDiem(new PhieuDiem(maPD), new ChiTietHoiDong(new HoiDong(maHD), new GiangVien(maGV)),diem);
				dsChiTietPhieuDiem.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietPhieuDiem;
	}

}
