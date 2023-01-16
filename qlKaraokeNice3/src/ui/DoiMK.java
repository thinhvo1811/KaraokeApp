package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import connect.Connect;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;

import entity.NhanVien;
import entity.TaiKhoan;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class DoiMK extends JFrame implements ActionListener,MouseListener,KeyListener {

	
	private static final long serialVersionUID = 1L;
	private JPasswordField pwMatKhauCu;
	private JButton btnQuayLai;
	private JButton btnDoiMK;
	private TaiKhoan_DAO taikhoan_DAO;
	private JPasswordField pwMatKhauMoi;
	private JPasswordField pwXacNhan;
	private DangNhap frmDN;



	public DoiMK() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Đổi mật khẩu");
		setSize(700,500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		
		
		//connect database
		try {
			Connect.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		frmDN = new DangNhap();
		taikhoan_DAO = new TaiKhoan_DAO();
		
		IconFontSwing.register(FontAwesome.getIconFont());
		ImageIcon logoApp = (ImageIcon) IconFontSwing.buildIcon(FontAwesome.SMILE_O, 50, new Color(164, 44,167));
		setIconImage(logoApp.getImage());
		
		Image imgHeader = Toolkit.getDefaultToolkit ().getImage ("icon/logo.png");
		JLabel lbHeaderDN = new JLabel("");
		lbHeaderDN.setBounds(0, 0, 700, 50);
		getContentPane().add(lbHeaderDN);
		Image imgresize = imgHeader.getScaledInstance(lbHeaderDN.getWidth(), lbHeaderDN.getHeight(), 0);
		lbHeaderDN.setIcon(new ImageIcon(imgresize));
		
		JLabel lblMatKhauCu = new JLabel("Mật khẩu cũ:");
		lblMatKhauCu.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblMatKhauCu.setForeground(new Color(255, 255, 255));
		lblMatKhauCu.setBounds(120, 156, 119, 20);
		getContentPane().add(lblMatKhauCu);
		
		pwMatKhauCu = new JPasswordField();
		pwMatKhauCu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pwMatKhauCu.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));
		pwMatKhauCu.setBounds(240, 150, 246, 33);
		getContentPane().add(pwMatKhauCu);
		pwMatKhauCu.setColumns(10);
		
		JLabel lblSubQuenMK = new JLabel("ĐỔI MẬT KHẨU MỚI");
		lblSubQuenMK.setForeground(Color.WHITE);
		lblSubQuenMK.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblSubQuenMK.setLabelFor(this);
		lblSubQuenMK.setBounds(200, 100, 300, 39);
		getContentPane().add(lblSubQuenMK);
		
		btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoiMK.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDoiMK.setBackground(new Color(164, 44,167));
		btnDoiMK.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnDoiMK.setForeground(Color.WHITE);
		btnDoiMK.setBounds(250, 350, 201, 33);
		
		Icon iconDoiMK = IconFontSwing.buildIcon(FontAwesome.EXCHANGE, 20, new Color(255, 255 ,255));
		btnDoiMK.setIcon(iconDoiMK);
		
		getContentPane().add(btnDoiMK);
		
		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnQuayLai.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnQuayLai.setBackground(new Color(164, 44, 167));
		btnQuayLai.setBounds(250, 400, 201, 33);
		
		Icon iconQuayLai = IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_LEFT, 20, new Color(255, 255 ,255));
		btnQuayLai.setIcon(iconQuayLai);
		
		getContentPane().add(btnQuayLai);
		
		JLabel lblNhac1 = new JLabel("");
		
		lblNhac1.setBounds(28, 344, 83, 93);
		
		
		
		JLabel lblMKMoi = new JLabel("Mật khẩu mới:");
		lblMKMoi.setForeground(Color.WHITE);
		lblMKMoi.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblMKMoi.setBounds(120, 225, 112, 20);
		getContentPane().add(lblMKMoi);
		
		pwMatKhauMoi = new JPasswordField();
		pwMatKhauMoi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pwMatKhauMoi.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));
		pwMatKhauMoi.setBounds(240, 221, 246, 33);
		getContentPane().add(pwMatKhauMoi);
		
		JLabel lblXacNhan = new JLabel("Xác nhận lại:");
		lblXacNhan.setForeground(Color.WHITE);
		lblXacNhan.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblXacNhan.setBounds(120, 290, 100, 20);
		getContentPane().add(lblXacNhan);
		
		pwXacNhan = new JPasswordField();
		pwXacNhan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		pwXacNhan.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));
		pwXacNhan.setBounds(240, 287, 246, 33);
		getContentPane().add(pwXacNhan);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 700, 450);
		getContentPane().add(lblBackground);
		Image imgBackground = Toolkit.getDefaultToolkit ().getImage ("icon/imqmk.jpg");
		Image resizeBackground = imgBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), 0);
		lblBackground.setIcon(new ImageIcon(resizeBackground));
		
		btnDoiMK.addActionListener(this);
		btnQuayLai.addActionListener(this);
		pwMatKhauCu.addKeyListener(this);
		pwMatKhauMoi.addKeyListener(this);
		pwXacNhan.addKeyListener(this);
		btnDoiMK.addKeyListener(this);
		btnQuayLai.addKeyListener(this);
		
		
		
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e)
//			{
//				frmDN.setVisible(true);
//			}
//		});
		
	}
	
	@SuppressWarnings("deprecation")
	public boolean kiemTraRong() {
		if(pwMatKhauCu.getText().trim().length() == 0||pwMatKhauMoi.getText().trim().length() == 0||pwXacNhan.getText().trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public void lamMoi() {
		pwMatKhauCu.setText("");
		pwMatKhauMoi.setText("");
		pwXacNhan.setText("");
	}

	
	//Kiểm tra đăng nhập
	@SuppressWarnings("deprecation")
	public void doiMK() {
		
		String mkCu = pwMatKhauCu.getText().toString().trim();
		String mkMoi = pwMatKhauMoi.getText().toString().trim();
		String xacNhan = pwXacNhan.getText().toString().trim();
		
		TaiKhoan tk = taikhoan_DAO.getTaiKHoanTheoTenDN(JPanel_TaiKhoanCuaToi.getTenDN());
		
		
		if(!kiemTraRong()) {
			if(!taikhoan_DAO.getMKTheoTenDN(JPanel_TaiKhoanCuaToi.getTenDN()).equals(mkCu)) {
				JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng!\\n vui lòng kiểm tra lại.");
			}
			else if(pwMatKhauMoi.getText().trim().length() > 0) {
				if(mkMoi.equalsIgnoreCase(xacNhan)){
					tk.setMatKhau(mkMoi);
					if(taikhoan_DAO.DoiMK(tk)) {
						JOptionPane.showMessageDialog(this, "Mật khẩu đã được đổi thành công.\n Vui lòng đăng nhập lại");						
						if(JPanel_TaiKhoanCuaToi.getCV().equals("NV Quản Lý")) {
							dispose();
							DangNhap.getFR().setVisible(false);
						}
						else {
							dispose();
							DangNhap.getFRNV().setVisible(false);
						}
						frmDN.setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không đúng!\n vui lòng kiểm tra lại.");
					pwXacNhan.requestFocus();
					pwXacNhan.selectAll();
				}
			}
		}
		else JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
	}
	
	//event
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnQuayLai)) {
//			DangNhap frmDN = new DangNhap();
//			frmDN.setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(btnDoiMK)) {	
			
			doiMK();
			
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		int key = e.getKeyCode();
		if(o.equals(pwMatKhauCu)&& key == KeyEvent.VK_ENTER ) {
			pwMatKhauMoi.requestFocus();
		}
		else if(o.equals(pwMatKhauMoi)&& key == KeyEvent.VK_ENTER ) {
			pwXacNhan.requestFocus();
		}
		else if(o.equals(pwXacNhan)&& key == KeyEvent.VK_ENTER ) {
			btnDoiMK.doClick();
		}
		else if(key == KeyEvent.VK_ENTER ) {
			btnDoiMK.doClick();
		}
		else if(key == KeyEvent.VK_ESCAPE ) {
			frmDN.setVisible(true);
			this.setVisible(false);
		}
		
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

