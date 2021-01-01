package entities;

import java.sql.Date;

public class SinhVien {
	private String maSV;
	private String hoTen;
	private int gioitinh;
	private TaiKhoan taiKhoan;
	private Khoa khoa;
	private Date ngaySinh;
	private String queQuan;
	
	public SinhVien(String maSV, String hoTen, int gioitinh, TaiKhoan taiKhoan, Khoa khoa, Date ngaySinh,
			String queQuan) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioitinh = gioitinh;
		this.taiKhoan = taiKhoan;
		this.khoa = khoa;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
	}

	public SinhVien(String maSV) {
		super();
		this.maSV = maSV;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}
	
}
