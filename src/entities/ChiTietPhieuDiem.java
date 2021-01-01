package entities;

public class ChiTietPhieuDiem {
	private PhieuDiem phieuDiem;
	private ChiTietHoiDong chiTietHoiDong;
	private float diem;
	public ChiTietPhieuDiem(PhieuDiem phieuDiem, ChiTietHoiDong chiTietHoiDong, float diem) {
		super();
		this.phieuDiem = phieuDiem;
		this.chiTietHoiDong = chiTietHoiDong;
		this.diem = diem;
	}
	public ChiTietPhieuDiem(PhieuDiem phieuDiem, ChiTietHoiDong chiTietHoiDong) {
		super();
		this.phieuDiem = phieuDiem;
		this.chiTietHoiDong = chiTietHoiDong;
	}
	public PhieuDiem getPhieuDiem() {
		return phieuDiem;
	}
	public void setPhieuDiem(PhieuDiem phieuDiem) {
		this.phieuDiem = phieuDiem;
	}
	public ChiTietHoiDong getChiTietHoiDong() {
		return chiTietHoiDong;
	}
	public void setChiTietHoiDong(ChiTietHoiDong chiTietHoiDong) {
		this.chiTietHoiDong = chiTietHoiDong;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
}
