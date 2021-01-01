package entities;

public class TaiKhoan {
	private String tenTk;
	private String matKhau;
	private int quyen;
	public TaiKhoan(String tenTk, String matKhau, int quyen) {
		super();
		this.tenTk = tenTk;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	public TaiKhoan(String tenTk) {
		super();
		this.tenTk = tenTk;
	}
	public TaiKhoan(String tenTk, String matKhau) {
		super();
		this.tenTk = tenTk;
		this.matKhau = matKhau;
	}
	public String getTenTk() {
		return tenTk;
	}
	public void setTenTk(String tenTk) {
		this.tenTk = tenTk;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
	
}
