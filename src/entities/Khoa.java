package entities;

public class Khoa {
	private int maKhoa;
	private String tenKhoa;
	private String website;
	private String sdt;
	private String email;
	public Khoa(int maKhoa, String tenKhoa, String website, String sdt, String email) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.website = website;
		this.sdt = sdt;
		this.email = email;
	}
	public Khoa(int maKhoa) {
		super();
		this.maKhoa = maKhoa;
	}
	public int getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return tenKhoa;
	}
	
	
}
