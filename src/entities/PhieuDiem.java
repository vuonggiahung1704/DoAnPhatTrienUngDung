package entities;

import java.sql.Date;

public class PhieuDiem {
	private int maPD;
	private PhanCong phanCong;
	private float diemTrungBinh;
	
	public PhieuDiem(PhanCong phanCong) {
		super();
		this.phanCong = phanCong;
	}
	public PhieuDiem(int maPD, PhanCong phanCong, float diemTrungBinh) {
		super();
		this.maPD = maPD;
		this.phanCong = phanCong;
		this.diemTrungBinh = diemTrungBinh;
	}
	public PhieuDiem(int maPD) {
		super();
		this.maPD = maPD;
	}
	public int getMaPD() {
		return maPD;
	}
	public void setMaPD(int maPD) {
		this.maPD = maPD;
	}
	public PhanCong getPhanCong() {
		return phanCong;
	}
	public void setPhanCong(PhanCong phanCong) {
		this.phanCong = phanCong;
	}
	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}	
}
