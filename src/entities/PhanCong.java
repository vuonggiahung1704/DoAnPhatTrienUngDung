package entities;

import java.sql.Date;

public class PhanCong {
	private PhieuDangKy phieuDangKy;
	private HoiDong hoiDong;
	private Date ngayPhanCong;
	private Date ngayBaoCao;
	public PhanCong(PhieuDangKy phieuDangKy, HoiDong hoiDong) {
		super();
		this.phieuDangKy = phieuDangKy;
		this.hoiDong = hoiDong;
	}
	public PhanCong(PhieuDangKy phieuDangKy, HoiDong hoiDong, Date ngayPhanCong, Date ngayBaoCao) {
		super();
		this.phieuDangKy = phieuDangKy;
		this.hoiDong = hoiDong;
		this.ngayPhanCong = ngayPhanCong;
		this.ngayBaoCao = ngayBaoCao;
	}
	public PhieuDangKy getPhieuDangKy() {
		return phieuDangKy;
	}
	public void setPhieuDangKy(PhieuDangKy phieuDangKy) {
		this.phieuDangKy = phieuDangKy;
	}
	public HoiDong getHoiDong() {
		return hoiDong;
	}
	public void setHoiDong(HoiDong hoiDong) {
		this.hoiDong = hoiDong;
	}
	public Date getNgayPhanCong() {
		return ngayPhanCong;
	}
	public void setNgayPhanCong(Date ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}
	public Date getNgayBaoCao() {
		return ngayBaoCao;
	}
	public void setNgayBaoCao(Date ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}
	@Override
	public String toString() {
		return hoiDong.toString();
	}
	
	
}
