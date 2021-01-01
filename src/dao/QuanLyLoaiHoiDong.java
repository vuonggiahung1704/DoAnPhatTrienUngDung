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
import entities.LoaiHoiDong;
import entities.LoaiHoiDong;

public class QuanLyLoaiHoiDong {
	private ArrayList<LoaiHoiDong> dsLoaiHoiDong;

	public QuanLyLoaiHoiDong() {
		dsLoaiHoiDong = new ArrayList<>();
	}

	public ArrayList<LoaiHoiDong> getDS() {
		return dsLoaiHoiDong;
	}

	public ArrayList<LoaiHoiDong> dsLoaiHoiDong() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from LoaiHoiDong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maLHD = rs.getInt(1);
				String tenLHD = rs.getString(2);
				LoaiHoiDong lhd = new LoaiHoiDong(maLHD, tenLHD);
				dsLoaiHoiDong.add(lhd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLoaiHoiDong;
	}

	public LoaiHoiDong chiTietLoaiHoiDong(int malhd_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from LoaiHoiDong where maLHD = ?");
			st.setInt(1, malhd_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maLHD = rs.getInt(1);
				String tenLHD = rs.getString(2);
				LoaiHoiDong lhd = new LoaiHoiDong(maLHD, tenLHD);
				return lhd;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
