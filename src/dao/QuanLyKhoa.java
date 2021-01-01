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
import entities.TaiKhoan;

public class QuanLyKhoa {
	private ArrayList<Khoa> dsKhoa;

	public QuanLyKhoa() {
		dsKhoa = new ArrayList<>();
	}

	public ArrayList<Khoa> getDS() {
		return dsKhoa;
	}

	public int getMakhoa() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select top 1 maKhoa from Khoa order by maKhoa desc";
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
	
	public ArrayList<Khoa> dsKhoa() {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			String sql = "select * from Khoa";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int maKhoa = rs.getInt(1);
				String tenKhoa = rs.getNString(2);
				String website = rs.getString(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				Khoa khoa = new Khoa(maKhoa, tenKhoa, website, sdt, email);
				dsKhoa.add(khoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhoa;
	}

	public void themKhoa(Khoa khoa) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("insert into Khoa (tenKhoa,website,sdt,email)" 
			+ " values(N'"+khoa.getTenKhoa()+"','"+khoa.getWebsite()+"','"+khoa.getSdt()
			+"','"+khoa.getemail()+"')");
		} catch (SQLException e) {
			// e.printStackTrace();
		}

	}

	public Khoa chiTietKhoa(int makhoa_tim) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from Khoa where maKhoa = ?");
			st.setInt(1, makhoa_tim);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maKhoa = rs.getInt(1);
				String tenKhoa = rs.getNString(2);
				String website = rs.getString(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				Khoa khoa = new Khoa(maKhoa, tenKhoa, website, sdt, email);				
				return khoa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean capNhatKhoa(Khoa khoa)
	{
		Database.getInstance();
		Connection con= Database.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update Khoa set tenKhoa = ?, website = ?, sdt = ?, email = ? where maKhoa = ? ");
			stmt.setNString(1, khoa.getTenKhoa());
			stmt.setString(2, khoa.getWebsite());
			stmt.setString(3, khoa.getSdt());
			stmt.setString(4, khoa.getemail());
			stmt.setInt(5, khoa.getMaKhoa());
			n= stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean delete(int makhoa) throws SQLException {
		Connection con = database.Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		stmt = con.prepareStatement("delete from Khoa where maKhoa = ?");
		stmt.setInt(1, makhoa);
		n = stmt.executeUpdate();
		return n > 0;
	}

	
	public ArrayList<Khoa> tim_Khoa(String text) {
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			PreparedStatement st = con.prepareStatement("select * from Khoa where makhoa like ? or tenKhoa like ?");
			st.setString(1, "%" + text + "%");
			st.setNString(2, "%" + text + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maKhoa = rs.getInt(1);
				String tenKhoa = rs.getNString(2);
				String website = rs.getString(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				Khoa khoa = new Khoa(maKhoa, tenKhoa, website, sdt, email);
				dsKhoa.add(khoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhoa;
	}
	
}
