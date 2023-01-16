/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connect.Connect;
import dao.ChucVu_DAO;
import dao.DichVu_DAO;
import dao.LoaiDichVu_DAO;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.NhanVien;

/**
 *
 * @author dell
 */
public class JPanel_DMDichVu extends javax.swing.JPanel {
	private DichVu_DAO dichVu_DAO;
	private LoaiDichVu_DAO loaiDV_DAO;
	private DefaultTableModel model;

    /**
     * Creates new form Panel1
     */
    public JPanel_DMDichVu() {
        initComponents();
        tblDichVu.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
        model = (DefaultTableModel) tblDichVu.getModel();
		try {
			Connect.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dichVu_DAO = new DichVu_DAO();
		loaiDV_DAO = new LoaiDichVu_DAO();
		DocDuLieuDatabaseVaoTable();
        loadCBBLoaiDV(cboLoaiDV);
        txtMaDV.setText(dichVu_DAO.getMaDV());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongTinDV = new javax.swing.JPanel();
        lblMaDV = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        lblDonViTinh = new javax.swing.JLabel();
        lblTrangThaiKD = new javax.swing.JLabel();
        dchHSD = new com.toedter.calendar.JDateChooser();
        txtGia = new javax.swing.JTextField();
        lblTenDV = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblLoaiDV = new javax.swing.JLabel();
        cboLoaiDV = new javax.swing.JComboBox<>();
        lblGia = new javax.swing.JLabel();
        cboTrangThaiKD = new javax.swing.JComboBox<>();
        lblHanSuDung = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        pnlSuKien = new javax.swing.JPanel();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        pnlDanhSachDV = new javax.swing.JPanel();
        scr = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();

        pnlThongTinDV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 20))); // NOI18N
        pnlThongTinDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblMaDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaDV.setText("Mã Dịch Vụ:");

        txtMaDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaDV.setMinimumSize(new java.awt.Dimension(50, 35));

        lblDonViTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDonViTinh.setText("Đơn Vị Tính:");

        lblTrangThaiKD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTrangThaiKD.setText("Trạng Thái KD:");

        dchHSD.setDateFormatString("dd-MM-yyyy");
        dchHSD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dchHSD.setMinimumSize(new java.awt.Dimension(50, 33));

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGia.setMinimumSize(new java.awt.Dimension(50, 35));

        lblTenDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenDV.setText("Tên Dịch Vụ:");

        txtTenDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenDV.setMinimumSize(new java.awt.Dimension(50, 35));

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoLuong.setText("Số Lượng:");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoLuong.setMinimumSize(new java.awt.Dimension(50, 35));

        lblLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLoaiDV.setText("Loại Dịch Vụ:");

        cboLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboLoaiDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bia", "Nước Ngọt", "Đồ Ăn", "Khác" }));
        cboLoaiDV.setMinimumSize(new java.awt.Dimension(50, 35));

        lblGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGia.setText("Giá:");

        cboTrangThaiKD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboTrangThaiKD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Kinh Doanh", "Ngưng Kinh Doanh" }));
        cboTrangThaiKD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboTrangThaiKD.setMinimumSize(new java.awt.Dimension(50, 35));

        lblHanSuDung.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHanSuDung.setText("Hạn Sử Dụng:");

        txtDonViTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDonViTinh.setMinimumSize(new java.awt.Dimension(50, 35));


        javax.swing.GroupLayout pnlThongTinDVLayout = new javax.swing.GroupLayout(pnlThongTinDV);
        pnlThongTinDV.setLayout(pnlThongTinDVLayout);
        pnlThongTinDVLayout.setHorizontalGroup(
            pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinDVLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDonViTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThaiKD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(cboTrangThaiKD, 0, 390, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoaiDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboLoaiDV, 0, 390, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHanSuDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchHSD, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        pnlThongTinDVLayout.setVerticalGroup(
            pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinDVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlThongTinDVLayout.createSequentialGroup()
                        .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(dchHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlThongTinDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangThaiKD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTrangThaiKD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnCapNhat.setBackground(new Color(0,191,255));
        btnCapNhat.setIcon(new javax.swing.ImageIcon("icon/CN-icon.png")); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnXoa.setBackground(new Color(0,191,255));
        btnXoa.setIcon(new javax.swing.ImageIcon("icon/Xoa_icon.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnThem.setBackground(new Color(0,191,255));
        btnThem.setIcon(new javax.swing.ImageIcon("icon/Them_icon.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnXoaTrang.setBackground(new Color(0,191,255));
        btnXoaTrang.setIcon(new javax.swing.ImageIcon("icon/XT_icon.png")); // NOI18N
        btnXoaTrang.setText("Xóa Trắng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSuKienLayout = new javax.swing.GroupLayout(pnlSuKien);
        pnlSuKien.setLayout(pnlSuKienLayout);
        pnlSuKienLayout.setHorizontalGroup(
            pnlSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuKienLayout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        pnlSuKienLayout.setVerticalGroup(
            pnlSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuKienLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
        );

        pnlDanhSachDV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 20))); // NOI18N
        pnlDanhSachDV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá (VNĐ)", "Đơn Vị Tính", "Số Lượng", "Hạn Sử Dụng", "Trạng Thái KD", "Loại Dịch Vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDichVu.setRowHeight(30);
        tblDichVu.getTableHeader().setBackground(new Color(255, 127, 0));
        tblDichVu.setShowHorizontalLines(true);
        tblDichVu.setShowVerticalLines(true);
        scr.setViewportView(tblDichVu);

        javax.swing.GroupLayout pnlDanhSachDVLayout = new javax.swing.GroupLayout(pnlDanhSachDV);
        pnlDanhSachDV.setLayout(pnlDanhSachDVLayout);
        pnlDanhSachDVLayout.setHorizontalGroup(
            pnlDanhSachDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlDanhSachDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1569, Short.MAX_VALUE))
        );
        pnlDanhSachDVLayout.setVerticalGroup(
            pnlDanhSachDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(pnlDanhSachDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDanhSachDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlThongTinDV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSuKien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDanhSachDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
		tblDichVu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDichVu.getSelectedRow();
				txtMaDV.setText(model.getValueAt(row, 0).toString());
				txtTenDV.setText(model.getValueAt(row, 1).toString());
				txtGia.setText(model.getValueAt(row, 2).toString());
				txtDonViTinh.setText(model.getValueAt(row, 3).toString());
				if(!(model.getValueAt(row, 4).toString().equals(""))) {
					txtSoLuong.setText(model.getValueAt(row, 4).toString());
					dchHSD.setDate((java.util.Date) model.getValueAt(row, 5));
				}
				else {
					txtSoLuong.setText("");
					dchHSD.setDate(null);
				}
				cboTrangThaiKD.setSelectedItem(model.getValueAt(row, 6).toString());
				cboLoaiDV.setSelectedItem(model.getValueAt(row, 7).toString());
			}
		});
    }// </editor-fold>//GEN-END:initComponents


    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
		java.util.Date datetime = dchHSD.getDate();
    	if (txtMaDV.getText().equals("") || txtTenDV.getText().equals("") || txtGia.getText().equals("") ||
    			txtDonViTinh.getText().equals("")) {
			JLabel lbl1 = new JLabel("Vui lòng nhập đầy đủ thông tin!");
			lbl1.setFont(new Font("Arial", Font.PLAIN, 18));
    		JOptionPane.showMessageDialog(this, lbl1);
		} else {
	        if(validData()) {
				boolean tt = true;
				if(cboTrangThaiKD.getSelectedItem().equals("Ngưng Kinh Doanh"))
					tt = false;
				DichVu dv;
				if(txtSoLuong.getText().equals("") || datetime==null) {
					dv = new DichVu(txtMaDV.getText(), txtTenDV.getText(), Double.parseDouble(txtGia.getText()), txtDonViTinh.getText(), tt, new LoaiDichVu(loaiDV_DAO.getMaLoaiDVTheoTen(cboLoaiDV.getSelectedItem().toString())));
					if(dichVu_DAO.getAllDichVu().contains(dv)) {
						JLabel lbl2 = new JLabel("Không được thêm trùng mã dịch vụ");
						lbl2.setFont(new Font("Arial", Font.PLAIN, 18));
						JOptionPane.showMessageDialog(this, lbl2);
					} else {
			            dichVu_DAO.addDichVuKCoHSD(dv);
			            DocDuLieuDatabaseVaoTable();
			            xoaRongTextfields();
					}  
				}
				else {
					java.sql.Date ngayHH = new java.sql.Date(datetime.getTime());
					dv = new DichVu(txtMaDV.getText(), txtTenDV.getText(), Double.parseDouble(txtGia.getText()), txtDonViTinh.getText(), Integer.parseInt(txtSoLuong.getText()), ngayHH, tt, new LoaiDichVu(loaiDV_DAO.getMaLoaiDVTheoTen(cboLoaiDV.getSelectedItem().toString())));
					if(dichVu_DAO.getAllDichVu().contains(dv)) {
						JLabel lbl2 = new JLabel("Không được thêm trùng mã dịch vụ");
						lbl2.setFont(new Font("Arial", Font.PLAIN, 18));
						JOptionPane.showMessageDialog(this, lbl2);
					} else {
			            dichVu_DAO.addDichVu(dv);
			            DocDuLieuDatabaseVaoTable();
			            xoaRongTextfields();
					}  
				}
	        }
		}
    }//GEN-LAST:event_btnCapNhatActionPerformed
    
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
		int row = tblDichVu.getSelectedRow();
		if (row != -1) {
	    	java.util.Date datetime = dchHSD.getDate();
	    	if (txtMaDV.getText().equals("") || txtTenDV.getText().equals("") || txtGia.getText().equals("") ||
	    			txtDonViTinh.getText().equals("")) {
				JLabel lbl1 = new JLabel("Vui lòng nhập đầy đủ thông tin!");
				lbl1.setFont(new Font("Arial", Font.PLAIN, 18));
	    		JOptionPane.showMessageDialog(this, lbl1);
			} else {
		        if(validData()) {
					boolean tt = true;
					if(cboTrangThaiKD.getSelectedItem().equals("Ngưng Kinh Doanh"))
						tt = false;
					DichVu dv;
					if(txtSoLuong.getText().equals("") || datetime==null) {
						dv = new DichVu(txtMaDV.getText(), txtTenDV.getText(), Double.parseDouble(txtGia.getText()), txtDonViTinh.getText(), tt, new LoaiDichVu(loaiDV_DAO.getMaLoaiDVTheoTen(cboLoaiDV.getSelectedItem().toString())));
			            dichVu_DAO.updateDichVuKCoHSD(dv);
			            DocDuLieuDatabaseVaoTable();
			            xoaRongTextfields();
					}
					else {
						java.sql.Date ngayHH = new java.sql.Date(datetime.getTime());
			        	dv = new DichVu(txtMaDV.getText(), txtTenDV.getText(), Double.parseDouble(txtGia.getText()), txtDonViTinh.getText(), Integer.parseInt(txtSoLuong.getText()), ngayHH, tt, new LoaiDichVu(loaiDV_DAO.getMaLoaiDVTheoTen(cboLoaiDV.getSelectedItem().toString())));
				        dichVu_DAO.updateDichVu(dv);
				        DocDuLieuDatabaseVaoTable();
				        xoaRongTextfields();
					}
		        }
			}
		}else {
			JLabel lbl3 = new JLabel("Bạn chưa chọn dịch vụ cần cập nhật");
			lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(this, lbl3);
		}
    }//GEN-LAST:event_btnCapNhatActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
		int row = tblDichVu.getSelectedRow();
		if (row != -1) {
			JLabel lbl1 = new JLabel("Bạn có chắc muốn xóa không?");
			lbl1.setFont(new Font("Arial", Font.PLAIN, 18));
			int ask = JOptionPane.showConfirmDialog(this, lbl1, "Cảnh Báo!", JOptionPane.YES_NO_OPTION);
			if(ask == JOptionPane.YES_OPTION) {
		    	dichVu_DAO.deleteDichVu(txtMaDV.getText());
		        DocDuLieuDatabaseVaoTable();
				xoaRongTextfields();
				JLabel lbl2 = new JLabel("Xóa thành công");
				lbl2.setFont(new Font("Arial", Font.PLAIN, 18));
				JOptionPane.showMessageDialog(this, lbl2);
				if(row < dichVu_DAO.getAllDichVu().size() - 1) {
					selectedRow(row);
				} else if(dichVu_DAO.getAllDichVu().size() > 0) {
					row = 0;
					selectedRow(row);
				}
			}
		}else {
			JLabel lbl3 = new JLabel("Bạn chưa chọn dịch vụ cần xóa");
			lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(this, lbl3);
		}
    }//GEN-LAST:event_btnCapNhatActionPerformed
    
    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
    	xoaRongTextfields();
    }//GEN-LAST:event_btnCapNhatActionPerformed

	public void DocDuLieuDatabaseVaoTable() {
		model.setRowCount(0);
		List<DichVu> list = dichVu_DAO.getAllDichVu();
				for (DichVu dv : list) {	
					String tt = "Đang Kinh Doanh";
					if(dv.isTrangThaiKD()==false)
						tt="Ngưng Kinh Doanh";	
					if(dv.getSoLuong()==-1) {
						Object [] row = {dv.getMaDichVu(),dv.getTenDichVu(),Math.round(dv.getGia())
								,dv.getDonViTinh(),"","",tt,dv.getLoaiDichVu().getTenLoai()};
						model.addRow(row);
					}
					else {
						Object [] row = {dv.getMaDichVu(),dv.getTenDichVu(),Math.round(dv.getGia())
								,dv.getDonViTinh(),dv.getSoLuong(),dv.getHanSuDung(),tt,dv.getLoaiDichVu().getTenLoai()};
						model.addRow(row);
					}
				}
	}

	public void loadCBBLoaiDV(JComboBox<String> c) {
		c.removeAllItems();
		for (LoaiDichVu ldv : loaiDV_DAO.getAllLoaiDichVu()) {
			c.addItem(ldv.getTenLoai());
		}
	}
	private void xoaRongTextfields() {
        txtMaDV.setText(dichVu_DAO.getMaDV());
		txtTenDV.setText("");
		cboTrangThaiKD.setSelectedIndex(0);
		dchHSD.setDate(null);
		txtGia.setText("");
		txtDonViTinh.setText("");
		txtSoLuong.setText("");
		cboLoaiDV.setSelectedIndex(0);
	}
	private void selectedRow(int row) {
		if(row != -1) {
			tblDichVu.setRowSelectionInterval(row, row);
			tblDichVu.scrollRectToVisible(tblDichVu.getCellRect(row, row, true));
		}
	}
	private boolean validData() {
		String maDV = txtMaDV.getText().trim(), gia = txtGia.getText().trim(), sl = txtSoLuong.getText().trim(); 
		Date ngayHH = dchHSD.getDate();
		long millis=System.currentTimeMillis();
		
		if (!(maDV.length() > 0 && maDV.matches("DV\\d{3}"))) {
			JLabel lbl1 = new JLabel("Error: Mã nhân viên theo mẫu: DV + Dãy gồm 3 chữ số");
			lbl1.setFont(new Font("Arial", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(this, lbl1);
			txtMaDV.requestFocus();;
			return false;
		}
		if (gia.length() > 0) {
			try {
				double y = Double.parseDouble(gia);
				if (y <= 0) {
					JLabel lbl2 = new JLabel("Error: Giá phải lớn hơn 0.");
					lbl2.setFont(new Font("Arial", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(this, lbl2);
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JLabel lbl3 = new JLabel("Error: Giá phải nhập số.");
				lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
				JOptionPane.showMessageDialog(this, lbl3);
				txtGia.requestFocus();
				return false;
			}
		}
//		if (sl.length() > 0) {
//			try {
//				int y = Integer.parseInt(sl);
//				if (y <= 0) {
//					JLabel lbl2 = new JLabel("Error: Số lượng phải lớn hơn 0.");
//					lbl2.setFont(new Font("Arial", Font.PLAIN, 18));
//					JOptionPane.showMessageDialog(this, lbl2);
//					txtSoLuong.requestFocus();
//					return false;
//				}
//			} catch (NumberFormatException e) {
//				JLabel lbl3 = new JLabel("Error: Số lượng phải nhập số.");
//				lbl3.setFont(new Font("Arial", Font.PLAIN, 18));
//				JOptionPane.showMessageDialog(this, lbl3);
//				txtSoLuong.requestFocus();
//				return false;
//			}
//		}
//		if(ngayHH.before(new java.util.Date(millis))){
//			JLabel lbl4 = new JLabel("Error: Hạn sử dụng phải sau ngày hiện tại");
//			lbl4.setFont(new Font("Arial", Font.PLAIN, 18));
//			JOptionPane.showMessageDialog(this, lbl4);
//			return false;
//		}
		return true;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JComboBox<String> cboTrangThaiKD;
    private javax.swing.JComboBox<String> cboLoaiDV;
    private com.toedter.calendar.JDateChooser dchHSD;
    private javax.swing.JLabel lblDonViTinh;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblHanSuDung;
    private javax.swing.JLabel lblLoaiDV;
    private javax.swing.JLabel lblMaDV;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenDV;
    private javax.swing.JLabel lblTrangThaiKD;
    private javax.swing.JPanel pnlDanhSachDV;
    private javax.swing.JPanel pnlSuKien;
    private javax.swing.JPanel pnlThongTinDV;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
}