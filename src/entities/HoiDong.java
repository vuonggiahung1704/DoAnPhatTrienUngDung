package entities;

import java.sql.Date;

public class HoiDong {
	private int maHD;
	private LoaiHoiDong loaiHoiDong;
	private Date ngayLap;
	public HoiDong(int maHD, LoaiHoiDong loaiHoiDong, Date ngayLap) {
		super();
		this.maHD = maHD;
		this.loaiHoiDong = loaiHoiDong;
		this.ngayLap = ngayLap;
	}
	
	public HoiDong(LoaiHoiDong loaiHoiDong, Date ngayLap) {
		super();
		this.loaiHoiDong = loaiHoiDong;
		this.ngayLap = ngayLap;
	}

	public HoiDong(int maHD) {
		super();
		this.maHD = maHD;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public LoaiHoiDong getLoaiHoiDong() {
		return loaiHoiDong;
	}
	public void setLoaiHoiDong(LoaiHoiDong loaiHoiDong) {
		this.loaiHoiDong = loaiHoiDong;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	@Override
	public String toString() {
		return "HoiDong : " + maHD ;
	}
	
}
