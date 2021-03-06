package gui_dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.QuanLyChiTietHoiDong;
import dao.QuanLyChiTietPhieuDiem;
import dao.QuanLyGiangVien;
import dao.QuanLyHoiDong;
import dao.QuanLyKhoa;
import dao.QuanLyLoaiHoiDong;
import database.Database;
import entities.ChiTietHoiDong;
import entities.GiangVien;
import entities.HoiDong;
import entities.Khoa;
import entities.LoaiHoiDong;
import entities.LuanVan;
import gui.Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nmrhu
 */
public class HoiDong_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form NewJDialog
	 */
	public HoiDong_Dialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		DocDuLieuDatabaseVaoComboboxLHD();
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
		qlcthd = new QuanLyChiTietHoiDong();
		qlgv = new QuanLyGiangVien();
		qlhd = new QuanLyHoiDong();
		qllhd = new QuanLyLoaiHoiDong();

		jLabel1 = new javax.swing.JLabel();
		txtMaHD = new javax.swing.JTextField();
		txtMaHD.setEditable(false);
		btnLuu = new javax.swing.JButton();
		btnDong = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		cbbLHD = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		cbbKhoa = new javax.swing.JComboBox<>();
		jLabel6 = new javax.swing.JLabel();
		cbbGiangVien = new javax.swing.JComboBox<>();
		btnThem = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setText("Mã hội đồng:");

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(new javax.swing.ImageIcon("image/save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (quyen == 1) {
					if (list.size() == 5) {
						themHoiDong();
						themChiTietHoiDong();
						clear();
					} else {
						JOptionPane.showMessageDialog(main, "Hội đồng chưa đủ 5 thành viên");
					}
				} else {
					int thanhVien;
					try {
						thanhVien = qlcthd.demChiTietHoiDong_HoiDong(Integer.parseInt(txtMaHD.getText()));
					} catch (NumberFormatException | SQLException e) {
						thanhVien = 0;
					}

					if (thanhVien != 5) {
						JOptionPane.showMessageDialog(main, "Hội đồng chưa đủ 5 thành viên");
					} else {
						capNhatHoiDong();
						JOptionPane.showMessageDialog(main, "Cập nhật hội đồng thành công!");
						main.hd_gui.DocDuLieuDatabaseVaoTable("", 0, null);
					}
				}
			}
		});

		btnDong.setBackground(new java.awt.Color(255, 0, 0));
		btnDong.setForeground(new java.awt.Color(255, 255, 255));
		btnDong.setIcon(new javax.swing.ImageIcon("image/delete_30px.png")); // NOI18N
		btnDong.setText("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		jLabel5.setText("Loại hội đồng:");

		DefaultComboBoxModel<LoaiHoiDong> dmLHD = new DefaultComboBoxModel<LoaiHoiDong>();
		cbbLHD.setModel(dmLHD);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "MaGV", "Họ tên" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (quyen == 3) {
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
				} else {
					int row = jTable1.getSelectedRow();
					TableModel model = jTable1.getModel();
					String maGV = model.getValueAt(row, 0).toString();

					GiangVien gv = qlgv.chiTietGiangVien(maGV);

					khoa = qlkhoa.chiTietKhoa(gv.getKhoa().getMaKhoa());
					DefaultComboBoxModel<Khoa> dmKhoa = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
					dmKhoa.setSelectedItem(khoa);

					DefaultComboBoxModel<GiangVien> dmGV = (DefaultComboBoxModel<GiangVien>) cbbGiangVien.getModel();
					dmGV.setSelectedItem(gv);
					btnXoa.setEnabled(true);

				}
			}
		});
		jTable1.setGridColor(new java.awt.Color(255, 255, 255));
		jTable1.setRowHeight(20);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		jScrollPane1.setViewportView(jTable1);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Giảng viên:"));

		jLabel3.setText("Khoa:");
		jLabel6.setText("Giảng viên:");

		DefaultComboBoxModel<Khoa> dmKhoa = new DefaultComboBoxModel<Khoa>();
		cbbKhoa.setModel(dmKhoa);
		cbbKhoa = new javax.swing.JComboBox<>();
		cbbKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoa = (Khoa) cbbKhoa.getSelectedItem();
				DocDuLieuDatabaseVaoComboboxGV(khoa);
			}
		});

		DefaultComboBoxModel<GiangVien> dmGV = new DefaultComboBoxModel<GiangVien>();
		cbbGiangVien.setModel(dmGV);
		cbbGiangVien = new javax.swing.JComboBox<>();
		cbbGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gv = (GiangVien) cbbGiangVien.getSelectedItem();
			}
		});

		btnThem.setBackground(new java.awt.Color(0, 153, 255));
		btnThem.setForeground(new java.awt.Color(255, 255, 255));
		btnThem.setIcon(new javax.swing.ImageIcon("image/add_30px.png")); // NOI18N
		btnThem.setText("Thêm");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (quyen == 1)
					themGiangVien();
				else if (quyen == 2) {
					int thanhVien = 0;
					try {
						thanhVien = qlcthd.demChiTietHoiDong_HoiDong(Integer.parseInt(txtMaHD.getText()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					if (thanhVien >= 5) {
						JOptionPane.showMessageDialog(null, "Hội đồng đã đủ thành viên!");
					} else {
						ChiTietHoiDong cthd = new ChiTietHoiDong(new HoiDong(Integer.parseInt(txtMaHD.getText())), gv);
						try {
							qlcthd.themChiTietHoiDong(cthd);
							DocDuLieuDatabaseVaoTable();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Giảng viên đã được thêm!");
						}
					}
				}
			}
		});

		btnXoa.setBackground(new java.awt.Color(255, 0, 0));
		btnXoa.setForeground(new java.awt.Color(255, 255, 255));
		btnXoa.setIcon(new javax.swing.ImageIcon("img/delete_30px.png")); // NOI18N
		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (quyen == 1)
					xoaGiangVien();
				else if (quyen == 2) {
					try {
						ChiTietHoiDong cthd = new ChiTietHoiDong(new HoiDong(Integer.parseInt(txtMaHD.getText())), gv);
						qlcthd.delete(cthd);
						DocDuLieuDatabaseVaoTable();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Thành viên hội đồng không thể xóa!");
					}
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(cbbKhoa, 0, 333, Short.MAX_VALUE)
								.addComponent(cbbGiangVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(cbbGiangVien,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem).addComponent(btnXoa))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 333,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cbbLHD, 0, 332, Short.MAX_VALUE))
								.addComponent(jScrollPane1))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5).addComponent(cbbLHD, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(18, 18, 18)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnLuu)
						.addComponent(btnDong))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	public int getMaHD() {
		int maHD;
		try {
			maHD = qlhd.getmaHD();
		} catch (Exception e) {
			maHD = 0;
		}
		return maHD;
	}

	public void setData(int quyenData, HoiDong hd) {
		// quyen == 1 -> Thêm sinh viên
		DocDuLieuDatabaseVaoCombobox();
		list = new ArrayList<ChiTietHoiDong>();
		if (quyenData == 1) {
			quyen = 1;
//			int maHD = getMaHD();
//			txtMaHD.setText("" + (maHD + 1));
			
		}
		// -> Cập nhật sinh viên
		else if (quyenData == 2) {
			quyen = 2;
			txtMaHD.setText("" + hd.getMaHD());
			LoaiHoiDong lhd = qllhd.chiTietLoaiHoiDong(hd.getLoaiHoiDong().getMaLHD());
			DefaultComboBoxModel<LoaiHoiDong> dmLHD = (DefaultComboBoxModel<LoaiHoiDong>) cbbLHD.getModel();
			dmLHD.setSelectedItem(lhd);
			DocDuLieuDatabaseVaoTable();
		} else {
			quyen = 3;
			txtMaHD.setText("" + hd.getMaHD());
			LoaiHoiDong lhd = qllhd.chiTietLoaiHoiDong(hd.getLoaiHoiDong().getMaLHD());
			DefaultComboBoxModel<LoaiHoiDong> dmLHD = (DefaultComboBoxModel<LoaiHoiDong>) cbbLHD.getModel();
			dmLHD.setSelectedItem(lhd);
			DocDuLieuDatabaseVaoTable();

			btnLuu.setEnabled(false);
			btnThem.setEnabled(false);
		}
	}

	public void XoaHetDuLieuTrenTable() {
		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void DocDuLieuDatabaseVaoTable() {
		XoaHetDuLieuTrenTable();
		List<ChiTietHoiDong> list = new ArrayList<ChiTietHoiDong>();
		qlcthd = new QuanLyChiTietHoiDong();
		list = qlcthd.tim_ChiTietHoiDong_HoiDong(Integer.parseInt(txtMaHD.getText()));
		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		for (ChiTietHoiDong chiTietHoiDong : list) {
			GiangVien gv = qlgv.chiTietGiangVien(chiTietHoiDong.getGiangVien().getMaGV());
			dm.addRow(new Object[] { gv.getMaGV(), gv.getHoTen() });
		}
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

	public void XoaHetDuLieuTrenCombobox() {
		DefaultComboBoxModel<Khoa> dm = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
		dm.removeAllElements();
	}

	public void DocDuLieuDatabaseVaoCombobox() {
		XoaHetDuLieuTrenCombobox();
		List<Khoa> list = new ArrayList<Khoa>();
		qlkhoa = new QuanLyKhoa();
		list = qlkhoa.dsKhoa();

		DefaultComboBoxModel<Khoa> dm = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
		for (Khoa khoa : list) {
			dm.addElement(khoa);
		}
	}

	public void XoaHetDuLieuTrenComboboxGV() {
		DefaultComboBoxModel<GiangVien> dm = (DefaultComboBoxModel<GiangVien>) cbbGiangVien.getModel();
		dm.removeAllElements();
	}

	public void DocDuLieuDatabaseVaoComboboxGV(Khoa k) {
		XoaHetDuLieuTrenComboboxGV();
		List<GiangVien> list = new ArrayList<GiangVien>();
		qlgv = new QuanLyGiangVien();
		list = qlgv.tim_GiangVienTheoKhoa(k.getMaKhoa());

		DefaultComboBoxModel<GiangVien> dm = (DefaultComboBoxModel<GiangVien>) cbbGiangVien.getModel();
		for (GiangVien gv : list) {
			dm.addElement(gv);
		}
	}

	public boolean kiemTraTrung() {
		for (ChiTietHoiDong chiTietHoiDong : list) {
			if (chiTietHoiDong.getGiangVien().getMaGV().equalsIgnoreCase(gv.getMaGV()))
				return false;
		}
		return true;
	}

	public void themGiangVien() {
		if (kiemTraTrung()) {
//			ChiTietHoiDong cthd = new ChiTietHoiDong(new HoiDong(Integer.parseInt(txtMaHD.getText())), gv);
			ChiTietHoiDong cthd = new ChiTietHoiDong(gv);
			if (list.size() >= 5) {
				JOptionPane.showMessageDialog(this, "Hội đồng đã đủ thành viên!");
			} else {
				list.add(cthd);
				DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
				dm.addRow(new Object[] { gv.getMaGV(), gv.getHoTen() });
			}
		} else {
			JOptionPane.showMessageDialog(this, "Giảng viên đã được thêm trong hội đồng!");
		}
	}

	public void xoaGiangVien() {
		int row = jTable1.getSelectedRow();
		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		if (jTable1.getRowCount() == 1) {
			dm.removeRow(0);
		} else {
			dm.removeRow(row);
		}
		list.remove(row);
		DocDuLieu();
	}

	public void DocDuLieu() {
		XoaHetDuLieuTrenTable();
		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		for (ChiTietHoiDong chiTHD : list) {
			dm.addRow(new Object[] { chiTHD.getGiangVien().getMaGV(), chiTHD.getGiangVien().getHoTen() });
		}
		btnXoa.setEnabled(false);
	}

	public void clear() {
		btnXoa.setEnabled(false);
	}

	public void themHoiDong() {
		LoaiHoiDong lhd = (LoaiHoiDong) cbbLHD.getSelectedItem();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);		
//		HoiDong hd = new HoiDong(Integer.parseInt(txtMaHD.getText()), lhd, date);
		HoiDong hd = new HoiDong(lhd, date);
		qlhd.themHoiDong(hd);
	}

	public void capNhatHoiDong() {
		LoaiHoiDong lhd = (LoaiHoiDong) cbbLHD.getSelectedItem();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
//		HoiDong hd = new HoiDong(Integer.parseInt(txtMaHD.getText()), lhd, date);
		HoiDong hd = new HoiDong(lhd, date);
		qlhd.capNhatHoiDong(hd);
	}

	public void themChiTietHoiDong() {
		for (ChiTietHoiDong chiTietHoiDong : list) {
			try {
				chiTietHoiDong.setHoiDong(new HoiDong(qlhd.getmaHD()));
				qlcthd.themChiTietHoiDong(chiTietHoiDong);
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Lập chi tiết hội đồng không thành công!");
			}
		}
		JOptionPane.showMessageDialog(this, "Lập hội đồng thành công! Mã hội đồng : " + getMaHD());
		main.hd_gui.DocDuLieuDatabaseVaoTable("", 0, null);

		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		dm.setRowCount(0);
		list = new ArrayList<ChiTietHoiDong>();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLuu;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnDong;
	private javax.swing.JButton btnXoa;
	private javax.swing.JComboBox<LoaiHoiDong> cbbLHD;
	private javax.swing.JComboBox<Khoa> cbbKhoa;
	private javax.swing.JComboBox<GiangVien> cbbGiangVien;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField txtMaHD;

	private int quyen;
	private QuanLyKhoa qlkhoa;
	private QuanLyHoiDong qlhd;
	private QuanLyGiangVien qlgv;
	private QuanLyLoaiHoiDong qllhd;
	private QuanLyChiTietHoiDong qlcthd;
	private QuanLyChiTietPhieuDiem qlctpd;

	public static Main main;

	private List<ChiTietHoiDong> list;

	private Khoa khoa;
	private GiangVien gv;
	// End of variables declaration//GEN-END:variables
}
