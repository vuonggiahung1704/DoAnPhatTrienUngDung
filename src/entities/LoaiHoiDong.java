package entities;

public class LoaiHoiDong {
	private int maLHD;
	private String tenLHD;
	public LoaiHoiDong(int maLHD, String tenLHD) {
		super();
		this.maLHD = maLHD;
		this.tenLHD = tenLHD;
	}
	public LoaiHoiDong(int maLHD) {
		super();
		this.maLHD = maLHD;
	}
	public int getMaLHD() {
		return maLHD;
	}
	public void setMaLHD(int maLHD) {
		this.maLHD = maLHD;
	}
	public String getTenLHD() {
		return tenLHD;
	}
	public void setTenLHD(String tenLHD) {
		this.tenLHD = tenLHD;
	}
	@Override
	public String toString() {
		return tenLHD;
	}
	
	
}
