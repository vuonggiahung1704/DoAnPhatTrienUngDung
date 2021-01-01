package entities;

public class LuanVan {
	private int maLV;
	private String tenLV;
	private GiangVien giangVien;
	private Khoa khoa;
	private HocKy hocKy;
	private int soLuongDk;
	
	public LuanVan(int maLV, String tenLV, GiangVien giangVien, Khoa khoa, int soLuongDk,HocKy hocKy) {
		super();
		this.maLV = maLV;
		this.tenLV = tenLV;
		this.giangVien = giangVien;
		this.khoa = khoa;
		this.soLuongDk = soLuongDk;
		this.hocKy = hocKy;
	}
	public LuanVan(int maLV) {
		super();
		this.maLV = maLV;
	}
	public int getMaLV() {
		return maLV;
	}
	public void setMaLV(int maLV) {
		this.maLV = maLV;
	}
	public String getTenLV() {
		return tenLV;
	}
	public void setTenLV(String tenLV) {
		this.tenLV = tenLV;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	public int getSoLuongDk() {
		return soLuongDk;
	}
	public void setSoLuongDk(int soLuongDk) {
		this.soLuongDk = soLuongDk;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	@Override
	public String toString() {
		return "LuanVan [maLV=" + maLV + ", tenLV=" + tenLV + ", giangVien=" + giangVien + ", khoa=" + khoa + ", hocKy="
				+ hocKy.toString() + ", soLuongDk=" + soLuongDk + "]";
	}
	
	
}
