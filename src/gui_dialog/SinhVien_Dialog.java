package gui_dialog;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import entities.Khoa;
import entities.SinhVien;
import entities.TaiKhoan;
import gui.Main;

import com.toedter.calendar.JDateChooser;

import dao.QuanLyKhoa;
import dao.QuanLySinhVien;
import dao.QuanLyTaiKhoan;
import database.Database;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nmrhu
 */
public class SinhVien_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form NewJDialog
	 */
	public SinhVien_Dialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

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
		qlsv = new QuanLySinhVien();
		qltk = new QuanLyTaiKhoan();

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtMaSV = new javax.swing.JTextField();
		txtMaSV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) && !e.isAltDown()) {
					e.consume();
				}
			}
		});
		
		txtHoTen = new javax.swing.JTextField();
		btnLuu = new javax.swing.JButton();
		btnDong = new javax.swing.JButton();
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtQueQuan = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		cbbKhoa = new javax.swing.JComboBox<>();
		cbbKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoa = (Khoa) cbbKhoa.getSelectedItem();
			}
		});
		radNam = new javax.swing.JRadioButton();
		radNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getRad(radNam);
				gioiTinh = 1;
			}
		});
		radNam.setSelected(true);

		radNu = new javax.swing.JRadioButton();
		radNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getRad(radNu);
				gioiTinh = 0;
			}
		});

		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setText("Mã sinh viên:");

		jLabel2.setText("Họ tên:");

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(new javax.swing.ImageIcon("image/save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (quyen == 1)
					themSinhVien();
				else
					capNhatSinhVien();
			}
		});

		btnDong.setBackground(new java.awt.Color(255, 0, 0));
		btnDong.setForeground(new java.awt.Color(255, 255, 255));
		btnDong.setIcon(
				new javax.swing.ImageIcon("image/delete_30px.png")); // NOI18N
		btnDong.setText("Đóng");

		jLabel3.setText("Ngày sinh:");

		jLabel4.setText("Quê quán:");

		jLabel5.setText("Khoa:");

		DefaultComboBoxModel<Khoa> dmKhoa = new DefaultComboBoxModel<Khoa>();
		cbbKhoa.setModel(dmKhoa);

		radNam.setText("Nam");
		radNu.setText("Nữ");

		jLabel6.setText("Giới tính:");

		txtNgaySinh = new JDateChooser();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNgaySinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(txtQueQuan, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(
								layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139,
														Short.MAX_VALUE)
												.addComponent(jLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
												layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(txtMaSV, GroupLayout.DEFAULT_SIZE, 333,
																		Short.MAX_VALUE)
																.addComponent(txtHoTen).addComponent(cbbKhoa, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(radNam, GroupLayout.PREFERRED_SIZE, 89,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(radNu)))))
				.addContainerGap(30, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel1).addComponent(txtMaSV,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(txtHoTen,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(radNam).addComponent(radNu)
						.addComponent(jLabel6))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel5).addComponent(cbbKhoa,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel3).addComponent(txtNgaySinh,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel4).addComponent(txtQueQuan,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnLuu).addComponent(btnDong))
				.addContainerGap(42, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	public void setData(int quyenData, SinhVien sv) {
		// quyen == 1 -> Thêm sinh viên
		DocDuLieuDatabaseVaoCombobox();
		if (quyenData == 1) {
			quyen = 1;
		}
		// -> Cập nhật sinh viên
		else {
			quyen = 2;
			setSinhvien(sv);
			txtMaSV.setEditable(false);
		}
	}

	public void setSinhvien(SinhVien sv) {
		txtMaSV.setText(sv.getMaSV());
		txtHoTen.setText(sv.getHoTen());
		txtQueQuan.setText(sv.getQueQuan());
		Khoa k = qlkhoa.chiTietKhoa(sv.getKhoa().getMaKhoa());
		DefaultComboBoxModel<Khoa> dm = (DefaultComboBoxModel<Khoa>) cbbKhoa.getModel();
		dm.setSelectedItem(k);
		
		if(sv.getGioitinh() == 0)
			getRad(radNu);
		else
			getRad(radNam);
		
		txtNgaySinh.setDate(sv.getNgaySinh());
	}

	public void getRad(JRadioButton rad) {
		radNam.setSelected(false);
		radNu.setSelected(false);

		rad.setSelected(true);
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

	public boolean kiemTraNhap() {
		String maSV = txtMaSV.getText();
		String hoTen = txtHoTen.getText();
		String queQuan = txtQueQuan.getText();
		
		if(maSV.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ");
			return false;
		}
		
		if(maSV.length() != 8 ) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên với 8 chữ số (VD: 17039181)");
			txtMaSV.requestFocus();
			return false;
		}
		if(hoTen.equals("") ) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên");
			txtHoTen.requestFocus();
			return false;
		}
		if(txtNgaySinh.getCalendar() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
			txtNgaySinh.requestFocus();
			return false;
		}
		if(queQuan.equals("") ) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
			txtQueQuan.requestFocus();
			return false;
		}	
		return true;
	}
	
	public SinhVien getSinhVien() {
		String maSV = txtMaSV.getText();
		String hoTen = txtHoTen.getText();
		long ngaySinh = txtNgaySinh.getDate().getTime();
		Date ngaySinh_sql = new Date(ngaySinh);
		String queQuan = txtQueQuan.getText();
		SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh,new TaiKhoan(maSV), khoa, ngaySinh_sql, queQuan);
		return sv;
	}

	public void themSinhVien() {
		if(kiemTraNhap()) {
			SinhVien sv = getSinhVien();
			TaiKhoan tk = new TaiKhoan(sv.getMaSV(), "123", 1);
			try {
				qltk.themTaiKhoan(tk);
				qlsv.themSinhVien(sv);
				main.sv_gui.DocDuLieuDatabaseVaoTable("", 0, null);
				main.qltk_gui.DocDuLieuDatabaseVaoTable("");
				main.sv_gui.clear();
				JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
				clear();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại!");
				txtMaSV.requestFocus();
			}
		}
	}
	
	public void capNhatSinhVien() {
		if(kiemTraNhap()) {
			SinhVien sv = getSinhVien();
			try {
				qlsv.capNhatSinhVien(sv);
				main.sv_gui.DocDuLieuDatabaseVaoTable("", 0, null);
				main.sv_gui.clear();
				JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Cập nhật sinh viên không thành công!");
			}
		}
	}

	public void clear() {
		txtMaSV.setText("");
		txtHoTen.setText("");
		txtQueQuan.setText("");
		txtNgaySinh.setCalendar(null);
		getRad(radNam);
		gioiTinh = 1;
		DocDuLieuDatabaseVaoCombobox();
	}
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLuu;
	private javax.swing.JButton btnDong;
	private javax.swing.JComboBox<Khoa> cbbKhoa;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JRadioButton radNam;
	private javax.swing.JRadioButton radNu;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtQueQuan;
	private javax.swing.JTextField txtMaSV;
	private JDateChooser txtNgaySinh;

	private int quyen;
	private int gioiTinh = 1;
	private Khoa khoa;

	private QuanLySinhVien qlsv;
	private QuanLyTaiKhoan qltk;
	private QuanLyKhoa qlkhoa;

	public static Main main;
}
