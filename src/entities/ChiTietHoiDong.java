package entities;

public class ChiTietHoiDong {
	private HoiDong hoiDong;
	private GiangVien giangVien;
	
	public ChiTietHoiDong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	public ChiTietHoiDong(HoiDong hoiDong, GiangVien giangVien) {
		super();
		this.hoiDong = hoiDong;
		this.giangVien = giangVien;
	}
	public HoiDong getHoiDong() {
		return hoiDong;
	}
	public void setHoiDong(HoiDong hoiDong) {
		this.hoiDong = hoiDong;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	
	
}
