package entities;

public class GiangVien {
	private String maGV;
	private String hoTen;
	private int gioiTinh;
	private String sdt;
	private String email;
	private Khoa khoa;
	public GiangVien(String maGV, String hoTen, int gioiTinh, String sdt, String email, Khoa khoa) {
		super();
		this.maGV = maGV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.khoa = khoa;
	}
	public GiangVien(String maGV) {
		super();
		this.maGV = maGV;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return  hoTen;
	}	
}
