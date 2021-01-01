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
import entities.LoaiHoiDong;
import entities.PhanCong;
import entities.PhieuDangKy;
import entities.TaiKhoan;

public class QuanLyPhanCong {
	private ArrayList<PhanCong> dsPhanCong;

	public QuanLyPhanCong() {
		dsPhanCong = new ArrayList<>();
	}

	public ArrayList<PhanCong> getDS() {
		return dsPhanCong;
	}

	public ArrayList<PhanCong> dsPhanCong(HocKy hk,Khoa k,LoaiHoiDong lhd) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from dbo.xemDSPhanCong_HK_Khoa_LoaiHoiDong(?,?,?)");
			st.setInt(1, hk.getMaHK());
			st.setInt(2, k.getMaKhoa());
			st.setInt(3, lhd.getMaLHD());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maPDK = rs.getInt(2);
				java.sql.Date ngayPC = rs.getDate(3);
				java.sql.Date ngayBC = rs.getDate(4);
				PhanCong pc = new PhanCong(new PhieuDangKy(maPDK), new HoiDong(maHD), ngayPC, ngayBC);
				dsPhanCong.add(pc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhanCong;
	}
	
	public ArrayList<PhanCong> tim_dsPhanCong_(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from dbo.xemDSPhanCong_SV_OR_LuanVan(?,?)");
			st.setNString(1, txt);
			st.setNString(2, txt);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maPDK = rs.getInt(2);
				java.sql.Date ngayPC = rs.getDate(3);
				java.sql.Date ngayBC = rs.getDate(4);
				PhanCong pc = new PhanCong(new PhieuDangKy(maPDK), new HoiDong(maHD), ngayPC, ngayBC);
				dsPhanCong.add(pc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhanCong;
	}

	public ArrayList<PhanCong> dsPhanCong_SinhVien_LoaiHoiDong(int maPDK_tim, int maLHD_tim) throws SQLException {
		dsPhanCong = new ArrayList<PhanCong>();
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement(
					"select * from PhanCong pc join PhieuDangKy pdk on pc.maPDK = pdk.maPDK join HoiDong hd on hd.maHD = pc.maHD where pdk.maPDK = ? and maLHD = ?");
			st.setInt(1, maPDK_tim);
			st.setInt(2, maLHD_tim);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maHD = rs.getInt(1);
				int maPDK = rs.getInt(2);
				java.sql.Date ngayPC = rs.getDate(3);
				java.sql.Date ngayBC = rs.getDate(4);
				PhanCong pc = new PhanCong(new PhieuDangKy(maPDK), new HoiDong(maHD), ngayPC, ngayBC);
				dsPhanCong.add(pc);
			}
		return dsPhanCong;
	}

	public int demPhanCong_LoaiHoiDong_PhieuDangKy(PhieuDangKy pdk, HoiDong hd) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select dbo.demHoiDong_PhieuDangKy(?,?)");
			st.setInt(1, pdk.getMaPDK());
			st.setInt(2, hd.getLoaiHoiDong().getMaLHD());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int soLanPC = rs.getInt(1);
				return soLanPC;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void themPhanCong(PhanCong pc) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into PhanCong" + " values(" + pc.getHoiDong().getMaHD() + ","
				+ pc.getPhieuDangKy().getMaPDK() + ",'" + pc.getNgayPhanCong() + "','" + pc.getNgayBaoCao() + "')");

	}

	public boolean delete(int maPDK,int maHD) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from PhanCong where maPDK = ? and maHD = ?");
		stmt.setInt(1, maPDK);
		stmt.setInt(2, maHD);
		n = stmt.executeUpdate();
		return n > 0;
	}

}
