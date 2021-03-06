/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatter;

import dao.QuanLyChiTietHoiDong;
import dao.QuanLyChiTietPhieuDiem;
import dao.QuanLyGiangVien;
import dao.QuanLyHocKy;
import dao.QuanLyHoiDong;
import dao.QuanLyKhoa;
import dao.QuanLyLoaiHoiDong;
import dao.QuanLyLuanVan;
import dao.QuanLyPhanCong;
import dao.QuanLyPhieuDangKy;
import dao.QuanLyPhieuDiem;
import dao.QuanLySinhVien;
import database.Database;
import entities.ChiTietHoiDong;
import entities.ChiTietPhieuDiem;
import entities.GiangVien;
import entities.HocKy;
import entities.HoiDong;
import entities.Khoa;
import entities.LoaiHoiDong;
import entities.LuanVan;
import entities.PhanCong;
import entities.PhieuDangKy;
import entities.PhieuDiem;
import entities.SinhVien;

import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 *
 * @author nmrhu
 */
public class NhapDiem_Gui extends javax.swing.JPanel {

	/**
	 * Creates new form QuanLyTaiKhoan_Gu
	 */
	public NhapDiem_Gui() {
		setSize(new Dimension(1500, 700));
		initComponents();

		DocDuLieuDatabaseVaoComboboxHocKy();
		DocDuLieuDatabaseVaoComboboxKhoa();
		DocDuLieuDatabaseVaoComboboxLHD();
		DocDuLieuDatabaseVaoTable("", 0, khoa, hk, lhd);
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
		qlhd = new QuanLyHoiDong();
		qllhd = new QuanLyLoaiHoiDong();
		qllv = new QuanLyLuanVan();
		qlsv = new QuanLySinhVien();
		qlpdk = new QuanLyPhieuDangKy();
		qlhk = new QuanLyHocKy();
		qlkhoa = new QuanLyKhoa();
		qlpc = new QuanLyPhanCong();
		qlcthd = new QuanLyChiTietHoiDong();
		qlgv = new QuanLyGiangVien();
		qlpd = new QuanLyPhieuDiem();
		qlctpd = new QuanLyChiTietPhieuDiem();

		jPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jPanel3.setBackground(Color.WHITE);
		jLabel1 = new javax.swing.JLabel();
		btnHuyPhanCong = new javax.swing.JButton();
		btnHuyPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = jTable1.getSelectedRow();
				TableModel model = jTable1.getModel();
				int maHD = Integer.parseInt(model.getValueAt(row, 0).toString());
				int maPDK = Integer.parseInt(model.getValueAt(row, 2).toString());
				huyPhanCong(maPDK, maHD);
			}
		});
		jPanel4 = new javax.swing.JPanel();
		txtTim = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		btnTim = new javax.swing.JButton();
		cbbKhoa = new javax.swing.JComboBox<>();
		btnLoc = new javax.swing.JButton();
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DocDuLieuDatabaseVaoTable("", 0, khoa, hk, lhd);
				txtTim.setText("");
			}
		});
		jPanel5 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		btnLuu = new javax.swing.JButton();
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luuDiem();
			}
		});
		btnLuu.setEnabled(false);
		cbbHK = new javax.swing.JComboBox<>();

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hội đồng"));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addContainerGap(22, Short.MAX_VALUE)));

		setBackground(new java.awt.Color(255, 255, 255));

		jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(0, 153, 255));
		jLabel1.setText("Xử lý / Nhập điểm");

		btnHuyPhanCong.setBackground(new java.awt.Color(255, 255, 255));
		btnHuyPhanCong.setIcon(new javax.swing.ImageIcon("image/delete_30px.png")); // NOI18N
		btnHuyPhanCong.setText("Hủy phân công");
		btnHuyPhanCong.setEnabled(false);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHuyPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnHuyPhanCong).addComponent(jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

		dm = new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã hội đồng", "Loại hội đồng", "Mã phiếu đăng ký", "Sinh viên", "Tên luận văn", "Ngày báo cáo" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

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
				int maHD = Integer.parseInt(model.getValueAt(row, 0).toString());
				String LHD = (String) model.getValueAt(row, 1);
				int maPDK = Integer.parseInt(model.getValueAt(row, 2).toString());
				String tenSV = (String) model.getValueAt(row, 3);
				String tenLV = (String) model.getValueAt(row, 4);
				Date ngayBC = (Date) model.getValueAt(row, 5);
				DocDuLieuDatabaseVao2Table(maHD, maPDK);
				
				txtSinhVien.setText(tenSV);
				txtHoiDong.setText(LHD);
				txtLuanVan.setText(tenLV);
				txtNgayBaoCao.setText("" + ngayBC);
				
				btnLuu.setEnabled(false);
				btnHuyPhanCong.setEnabled(true);
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
				DocDuLieuDatabaseVaoTable(txt, 1, khoa, hk, lhd);
			}
		});

		DefaultComboBoxModel<Khoa> dmKhoa = new DefaultComboBoxModel<Khoa>();
		cbbKhoa.setModel(dmKhoa);
		cbbKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoa = (Khoa) cbbKhoa.getSelectedItem();
			}
		});

		btnLoc.setIcon(new javax.swing.ImageIcon("image/Mail Filter_30px.png")); // NOI18N
		btnLoc.setText("Lọc");

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập điểm"));

		dm2 = new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã giảng viên", "Giảng viên", "Điểm" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		jTable2.setModel(dm2);
		jTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnLuu.setEnabled(true);
			}
		});
		jTable2.setGridColor(new java.awt.Color(255, 255, 255));
		jTable2.setRowHeight(28);
		jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable2.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
		jScrollPane3.setViewportView(jTable2);

		btnLuu.setBackground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(new javax.swing.ImageIcon("image/save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");

		lblimTrungBnh = new JLabel("Điểm trung bình:");
		lblimTrungBnh.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtDiemTB = new JTextField();
		txtDiemTB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiemTB.setEditable(false);
		txtDiemTB.setColumns(10);

		lblNewLabel = new JLabel("Sinh viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtSinhVien = new JTextField();
		txtSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSinhVien.setEditable(false);
		txtSinhVien.setColumns(10);

		lblLunVn = new JLabel("Luân văn:");
		lblLunVn.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblHing = new JLabel("Hội đồng");
		lblHing.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblNgyBoCo = new JLabel("Ngày báo cáo:");
		lblNgyBoCo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblNewLabel_4 = new JLabel("");

		txtLuanVan = new JTextField();
		txtLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLuanVan.setEditable(false);
		txtLuanVan.setColumns(10);

		txtHoiDong = new JTextField();
		txtHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoiDong.setEditable(false);
		txtHoiDong.setColumns(10);

		txtNgayBaoCao = new JTextField();
		txtNgayBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayBaoCao.setEditable(false);
		txtNgayBaoCao.setColumns(10);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5Layout.setHorizontalGroup(
			jPanel5Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addComponent(lblimTrungBnh, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDiemTB, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel5Layout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtSinhVien, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(jPanel5Layout.createSequentialGroup()
									.addComponent(lblLunVn, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtLuanVan, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(jPanel5Layout.createSequentialGroup()
									.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHing, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNgyBoCo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtHoiDong, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
										.addComponent(txtNgayBaoCao, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)))
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jPanel5Layout.setVerticalGroup(
			jPanel5Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSinhVien, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLunVn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLuanVan, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHing, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHoiDong, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNgyBoCo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayBaoCao, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4))
						.addGroup(jPanel5Layout.createSequentialGroup()
							.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLuu)
								.addComponent(txtDiemTB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblimTrungBnh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel5.setLayout(jPanel5Layout);

		DefaultComboBoxModel<HocKy> dmHK = new DefaultComboBoxModel<HocKy>();
		cbbHK.setModel(dmHK);
		cbbHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hk = (HocKy) cbbHK.getSelectedItem();
			}
		});

		cbbLHD = new javax.swing.JComboBox<LoaiHoiDong>();
		DefaultComboBoxModel<LoaiHoiDong> dmLHD = new DefaultComboBoxModel<LoaiHoiDong>();
		cbbLHD.setModel(dmLHD);
		cbbLHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhd = (LoaiHoiDong) cbbLHD.getSelectedItem();
			}
		});
		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
						.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
								.addGap(3)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
								.addComponent(cbbLHD, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbbHK, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbbKhoa, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(
						jPanel4Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
										.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtTim, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnTim)
												.addComponent(cbbKhoa, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLoc)
												.addComponent(cbbHK, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbbLHD, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(9)));
		jPanel4.setLayout(jPanel4Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
	}

	public void XoaHetDuLieuTrenComboboxLHD() {
		DefaultComboBoxModel<LoaiHoiDong> dm = (DefaultComboBoxModel<LoaiHoiDong>) cbbLHD.getModel();
		dm.removeAllElements();
	}

	public void DocDuLieuDatabaseVaoComboboxLHD() {
		XoaHetDuLieuTrenComboboxLHD();
		List<LoaiHoiDong> list = new ArrayList<LoaiHoiDong>();
		qllhd = new QuanLyLoaiHoiDong();
		list = qllhd.dsLoaiHoiDong();

		DefaultComboBoxModel<LoaiHoiDong> dm = (DefaultComboBoxModel<LoaiHoiDong>) cbbLHD.getModel();
		for (LoaiHoiDong lhd : list) {
			dm.addElement(lhd);
		}
	}

	public void XoaHetDuLieuTrenComboboxKhoa() {
		DefaultComboBoxModel<Khoa> dm = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
		dm.removeAllElements();
	}

	public void DocDuLieuDatabaseVaoComboboxKhoa() {
		XoaHetDuLieuTrenComboboxKhoa();
		List<Khoa> list = new ArrayList<Khoa>();
		qlkhoa = new QuanLyKhoa();
		list = qlkhoa.dsKhoa();

		DefaultComboBoxModel<Khoa> dm = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
		for (Khoa khoa : list) {
			dm.addElement(khoa);
		}
	}

	public void XoaHetDuLieuTrenComboboxHocKy() {
		DefaultComboBoxModel<HocKy> dm = (DefaultComboBoxModel<HocKy>) cbbHK.getModel();
		dm.removeAllElements();
	}

	public void DocDuLieuDatabaseVaoComboboxHocKy() {
		XoaHetDuLieuTrenComboboxHocKy();
		List<HocKy> list = new ArrayList<HocKy>();
		qlhk = new QuanLyHocKy();
		list = qlhk.dsHocKy();

		DefaultComboBoxModel<HocKy> dm = (DefaultComboBoxModel<HocKy>) cbbHK.getModel();
		for (HocKy hk : list) {
			dm.addElement(hk);
		}
	}

	public void DocDuLieuDatabaseVaoTable(String txt, int tim, Khoa k, HocKy hk, LoaiHoiDong lhd_tim) {
		dm = (DefaultTableModel) jTable1.getModel();
		dm.setRowCount(0);

		List<PhanCong> list = new ArrayList<PhanCong>();
		qlpc = new QuanLyPhanCong();

		if (tim == 1) {
			if (txt.equals(""))
				list = qlpc.dsPhanCong(hk, k, lhd_tim);
			else
				list = qlpc.tim_dsPhanCong_(txt);
		} else {
			list = qlpc.dsPhanCong(hk, k, lhd_tim);
		}
		for (PhanCong pc : list) {
			HoiDong hd = qlhd.chiTietHoiDong(pc.getHoiDong().getMaHD());
			LoaiHoiDong lhd = qllhd.chiTietLoaiHoiDong(hd.getLoaiHoiDong().getMaLHD());
			PhieuDangKy pdk = qlpdk.chiTietPhieuDangKy(pc.getPhieuDangKy().getMaPDK());
			LuanVan lv = qllv.chiTietLuanVan(pdk.getLuanVan().getMaLV());
			SinhVien sv = qlsv.chiTietSinhVien(pdk.getSinhVien().getMaSV());
			dm.addRow(new Object[] { hd.getMaHD(), lhd.getTenLHD(), pdk.getMaPDK(), sv.getHoTen(), lv.getTenLV(),
					pc.getNgayBaoCao() });
		}
	}

	public void DocDuLieuDatabaseVao2Table(int maHD_tim, int maPDK_tim) {
		dm2 = (DefaultTableModel) jTable2.getModel();
		dm2.setRowCount(0);
		List<ChiTietPhieuDiem> list = new ArrayList<ChiTietPhieuDiem>();

		qlcthd = new QuanLyChiTietHoiDong();
		qlpd = new QuanLyPhieuDiem();
		qlctpd = new QuanLyChiTietPhieuDiem();

		PhieuDiem pd = qlpd.chiTietPhieuDiem_HD_PDK(maHD_tim, maPDK_tim);

		list = qlctpd.tim_ChiTietPhieuDiem_PD(pd.getMaPD());
		DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
		for (ChiTietPhieuDiem ctpd : list) {
			GiangVien gv = qlgv.chiTietGiangVien(ctpd.getChiTietHoiDong().getGiangVien().getMaGV());
			dm.addRow(new Object[] { gv.getMaGV(), gv.getHoTen(), ctpd.getDiem() });
		}

		txtDiemTB.setText("" + pd.getDiemTrungBinh());
	}

	public boolean kiemTraNhap() {
		DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
		int soDong = jTable2.getRowCount();
		for (int row = 0; row < soDong; row++) {
			float diem = (float) jTable2.getValueAt(row, 2);
			if (diem < 0 || diem > 10) {
				jTable2.clearSelection();
				jTable2.changeSelection(row, 2, true, true);
				return false;
			}
		}
		return true;
	}

	public void luuDiem() {
		if (kiemTraNhap()) {
			int row = jTable1.getSelectedRow();
			TableModel model = jTable1.getModel();
			int maHD = Integer.parseInt(model.getValueAt(row, 0).toString());
			int maPDK = Integer.parseInt(model.getValueAt(row, 2).toString());
			PhieuDiem pd = qlpd.chiTietPhieuDiem_HD_PDK(maHD, maPDK);

			List<ChiTietPhieuDiem> list = new ArrayList<ChiTietPhieuDiem>();
			list = qlctpd.tim_ChiTietPhieuDiem_PD(pd.getMaPD());
			DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();

			float diemTB = 0;
			for (int i = 0; i < list.size(); i++) {
				float diem = (float) jTable2.getValueAt(i, 2);
				diemTB += diem;
				list.get(i).setDiem(diem);
				qlctpd.capNhatDiem(list.get(i));
			}
			float diemTB_nhap = diemTB / 5;
			pd.setDiemTrungBinh(diemTB_nhap);
			qlpd.capNhatPhieuDiem(pd);
			DocDuLieuDatabaseVao2Table(maHD, maPDK);

			PhieuDangKy pdk = qlpdk.chiTietPhieuDangKy(pd.getPhanCong().getPhieuDangKy().getMaPDK());
			HoiDong hd = qlhd.chiTietHoiDong(pd.getPhanCong().getHoiDong().getMaHD());
			if (hd.getLoaiHoiDong().getMaLHD() == 1) {
				pdk.setDiemTBVong1(diemTB_nhap);
				qlpdk.capNhatDiemThamDinh(pdk);
			} else {
				pdk.setDiemTBVong2(diemTB_nhap);
				qlpdk.capNhatDiemBaoCao(pdk);
				if (diemTB_nhap >= 5) {
					pdk.setKetQua(1);
				} else {
					pdk.setKetQua(0);
				}
				qlpdk.capNhatKetQua(pdk);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Nhập điểm không hợp lệ! Vui lòng xem lại giới hạn điểm 0-10");
		}
	}
	
	public void huyPhanCong(int maPDK,int maHD) {
		PhieuDiem pd = qlpd.chiTietPhieuDiem_HD_PDK(maHD, maPDK);
		try {
			if(pd.getDiemTrungBinh()==0) {
				qlctpd.delete_ctpd_PhieuDiem(pd.getMaPD());
				qlpd.delete(pd.getMaPD());
				qlpc.delete(maPDK, maHD);
				
				JOptionPane.showMessageDialog(this, "Hủy phân công thành công");
				
				DocDuLieuDatabaseVaoTable("", 0, khoa, hk, lhd);
				
				btnHuyPhanCong.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(this, "Không thể hủy vì sinh viên đã có điểm");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Hủy phân công không thành công");
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnTim;
	private javax.swing.JButton btnHuyPhanCong;
	private javax.swing.JButton btnLoc;
	private javax.swing.JButton btnLuu;
	private javax.swing.JComboBox<Khoa> cbbKhoa;
	private javax.swing.JComboBox<HocKy> cbbHK;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField txtTim;
	private javax.swing.table.DefaultTableModel dm;
	private javax.swing.table.DefaultTableModel dm2;

	private QuanLyHoiDong qlhd;
	private QuanLyLoaiHoiDong qllhd;
	private QuanLyLuanVan qllv;
	private QuanLySinhVien qlsv;
	private QuanLyKhoa qlkhoa;
	private QuanLyPhieuDangKy qlpdk;
	private QuanLyHocKy qlhk;
	private QuanLyPhanCong qlpc;
	private QuanLyChiTietHoiDong qlcthd;
	private QuanLyGiangVien qlgv;
	private QuanLyPhieuDiem qlpd;
	private QuanLyChiTietPhieuDiem qlctpd;

	private PhanCong pc;

	private Khoa khoa;
	private HocKy hk;
	private LoaiHoiDong lhd;

	private JLabel lblimTrungBnh;
	private JTextField txtDiemTB;
	private JLabel lblNewLabel;
	private JTextField txtSinhVien;
	private JLabel lblLunVn;
	private JLabel lblHing;
	private JLabel lblNgyBoCo;
	private JLabel lblNewLabel_4;
	private JTextField txtLuanVan;
	private JTextField txtHoiDong;
	private JTextField txtNgayBaoCao;

	private javax.swing.JComboBox<LoaiHoiDong> cbbLHD;
}
