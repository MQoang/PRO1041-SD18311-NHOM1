/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.HoaDon;
import Model.PhieuDoi;
import Service.HoaDonService;
import Service.PhieuDoiService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class GiaoDienPhieuDoi extends javax.swing.JFrame {

    ArrayList<HoaDon> listHD = new ArrayList<>();
    HoaDonService svHD = new HoaDonService();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();

    ArrayList<PhieuDoi> listPD = new ArrayList<>();
    PhieuDoiService svPD = new PhieuDoiService();

    /**
     * Creates new form GiaoDienPhieuDoi
     */
    public GiaoDienPhieuDoi() {
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        listHD = svHD.getAll();
        showDataHD(listHD);
        dtm1 = (DefaultTableModel) tblDanhSachDoi.getModel();
        listPD = svPD.getAll();
        showDataPD(listPD);

    }

    public void showDataHD(ArrayList<HoaDon> i) {
        dtm.setRowCount(0);
        for (HoaDon hd : i) {
            dtm.addRow(new Object[]{
                hd.getMaHoaDon(),
                hd.getTenSanPham(),
                hd.getTenKhachHang(),
                hd.getNgayMua(),
                hd.getGiaBan()

            });
        }
    }
    
    public void fillDataHD(HoaDon hd) {
        if (hd.getTenSanPham().equalsIgnoreCase("Laptop Acer Nitro 5 AN515-58-5046")) {
            cboTenSanPham.setSelectedIndex(0);
        }
        else if (hd.getTenSanPham().equalsIgnoreCase("Laptop Gaming ASUS Bravo 15 B7ED-010VN")) {
            cboTenSanPham.setSelectedIndex(1);
        } else if (hd.getTenSanPham().equalsIgnoreCase("Laptop Gaming MSI Bravo 15 B7ED-010VN")) {
            cboTenSanPham.setSelectedIndex(2);
        } else if (hd.getTenSanPham().equalsIgnoreCase("HP Pavilion 15-CW")) {
            cboTenSanPham.setSelectedIndex(3);
        } 
        txtTenKhachHang.setText(hd.getTenKhachHang());
        txtNgayMua.setText(hd.getNgayMua() + "");
        txtGiaBan.setText(hd.getGiaBan() + "");
    }

    public void showDataPD(ArrayList<PhieuDoi> i) {
        dtm1.setRowCount(0);
        for (PhieuDoi pd : i) {
            dtm1.addRow(new Object[]{
                pd.getMaPhieuDoi(),
                pd.getTenKhachHang(),
                pd.getTenSanPham(),
                pd.getGiaBan(),
                pd.getNgayDoi(),
                pd.getLyDoDoi(),
                pd.getLyDoDoiChiTiet()
            });
        }
    }

    public void fillDataPD(PhieuDoi pd) {
        txtMaPhieuDoi.setText(pd.getMaPhieuDoi() + "");
        txtLyDoChiTiet.setText(pd.getLyDoDoiChiTiet());
        switch (pd.getLyDoDoi().toLowerCase()) {
        case "lỗi máy":
            cboLyDoDoi.setSelectedIndex(0);
            break;
        case "quá đắt":
            cboLyDoDoi.setSelectedIndex(1);
            break;
        case "đổi màu khác":
            cboLyDoDoi.setSelectedIndex(2);
            break;
        case "đổi máy khác":
            cboLyDoDoi.setSelectedIndex(3);
            break;
        default:
            // Handle default case if necessary
            break;
    }
        if (pd.getTenSanPham().equalsIgnoreCase("Laptop Acer Nitro 5 AN515-58-5046")) {
            cboTenSanPham.setSelectedIndex(0);
        } else if (pd.getTenSanPham().equalsIgnoreCase("Laptop Gaming ASUS Bravo 15 B7ED-010VN")) {
            cboTenSanPham.setSelectedIndex(1);
        } else if (pd.getTenSanPham().equalsIgnoreCase("Laptop Gaming MSI Bravo 15 B7ED-010VN")) {
            cboTenSanPham.setSelectedIndex(2);
        } else if (pd.getTenSanPham().equalsIgnoreCase("HP Pavilion 15-CW")) {
            cboTenSanPham.setSelectedIndex(3);
        }
        txtNgayDoi.setText(pd.getNgayDoi() + "");
        txtTenKhachHang.setText(pd.getTenKhachHang());
        txtGiaBan.setText(pd.getGiaBan() + "");
        
    }

    public PhieuDoi getData() {
        String maPhieuDoi = txtMaPhieuDoi.getText().trim();
        String tenKhachHang = txtTenKhachHang.getText().trim();
        String ngayDoi = txtNgayDoi.getText().trim();
        String Lydo = cboLyDoDoi.getSelectedItem().toString();
        String LydoChiTiet = txtLyDoChiTiet.getText().trim();
        String giaban = txtGiaBan.getText().trim();
        String tenSanPham = cboTenSanPham.getSelectedItem().toString();
        BigDecimal giaBan;
        if (maPhieuDoi.isEmpty() || tenKhachHang.isEmpty() || ngayDoi.isEmpty() || tenSanPham.isEmpty() || giaban.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return null;
        }
        Date NgayDoi1;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            NgayDoi1 = dateFormat.parse(ngayDoi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày đổi không đúng định dạng (yyyy-MM-dd)");
            return null;
        }
        
        try {
            giaBan = new BigDecimal(giaban);
            if (giaBan.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0");
            return null;
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số");
            return null;
        }
        PhieuDoi pd = new PhieuDoi(maPhieuDoi, tenKhachHang, tenSanPham, giaBan, NgayDoi1, Lydo, LydoChiTiet);
        return pd;
    }

    public void Cleartxt() {
        txtGiaBan.setText("");
        txtLyDoChiTiet.setText("");
        txtMaPhieuDoi.setText("");
        txtNgayDoi.setText("");
        txtNgayMua.setText("");
        txtTenKhachHang.setText("");
        cboLyDoDoi.setSelectedIndex(0);
        listHD = svHD.getAll();
        showDataHD(listHD);
        listPD = svPD.getAll();
        showDataPD(listPD);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNgayMua = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaPhieuDoi = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLyDoChiTiet = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtNgayDoi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboLyDoDoi = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnsapXepTheoTen = new javax.swing.JButton();
        cboTenSanPham = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachDoi = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Phiếu đổi");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên sản phẩm", "Tên khách hàng", "Ngày mua ", "Giá bán"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Tên sản phẩm");

        jLabel4.setText("Giá bán");

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày mua");

        jLabel9.setText("Mã Phiếu đổi");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày đổi");

        jLabel5.setText("Lý do chi tiết");

        txtLyDoChiTiet.setColumns(20);
        txtLyDoChiTiet.setRows(5);
        jScrollPane3.setViewportView(txtLyDoChiTiet);

        jLabel12.setText("Tên khách hàng");

        jLabel13.setText("Lý do đổi");

        cboLyDoDoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lỗi máy", "Quá đắt", "Đổi màu khác", "Đổi máy khác" }));

        btnThem.setText("Đổi");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnsapXepTheoTen.setText("Sắp xếp theo Tên");
        btnsapXepTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapXepTheoTenActionPerformed(evt);
            }
        });

        cboTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop Acer Nitro 5 AN515-58-5046", "Laptop Gaming ASUS Bravo 15 B7ED-010VN", "Laptop Gaming MSI Bravo 15 B7ED-010VN", "HP Pavilion 15-CW" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboLyDoDoi, 0, 287, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtNgayDoi, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtNgayMua, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(txtGiaBan)
                            .addComponent(txtTenKhachHang)
                            .addComponent(txtMaPhieuDoi)
                            .addComponent(cboTenSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnThem)
                        .addGap(29, 29, 29)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnsapXepTheoTen)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaPhieuDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cboLyDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(jButton4))
                .addGap(30, 30, 30)
                .addComponent(btnsapXepTheoTen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDanhSachDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu đổi", "Tên khách hàng", "Tên sản phẩm", "Giá bán", "Ngày đổi", "Lý do đổi", "Lý do đổi chi tiết"
            }
        ));
        tblDanhSachDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachDoiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachDoi);

        jLabel10.setText("Danh sách đổi");

        jLabel11.setText("Hóa đơn");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel11))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int Vitri = tblHoaDon.getSelectedRow();
        HoaDon hd = listHD.get(Vitri);
        fillDataHD(hd);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        boolean ThemPD = svPD.ThemPD(getData());
        listPD = svPD.getAll();
        showDataPD(listPD);
        if (ThemPD) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int Vitri = tblDanhSachDoi.getSelectedRow();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (check != JOptionPane.YES_OPTION) {
            return;
        }
        boolean XoaPD = svPD.XoaPhieuDoi(listPD.get(Vitri).getMaPhieuDoi() + "");
        listPD = svPD.getAll();
        showDataPD(listPD);
        if (XoaPD) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int Vitri = tblDanhSachDoi.getSelectedRow();
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn Sửa không");
        if (check != JOptionPane.YES_OPTION) {
            return;
        }
        boolean SuaPD = svPD.SuaPD(getData(), listPD.get(Vitri).getMaPhieuDoi() + "");
        listPD = svPD.getAll();
        showDataPD(listPD);
        if (SuaPD) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDanhSachDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachDoiMouseClicked
        int Vitri = tblDanhSachDoi.getSelectedRow();
        PhieuDoi pd = listPD.get(Vitri);
        fillDataPD(pd);
    }//GEN-LAST:event_tblDanhSachDoiMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Cleartxt();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            String ma = txtTimKiem.getText();
            String ten = txtTimKiem.getText();
            listHD = (ArrayList<HoaDon>) svHD.search(ma, ten);
            showDataHD(listHD);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnsapXepTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapXepTheoTenActionPerformed
//        svPD.sapXep();
        listPD = svPD.sapXep();
        showDataPD(listPD);
    }//GEN-LAST:event_btnsapXepTheoTenActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienPhieuDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienPhieuDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienPhieuDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienPhieuDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienPhieuDoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnsapXepTheoTen;
    private javax.swing.JComboBox<String> cboLyDoDoi;
    private javax.swing.JComboBox<String> cboTenSanPham;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDanhSachDoi;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextArea txtLyDoChiTiet;
    private javax.swing.JTextField txtMaPhieuDoi;
    private javax.swing.JTextField txtNgayDoi;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
