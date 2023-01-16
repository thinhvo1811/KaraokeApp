package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLightLaf;

import connect.Connect;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class DangNhap extends JFrame implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	private JTextField txtTaiKhoan;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private JButton btnKhachhang;
	
	private NhanVien_DAO nhanvien_DAO;
	private TaiKhoan_DAO taikhoan_DAO;
	private JPasswordField txtMatKhau;
	private static GiaoDienChinh gdc;
	private static GiaoDienNhanVien gdnv;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					IconFontSwing.register(FontAwesome.getIconFont());

					DangNhap frame = new DangNhap();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DangNhap() {
		IconFontSwing.register(FontAwesome.getIconFont());
		ImageIcon logoApp = (ImageIcon) IconFontSwing.buildIcon(FontAwesome.SMILE_O, 50, new Color(164, 44,167));
		setIconImage(logoApp.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Đăng nhập Karaoke NICE");
		setSize(900,500);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		//connect database
		try {
			Connect.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		nhanvien_DAO = new NhanVien_DAO();
		taikhoan_DAO = new TaiKhoan_DAO();
		
		Image imgHeader = Toolkit.getDefaultToolkit ().getImage("icon/logo.png");
		JLabel lbHeaderDN = new JLabel("");
		lbHeaderDN.setBounds(0, 0, 900, 50);
		getContentPane().add(lbHeaderDN);
		Image imgresize = imgHeader.getScaledInstance(lbHeaderDN.getWidth(), lbHeaderDN.getHeight(), 0);
		lbHeaderDN.setIcon(new ImageIcon(imgresize));
		
		JLabel lblTaiKhoan = new JLabel("Tên đăng nhập:");
		lblTaiKhoan.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTaiKhoan.setForeground(new Color(255, 255, 255));
		lblTaiKhoan.setBounds(300, 251, 119, 20);
		getContentPane().add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));

		txtTaiKhoan.setBounds(420, 247, 246, 33);
		getContentPane().add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblMatKhau.setBounds(300, 300, 112, 20);
		getContentPane().add(lblMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(420, 297, 246, 33);
		txtMatKhau.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMatKhau.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));
		getContentPane().add(txtMatKhau);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangNhap.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDangNhap.setBackground(new Color(164, 44,167));
		btnDangNhap.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBounds(280, 355, 176, 33);
		
		Icon iconDangNhap = IconFontSwing.buildIcon(FontAwesome.SIGN_IN, 20, new Color(255, 255 ,255));
		btnDangNhap.setIcon(iconDangNhap);
		
		getContentPane().add(btnDangNhap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnThoat.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnThoat.setBackground(new Color(164, 44, 167));
		btnThoat.setBounds(550, 355, 176, 33);
		Icon iconThoat = IconFontSwing.buildIcon(FontAwesome.POWER_OFF, 20, new Color(255, 255 ,255));
		btnThoat.setIcon(iconThoat);
		
		getContentPane().add(btnThoat);
		
		btnKhachhang = new JButton("Dành cho khách hàng");
		btnKhachhang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKhachhang.setFont(new Font("SansSerif", Font.ITALIC, 13));
		btnKhachhang.setBackground(new Color(13, 198, 243));
		btnKhachhang.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnKhachhang.setForeground(Color.WHITE);
		btnKhachhang.setBounds(550, 405, 176, 30);
		
		getContentPane().add(btnKhachhang);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 900, 450);
		getContentPane().add(lblBackground);
		Image imgBackground = Toolkit.getDefaultToolkit ().getImage ("icon/imdn.jpg");
		Image resizeBackground = imgBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), 0);
		lblBackground.setIcon(new ImageIcon(resizeBackground));
			
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		btnKhachhang.addActionListener(this);
		btnDangNhap.addKeyListener(this);
		btnThoat.addKeyListener(this);
		txtMatKhau.addKeyListener(this);
		txtTaiKhoan.addKeyListener(this);
	}
	  
	
	//Kiểm tra đăng nhập
	
	public void dangNhap() {
		
		String tenDN = txtTaiKhoan.getText().toString().trim();
		String mk = txtMatKhau.getText().toString().trim();
		TaiKhoan tk = taikhoan_DAO.getTaiKHoanTheoTenDN(tenDN);
		
		
		if(tk == null) {
			JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!");
		}
		else if(!tk.getMatKhau().equalsIgnoreCase(mk)){
			JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!\nVui lòng kiểm tra lại.");
		}
		else {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
			NhanVien nv = nhanvien_DAO.getNVtheoMa(tk.getNhanVien().getMaNV());
			JPanel_TaiKhoanCuaToi tkct = new JPanel_TaiKhoanCuaToi(nv, tk);
			if(nv.getChucVu().getTenChucVu().equalsIgnoreCase("NV Quản lý")) {
				gdc = new GiaoDienChinh(nv, tk);
				gdc.setVisible(true);
				this.setVisible(false);
			}
			else {
				gdnv = new GiaoDienNhanVien(nv, tk);
				gdnv.setVisible(true);
				this.setVisible(false);
			}
		}
	}
	
	private void khachhang() {
		GiaoDienKhachHang kh = new GiaoDienKhachHang();
		kh.setVisible(true);
		this.setVisible(false);
	}
	
	//event
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			System.exit(0);
		}
		else if(o.equals(btnDangNhap)) {	
			
			dangNhap();
			
		}
		else if(o.equals(btnKhachhang)) {
			khachhang();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		int key = e.getKeyCode();
		if(o.equals(txtTaiKhoan)&& key == KeyEvent.VK_ENTER ) {
			txtMatKhau.requestFocus();
		}
		else if(o.equals(txtMatKhau)&& key == KeyEvent.VK_ENTER ) {
			btnDangNhap.doClick();
		}
		else if(o.equals(txtTaiKhoan)&& key == KeyEvent.VK_TAB ) {
			txtMatKhau.requestFocus();
		}
		else if(o.equals(txtMatKhau)&& key == KeyEvent.VK_TAB ) {
			btnDangNhap.requestFocus();
		}
		else if(o.equals(btnDangNhap)&& key == KeyEvent.VK_TAB ) {
			btnThoat.requestFocus();
		}
		

		else if(key == KeyEvent.VK_ENTER) {
			btnDangNhap.doClick();
		}
		else if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		
	}
	public static JFrame getFR() {
		return gdc;
	}
	public static JFrame getFRNV() {
		return gdnv;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

