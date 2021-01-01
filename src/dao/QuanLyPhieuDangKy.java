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
import entities.Khoa;
import entities.LuanVan;
import entities.PhieuDangKy;
import entities.SinhVien;

public class QuanLyPhieuDangKy {
	private ArrayList<PhieuDangKy> dsPhieuDangKy;

	public QuanLyPhieuDangKy() {
		dsPhieuDangKy = new ArrayList<>();
	}

	public ArrayList<PhieuDangKy> getDS() {
		return dsPhieuDangKy;
	}

	public int demSoDK_LuanVan(LuanVan lv) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select count(maLV) from PhieuDangKy where maLV = ?");
		st.setInt(1, lv.getMaLV());
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}

	public int DangKyTrongHocKy(HocKy hk,String maSV) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select count(pdk.maLV) from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV where maHK = ? and maSV = ?");
		st.setInt(1, hk.getMaHK());
		st.setString(2, maSV);
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}

	public ArrayList<PhieuDangKy> dsPhieuDangKy() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from PhieuDangKy";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				dsPhieuDangKy.add(pdk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDangKy;
	}

	public ArrayList<PhieuDangKy> dsPhieuDangKy_HocKyHienTai(int maHK_HT) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDangKy where maHK = ?");
			st.setInt(1, maHK_HT);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				dsPhieuDangKy.add(pdk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDangKy;
	}
	
	public ArrayList<PhieuDangKy> dsPhieuDangKy_HocKy_Khoa(int maHK_HT,int maKhoa) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select pdk.* from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV where maHK = ? and maKhoa = ?");
			st.setInt(1, maHK_HT);
			st.setInt(2, maKhoa);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				dsPhieuDangKy.add(pdk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDangKy;
	}
	
	public ArrayList<PhieuDangKy> tim_dsPhieuDangKy_Txt(String txt) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select pdk.* from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV join SinhVien sv on sv.maSV = pdk.maSV where sv.hoTen like ? or lv.tenLV like ?");
			st.setNString(1, "%"+txt+"%");
			st.setNString(2, "%"+txt+"%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				dsPhieuDangKy.add(pdk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhieuDangKy;
	}

	public void themPhieuDangKy(PhieuDangKy pdk) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into PhieuDangKy(maLV,maSV)" + " values(" + pdk.getLuanVan().getMaLV() + ",'"
					+ pdk.getSinhVien().getMaSV() + "')");
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public PhieuDangKy chiTietPhieuDangKy(int mapdk_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from PhieuDangKy where maPDK = ?");
			st.setInt(1, mapdk_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				return pdk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PhieuDangKy chiTietPhieuDangKy_SinhVien_TrongHocKy(String maSV_tim,int maHK_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select pdk.* from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV where maSV = ? and lv.maHK = ?");
			st.setString(1, maSV_tim);
			st.setInt(2, maHK_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPDK = rs.getInt(1);
				int maLV = rs.getInt(2);
				String maSV = rs.getString(3);
				float diemTB1 = rs.getFloat(4);
				float diemTB2 = rs.getFloat(5);
				int ketQua = rs.getInt(6);
				PhieuDangKy pdk = new PhieuDangKy(maPDK, new SinhVien(maSV), new LuanVan(maLV),
						diemTB1, diemTB2, ketQua);
				return pdk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean capNhatPhieuDangKy(PhieuDangKy pdk) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update PhieuDangKy set diemTBvong1 = ?, diemTBvong1 = ?, ketQua = ? where maPDK = ? ");
			stmt.setFloat(1, pdk.getDiemTBVong1());
			stmt.setFloat(2, pdk.getDiemTBVong2());
			stmt.setInt(3, pdk.getKetQua());
			stmt.setInt(4, pdk.getMaPDK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatDiemThamDinh(PhieuDangKy pdk) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update PhieuDangKy set diemTBvong1 = ? where maPDK = ? ");
			stmt.setFloat(1, pdk.getDiemTBVong1());
			stmt.setInt(2, pdk.getMaPDK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatDiemBaoCao(PhieuDangKy pdk) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update PhieuDangKy set diemTBvong2 = ? where maPDK = ? ");
			stmt.setFloat(1, pdk.getDiemTBVong2());
			stmt.setInt(2, pdk.getMaPDK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatKetQua(PhieuDangKy pdk) {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update PhieuDangKy set ketQua = ? where maPDK = ? ");
			stmt.setInt(1, pdk.getKetQua());
			stmt.setInt(2, pdk.getMaPDK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int maPDK) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from PhieuDangKy where maPDK = ?");
		stmt.setInt(1, maPDK);
		n = stmt.executeUpdate();
		return n > 0;
	}

	public int soLuongDangKy_TrongHK_Khoa(HocKy hk,Khoa k) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.soLuongDangKy_TrongHK_Khoa(?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}
	
	public int soLuongLV_TrongHK_Khoa(HocKy hk,Khoa k) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.soLuongLV_TrongHK_Khoa(?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}
	
	public int soLuongLV_Dat_TrongHK_Khoa(HocKy hk,Khoa k) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.soLuongLV_Dat_TrongHK_Khoa(?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}

	public int soLuongLV_KhongDat_TrongHK_Khoa(HocKy hk,Khoa k) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.soLuongLV_KhongDat_TrongHK_Khoa(?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}
	
	public int soLuongDiem(HocKy hk,Khoa k,float tu,float den) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.soLuongDiem(?,?,?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		st.setFloat(3, tu);
		st.setFloat(4, den);
		ResultSet rs = st.executeQuery();
		int soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}
	
	public float diemTB_TrongHK_Khoa(HocKy hk,Khoa k) throws SQLException {
		Database.getInstance();
		Connection con = Database.getConnection();
		PreparedStatement st = con.prepareStatement("select dbo.diemTB_TrongHK_Khoa(?,?)");
		st.setInt(1, hk.getMaHK());
		st.setInt(2, k.getMaKhoa());
		ResultSet rs = st.executeQuery();
		float soLuong = 0;
		while (rs.next()) {
			soLuong = rs.getInt(1);
		}
		return soLuong;
	}
	
	public int demDat_KhongDat_LuanVan(int maLV,int ketQua){
		Database.getInstance();
		Connection con = Database.getConnection();
		int soLuong;
		try {
			PreparedStatement st = con.prepareStatement("select count(maPDK) from PhieuDangKy where maLV = ? and ketQua = ?");
			st.setInt(1, maLV);
			st.setInt(2, ketQua);
			ResultSet rs = st.executeQuery();
			soLuong = 0;
			while (rs.next()) {
				soLuong = rs.getInt(1);
			}
		} catch (SQLException e) {
			soLuong = 0;
		}
		return soLuong;
	}
	
}
