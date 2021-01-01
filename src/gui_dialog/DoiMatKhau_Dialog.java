/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_dialog;

import javax.swing.JOptionPane;

import dao.QuanLyTaiKhoan;
import database.Database;
import entities.SinhVien;
import entities.TaiKhoan;

/**
 *
 * @author nmrhu
 */
public class DoiMatKhau_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form TaiKhoan_DL
	 */
	public DoiMatKhau_Dialog(java.awt.Frame parent, boolean modal) {
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
		qltk = new QuanLyTaiKhoan();

		jLabel5 = new javax.swing.JLabel();
		btnLuu = new javax.swing.JButton();
		btnXoaTrang = new javax.swing.JButton();
		txtMatKhau = new javax.swing.JTextField();
		txtMatKhauMoi = new javax.swing.JTextField();
		txtXacNhan = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel5.setText("Xác nhận:");

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(
				new javax.swing.ImageIcon("image/save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doiMatKhau();
			}
		});

		btnXoaTrang.setBackground(new java.awt.Color(255, 0, 0));
		btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
		btnXoaTrang.setIcon(
				new javax.swing.ImageIcon("image/delete_30px.png")); // NOI18N
		btnXoaTrang.setText("Đóng");
		btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		jLabel3.setText("Mật khẩu:");

		jLabel4.setText("Mât khẩu mới:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtMatKhau).addComponent(txtMatKhauMoi).addComponent(txtXacNhan)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 153,
												Short.MAX_VALUE)))
						.addGap(23, 23, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
						.addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnLuu)
						.addComponent(btnXoaTrang))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	public static void setData(TaiKhoan tksql) {
		tk = tksql;
	}

	public boolean kiemTraNhap() {
		if (txtMatKhau.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập mật khẩu cũ!");
			txtMatKhau.requestFocus();
			return false;
		}
		if (txtMatKhauMoi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập mật khẩu mới!");
			txtMatKhauMoi.requestFocus();
			return false;
		}
		if (txtXacNhan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập mật khẩu xác nhận!");
			txtXacNhan.requestFocus();
			return false;
		}
		return true;
	}

	public boolean kiemTraXacNhan() {
		if (txtMatKhauMoi.getText().equals(txtXacNhan.getText())) {
			return true;
		}
		JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không chính xác!");
		txtXacNhan.requestFocus();
		return false;
	}

	public boolean kiemTraMatKhauCu() {
		if (txtMatKhau.getText().equals(tk.getMatKhau())) {
			return true;
		}
		JOptionPane.showMessageDialog(this, "Mật khẩu không chính xác!");
		txtMatKhau.requestFocus();
		return false;
	}

	public void doiMatKhau() {
		if (kiemTraNhap()) {
			if (kiemTraMatKhauCu()) {
				if (kiemTraXacNhan()) {
					tk.setMatKhau(txtMatKhauMoi.getText());
					try {
						qltk.capNhatMatKhau(tk);
						JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thành công!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu không thành công!");
					}
				}
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLuu;
	private javax.swing.JButton btnXoaTrang;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField txtMatKhau;
	private javax.swing.JTextField txtMatKhauMoi;
	private javax.swing.JTextField txtXacNhan;

	private static QuanLyTaiKhoan qltk;

	public static TaiKhoan tk;
	// End of variables declaration//GEN-END:variables
}