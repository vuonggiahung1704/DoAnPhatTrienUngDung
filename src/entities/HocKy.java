package entities;

public class HocKy {
	private int maHK;
	private String tenHK;
	public HocKy(int maHK, String tenHK) {
		super();
		this.maHK = maHK;
		this.tenHK = tenHK;
	}
	
	public HocKy(String tenHK, int hocKyHienTai) {
		super();
		this.tenHK = tenHK;
	}

	public HocKy(int maHK) {
		super();
		this.maHK = maHK;
	}
	public int getMaHK() {
		return maHK;
	}
	public void setMaHK(int maHK) {
		this.maHK = maHK;
	}
	public String getTenHK() {
		return tenHK;
	}
	public void setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}
	@Override
	public String toString() {
		return tenHK;
	}
	
	
}
