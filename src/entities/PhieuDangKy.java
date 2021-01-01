package entities;

public class PhieuDangKy {
	private int maPDK;
	private SinhVien sinhVien;
	private LuanVan luanVan;
	private float diemTBVong1;
	private float diemTBVong2;
	private int ketQua;
	
	public PhieuDangKy(SinhVien sinhVien, LuanVan luanVan) {
		super();
		this.sinhVien = sinhVien;
		this.luanVan = luanVan;
	}
	public PhieuDangKy(int maPDK, SinhVien sinhVien, LuanVan luanVan,float diemTBVong1, float diemTBVong2,
			int ketQua) {
		super();
		this.maPDK = maPDK;
		this.sinhVien = sinhVien;
		this.luanVan = luanVan;
		this.diemTBVong1 = diemTBVong1;
		this.diemTBVong2 = diemTBVong2;
		this.ketQua = ketQua;
	}
	public PhieuDangKy(int maPDK) {
		super();
		this.maPDK = maPDK;
	}
	public int getMaPDK() {
		return maPDK;
	}
	public void setMaPDK(int maPDK) {
		this.maPDK = maPDK;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public LuanVan getLuanVan() {
		return luanVan;
	}
	public void setLuanVan(LuanVan luanVan) {
		this.luanVan = luanVan;
	}
	public float getDiemTBVong1() {
		return diemTBVong1;
	}
	public void setDiemTBVong1(float diemTBVong1) {
		this.diemTBVong1 = diemTBVong1;
	}
	public float getDiemTBVong2() {
		return diemTBVong2;
	}
	public void setDiemTBVong2(float diemTBVong2) {
		this.diemTBVong2 = diemTBVong2;
	}
	public int getKetQua() {
		return ketQua;
	}
	public void setKetQua(int ketQua) {
		this.ketQua = ketQua;
	}
}
