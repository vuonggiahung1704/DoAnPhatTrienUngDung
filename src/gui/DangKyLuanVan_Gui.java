/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.QuanLyGiangVien;
import dao.QuanLyHocKy;
import dao.QuanLyKhoa;
import dao.QuanLyLuanVan;
import dao.QuanLyPhieuDangKy;
import dao.QuanLySinhVien;
import database.Database;
import entities.GiangVien;
import entities.HocKy;
import entities.Khoa;
import entities.LuanVan;
import entities.PhieuDangKy;
import entities.SinhVien;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author nmrhu
 */
public class DangKyLuanVan_Gui extends javax.swing.JPanel {

	/**
	 * Creates new form QuanLyTaiKhoan_Gu
	 */
	public DangKyLuanVan_Gui() {
		setSize(new Dimension(1500, 700));
		initComponents();

		DocDuLieuDatabaseVaoCombobox();
		clear();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		Database.getInstance().connect();
		qlkhoa = new QuanLyKhoa();
		qlgv = new QuanLyGiangVien();
		qlhk = new QuanLyHocKy();
		qllv = new QuanLyLuanVan();
		qlpdk = new QuanLyPhieuDangKy();
		qlsv = new QuanLySinhVien();

		jPanel3 = new javax.swing.JPanel();
		jPanel3.setBackground(Color.WHITE);
		jLabel1 = new javax.swing.JLabel();
		btnDangKy = new javax.swing.JButton();
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangLyLuanVan(lv);
			}
		});
		btnThongTin = new javax.swing.JButton();
		btnThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.xemThongTinLV();
			}
		});
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		txtTim = new javax.swing.JTextField();
		btnTim = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));

		jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(0, 153, 255));
		jLabel1.setText("Xử lý  / Đăng ký luận văn");

		btnDangKy.setBackground(new java.awt.Color(255, 255, 255));
		btnDangKy.setIcon(new javax.swing.ImageIcon("image/check_30px.png")); // NOI18N
		btnDangKy.setText("Đăng ký");

		btnThongTin.setBackground(new java.awt.Color(255, 255, 255));
		btnThongTin.setIcon(new javax.swing.ImageIcon("image/view_30px.png")); // NOI18N
		btnThongTin.setText("Thông tin");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 817, Short.MAX_VALUE).addComponent(btnDangKy)
						.addGap(18).addComponent(btnThongTin).addGap(14)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(btnDangKy)
										.addComponent(btnThongTin))
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

		dm = new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã luận văn", "Tên luận văn", "Giảng viên hướng dẫn", "Sỉ số tối đa", "Đã đăng ký" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};
		jTable1.setModel(dm);
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = jTable1.getSelectedRow();
				TableModel model = jTable1.getModel();
				String maLV = model.getValueAt(row, 0).toString();
				lv = qllv.chiTietLuanVan(Integer.parseInt(maLV));

				btnDangKy.setEnabled(true);
			}
		});
		jTable1.setGridColor(new java.awt.Color(255, 255, 255));
		jTable1.setRowHeight(40);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
		jScrollPane1.setViewportView(jTable1);

		btnTim.setBackground(new java.awt.Color(255, 255, 255));
		btnTim.setIcon(new javax.swing.ImageIcon("image/search_30px.png")); // NOI18N
		btnTim.setText("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtTim.getText();
				hocKy = (HocKy) cbbHK.getSelectedItem();
				DocDuLieuDatabaseVaoTable(txt, sv.getKhoa(), hocKy);
			}
		});

		cbbHK = new JComboBox<HocKy>();
		DefaultComboBoxModel<HocKy> dmHK = new DefaultComboBoxModel<HocKy>();
		cbbHK.setModel(dmHK);
		cbbHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hocKy = (HocKy) cbbHK.getSelectedItem();
			}
		});

		JButton btnLoc = new JButton();
		btnLoc.setBackground(Color.WHITE);
		btnLoc.setIcon(new ImageIcon("image/Mail Filter_30px.png"));
		btnLoc.setText("Lọc");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hocKy = (HocKy) cbbHK.getSelectedItem();
				DocDuLieuDatabaseVaoTable("", sv.getKhoa(), hocKy);
				txtTim.setText("");
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel4Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
								.addComponent(cbbHK, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim)
								.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbHK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE).addContainerGap()));
		jPanel4.setLayout(jPanel4Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jPanel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1198,
										Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE).addContainerGap()));
		this.setLayout(layout);
	}

	public static void XoaHetDuLieuTrenCombobox() {
		DefaultComboBoxModel<HocKy> dm = (DefaultComboBoxModel<HocKy>) cbbHK.getModel();
		dm.removeAllElements();
	}

	public static void DocDuLieuDatabaseVaoCombobox() {
		XoaHetDuLieuTrenCombobox();
		List<HocKy> list = new ArrayList<HocKy>();
		qlhk = new QuanLyHocKy();
		list = qlhk.dsHocKy();

		DefaultComboBoxModel<HocKy> dm = (DefaultComboBoxModel<HocKy>) cbbHK.getModel();
		for (HocKy hk : list) {
			dm.addElement(hk);
		}
	}

	public static void DocDuLieuDatabaseVaoTable(String txt, Khoa k, HocKy hk) {
		dm = (DefaultTableModel) jTable1.getModel();
		dm.setRowCount(0);
		List<LuanVan> list = new ArrayList<LuanVan>();
		qllv = new QuanLyLuanVan();

		if (txt.equals(""))
			list = qllv.tim_LuanVanTheoKhoa(k.getMaKhoa(), hk.getMaHK());
		else {
			list = qllv.tim_LuanVan_Trong_Khoa(txt, k.getMaKhoa());
		}

		for (LuanVan lv : list) {
			Khoa khoa = qlkhoa.chiTietKhoa(lv.getKhoa().getMaKhoa());
			GiangVien gv = qlgv.chiTietGiangVien(lv.getGiangVien().getMaGV());
			int daDangKy;
			try {
				daDangKy = qlpdk.demSoDK_LuanVan(lv);
			} catch (SQLException e) {
				daDangKy = 0;
			}
			dm.addRow(new Object[] { lv.getMaLV(), lv.getTenLV(), gv.getHoTen(), lv.getSoLuongDk(), daDangKy });
		}
	}

	public int kiemTraSoLuongDangKyLuanVan(LuanVan lv) {
		int soLuong = 0;
		hocKy = (HocKy) cbbHK.getSelectedItem();
		try {
			soLuong = qlpdk.demSoDK_LuanVan(lv);
		} catch (SQLException e) {
			soLuong = 0;
		}
		return soLuong;
	}

	public static boolean kiemTraDangKyTrongHocKy() {
		int soLuong = 0;
		try {
			soLuong = qlpdk.DangKyTrongHocKy(hocKy, sv.getMaSV());
		} catch (SQLException e) {
			soLuong = 0;
		}
		if (soLuong >= 1)
			return false;
		else
			return true;
	}

	public void dangLyLuanVan(LuanVan lv) {
		if (kiemTraDangKyTrongHocKy()) {
			int soLuong = kiemTraSoLuongDangKyLuanVan(lv);
			if (soLuong >= lv.getSoLuongDk()) {
				JOptionPane.showMessageDialog(this, "Luận văn đã đủ số lượng đăng ký");
			} else {
				PhieuDangKy pdk = new PhieuDangKy(sv, lv);
				qlpdk.themPhieuDangKy(pdk);
				JOptionPane.showMessageDialog(this, "Đăng ký luận văn  " + lv.getTenLV() + " thành công");
				DocDuLieuDatabaseVaoTable("", sv.getKhoa(), hocKy);
			}
		} else {
			JOptionPane.showMessageDialog(main, "Sinh viên đã đăng ký đề tài luận văn trong học kỳ này");
		}
	}

	public static void setSinhVien(SinhVien sv_sql) {
		sv = sv_sql;
		DocDuLieuDatabaseVaoTable("", sv.getKhoa(), hocKy);
	}

	public void clear() {
		btnDangKy.setEnabled(false);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTim;
	private javax.swing.JButton btnDangKy;
	private javax.swing.JButton btnThongTin;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private static javax.swing.JTable jTable1;
	private static JComboBox<HocKy> cbbHK;
	private javax.swing.JTextField txtTim;
	private static javax.swing.table.DefaultTableModel dm;

	private static QuanLyLuanVan qllv;
	private static QuanLyKhoa qlkhoa;
	private static QuanLySinhVien qlsv;
	private static QuanLyGiangVien qlgv;
	private static QuanLyHocKy qlhk;
	private static QuanLyPhieuDangKy qlpdk;

	public static SinhVien sv;
	public static HocKy hocKy;
	private LuanVan lv;

	public static Main main;
}
