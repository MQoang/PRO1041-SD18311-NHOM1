/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.dieuKienSevicer;
import Service.phieuGiamGia;
import Service.phieuGiamGiaChiTietSevicer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import model.DieuKien;
import model.PhieuGiamGiaChiTiet;
import model.PhieuGiamGiaSevicer;

/**
 *
 * @author Quanglm
 */
public class ViewDanhSachSanPham extends javax.swing.JFrame {

    private List<phieuGiamGia> list = new ArrayList<>();
    private List<PhieuGiamGiaChiTiet> lists = new ArrayList<>();
    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModel2 = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
    private PhieuGiamGiaSevicer pgg = new PhieuGiamGiaSevicer();
    private phieuGiamGiaChiTietSevicer pgg2 = new phieuGiamGiaChiTietSevicer();
    private List<DieuKien> listsss = new ArrayList<>();
    private DefaultTableModel tblModel123 = new DefaultTableModel();
    private dieuKienSevicer pgg2123 = new dieuKienSevicer();

    /**
     * Creates new form ViewDanhSachSanPham
     */
    public ViewDanhSachSanPham() {
        initComponents();
        list = pgg.getAll();
        lists = pgg2.getAll();
        listsss = pgg2123.getAll();
        tblModel123 = (DefaultTableModel) fromPhieuGiam2.getModel();
        tblModel = (DefaultTableModel) fromPhieuGiam.getModel();
        tblModel2 = (DefaultTableModel) fromPhieuGiam1.getModel();
        showData();
        showDataa();
        showData123();
    }

    public void showData() {
        tblModel.setRowCount(0);
        for (phieuGiamGia pg : list) {
            tblModel.addRow(new Object[]{
                pg.getIdPhieu(), pg.getTenPhieu(), pg.getNgayBatDau(), pg.getNgayKetThuc(), pg.getGiaTriGiam(), pg.getTrangThai()
            });
        }
    }

    public void showData123() {
        tblModel123.setRowCount(0);
        for (DieuKien pg : listsss) {
            tblModel123.addRow(new Object[]{
                pg.getIdDieuKien(), pg.getIdPhieu(), pg.getNgayHetHan(), pg.getGiaTriTrietKhau(), pg.getNghiChu()
            });
        }
    }

    public void showDataa() {
        tblModel2.setRowCount(0);
        for (PhieuGiamGiaChiTiet pgct : lists) {
            tblModel2.addRow(new Object[]{
                pgct.getIdPhieuChiTiet(), pgct.getIdPhieu(), pgct.getThoiGianBatDau(), pgct.getGiaGiam(),});
        }
    }

    public void getTablee(int index) {
        PhieuGiamGiaChiTiet pgct = lists.get(index);
        txtIDCT1.setText(pgct.getIdPhieuChiTiet());
        txtIDphieucc.setText(pgct.getIdPhieu());
        txtGiaGiam2.setText(pgct.getGiaGiam());
        txtBatDau25.setText(pgct.getThoiGianBatDau());
    }

    public PhieuGiamGiaChiTiet getFormm() {
        PhieuGiamGiaChiTiet pgct = new PhieuGiamGiaChiTiet();
        String idct = txtIDCT1.getText();
        String id = txtIDphieucc.getText();
        String time = txtBATDau.getText();
        String giaGiam = txtGiaGiam2.getText();

        pgct.setGiaGiam(giaGiam);
        pgct.setIdPhieu(id);
        pgct.setIdPhieuChiTiet(idct);
        pgct.setThoiGianBatDau(time);
        return pgct;
    }

    private phieuGiamGia getForm() {
        phieuGiamGia pg = new phieuGiamGia();
        String ma = txtID.getText();
        String name = txtname.getText();
        String batdau = txtBATDau.getText();
        String ketthuc = txtKetTHuc.getText();
        String giaTriGiam = txtFRESEN.getText();

        Boolean trangThai = rdoON.isSelected();
        if (trangThai == true) {
            rdoON.getSelectedIcon();
        } else {
            rdoOFF.getSelectedIcon();
        }

        pg.setIdPhieu(ma);
        pg.setTenPhieu(name);
        pg.setNgayBatDau(batdau);
        pg.setNgayKetThuc(ketthuc);
        pg.setGiaTriGiam(Integer.valueOf(giaTriGiam));
        pg.setTrangThai(trangThai);

        return pg;
    }

    public void getTable(int index) {
        phieuGiamGia pg = list.get(index);
        txtBATDau.setText(pg.getNgayBatDau());
        txtKetTHuc.setText(pg.getNgayKetThuc());
        txtname.setText(pg.getTenPhieu());
        txtID.setText(pg.getIdPhieu());
        txtFRESEN.setText(String.valueOf(pg.getGiaTriGiam()));

        Boolean trangThai = rdoON.isSelected();
        if (pg.getTrangThai() == true) {
            rdoON.setSelected(true);
        } else {
            rdoOFF.setSelected(true);
        }

    }

    private DieuKien getFormm123() {
        DieuKien pgct = new DieuKien();
        String iddk = txtIDdk.getText();
        String id = txtIDppkd.getText();
        String ngayHetHan = txtHetHannnnn.getText();
        String giaTriTrietKhau = txtGiatriKhau.getText();
        String ghiChu = txtNote.getText();

        pgct.setIdDieuKien(iddk);
        pgct.setIdPhieu(id);
        pgct.setNgayHetHan(ngayHetHan);
        pgct.setNghiChu(ghiChu);
        return pgct;
    }
    
    public void getTabaleDk(int index){
        DieuKien dk = listsss.get(index);
        txtIDdk.setText(dk.getIdDieuKien());
        txtIDppkd.setText(dk.getIdPhieu());
        txtGiatriKhau.setText(String.valueOf(dk.getGiaTriTrietKhau()));
        txtNote.setText(dk.getNghiChu());
         txtHetHannnnn.setText(dk.getNgayHetHan());
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        btnXoa2 = new javax.swing.JButton();
        btnThem2 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        txtFRESEN = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnSreach = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtBATDau = new javax.swing.JTextField();
        txtKetTHuc = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        rdoON = new javax.swing.JRadioButton();
        rdoOFF = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        fromPhieuGiam1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtIDCT1 = new javax.swing.JTextField();
        txtIDphieucc = new javax.swing.JTextField();
        txtBatDau25 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtGiaGiam2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fromPhieuGiam = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtIDdk = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtIDppkd = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtGiatriKhau = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        txtHetHannnnn = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        fromPhieuGiam2 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 51));

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/giỏ hàng.png"))); // NOI18N
        jButton1.setText("Bán Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sản phẩm.png"))); // NOI18N
        jButton2.setText("Sản Phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hóa đơn.png"))); // NOI18N
        jButton3.setText("Hóa Đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 204, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khuyenmai.png"))); // NOI18N
        jButton4.setText("Khuyến Mại");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Khachhang.png"))); // NOI18N
        jButton5.setText("Nhân Viên");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 204, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png"))); // NOI18N
        jButton6.setText("Khách Hàng");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 204, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thong ke.png"))); // NOI18N
        jButton7.setText("Thống Kê");
        jButton7.setToolTipText("");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 204, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/out.png"))); // NOI18N
        jButton8.setText("Thoát");
        jButton8.setToolTipText("");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 204, 0));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-laptop-100.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("NHÓM 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));

        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-trash-20.png"))); // NOI18N
        btnXoa2.setText("DELETE");
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });

        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/giỏ hàng.png"))); // NOI18N
        btnThem2.setText("ADD");
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hóa đơn.png"))); // NOI18N
        btnUpdate1.setText("UPDATE");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Tìm Kiếm");

        btnSreach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-20.png"))); // NOI18N
        btnSreach.setText("Tìm Kiếm");
        btnSreach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSreachActionPerformed(evt);
            }
        });

        jButton10.setText("Thoát");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Hiện Dữ Liệu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Tên Phiếu Giảm Giá ");

        jLabel24.setText("Ngày Bắt Đầu");

        jLabel25.setText("Ngày Kết Thúc");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-notes-24.png"))); // NOI18N
        jButton12.setText("SAVE");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Mã Phiếu Giảm Giá");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Phần Trăm Giảm Giá");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        buttonGroup1.add(rdoON);
        rdoON.setText("Đang Hoạt Động");

        buttonGroup1.add(rdoOFF);
        rdoOFF.setText("Dừng Hoạt Động");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-login-32.png"))); // NOI18N
        jButton19.setText("Trạng Thái");

        fromPhieuGiam1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Phiếu Chi Tiết", "ID Phiếu", "Ngày Bắt Đầu", "Giá Giảm"
            }
        ));
        fromPhieuGiam1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromPhieuGiam1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(fromPhieuGiam1);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel42.setText("Mã Phiếu Chi Tiết");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setText("Giá Giảm");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel41.setText("Ngày Bắt Đầu");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel44.setText("ID Phiếu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDCT1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtBatDau25)
                            .addComponent(txtGiaGiam2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(txtIDphieucc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtIDCT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtIDphieucc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtBatDau25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtGiaGiam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        fromPhieuGiam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Phiếu", "Tên Phiếu", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Phần Trăm Giảm", "Trạng Thái"
            }
        ));
        fromPhieuGiam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromPhieuGiamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(fromPhieuGiam);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/out.png"))); // NOI18N
        jButton13.setText("Thoát");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setText("Mã Điều Kiện");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel45.setText("Mã Phiếu Giảm Giá");

        txtIDppkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDppkdActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel46.setText("Giá Trị Triết Khấu ");

        jLabel47.setText("Nghi Chú");

        jLabel48.setText("Ngày Hết Hạn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDdk, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtIDppkd)
                            .addComponent(txtGiatriKhau)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(txtHetHannnnn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtIDdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtIDppkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtGiatriKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNote, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txtHetHannnnn))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        fromPhieuGiam2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Phiếu Điều Kiện", "ID Phiếu Giảm Giá", "Ngày Hết Hạn", "Giá Triết Khấu", "Nghi Chú"
            }
        ));
        fromPhieuGiam2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromPhieuGiam2MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(fromPhieuGiam2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/giỏ hàng.png"))); // NOI18N
        jButton14.setText("Thêm");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sản phẩm.png"))); // NOI18N
        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-trash-20.png"))); // NOI18N
        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(389, 389, 389)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFRESEN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(44, 44, 44)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnSreach)))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(rdoON, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(btnThem2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnUpdate1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton12)
                                        .addGap(4, 4, 4)
                                        .addComponent(jButton13))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(txtBATDau, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKetTHuc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48))
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                                .addGap(22, 22, 22)))))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jButton10))
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSreach))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel23)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFRESEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15)
                            .addComponent(jButton14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBATDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKetTHuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton19)
                                    .addComponent(rdoON)
                                    .addComponent(rdoOFF))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem2)
                                        .addComponent(btnUpdate1)
                                        .addComponent(jButton13)
                                        .addComponent(btnXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(4, 4, 4))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("PHIẾU GIẢM GIÁ", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fromPhieuGiam2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromPhieuGiam2MouseClicked
        // TODO add your handling code here:
        int row = fromPhieuGiam2.getSelectedRow();
        getTabaleDk(row);
    }//GEN-LAST:event_fromPhieuGiam2MouseClicked

    private void txtIDppkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDppkdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDppkdActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void fromPhieuGiamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromPhieuGiamMouseClicked
        // TODO add your handling code here:
        int index = fromPhieuGiam.getSelectedRow();
        getTable(index);
    }//GEN-LAST:event_fromPhieuGiamMouseClicked

    private void fromPhieuGiam1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromPhieuGiam1MouseClicked
        // TODO add your handling code here:
        int row = fromPhieuGiam1.getSelectedRow();
        getTablee(row);
    }//GEN-LAST:event_fromPhieuGiam1MouseClicked

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnSreachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSreachActionPerformed
        // TODO add your handling code here:
        String timKiem = txtTimKiem.getText().trim();
        list = pgg.timKiem(Integer.valueOf(timKiem));
        showData();
    }//GEN-LAST:event_btnSreachActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed

        int row = fromPhieuGiam.getSelectedRow();
        pgg.suaNV(getForm(), list.get(row).getIdPhieu());
        list = pgg.getAll();
        showData();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed

        pgg.themNV(getForm());
        list = pgg.getAll();
        showData();
    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed

        int row = fromPhieuGiam.getSelectedRow();
        pgg.xoaPhieu(list.get(row).getIdPhieu());
        list = pgg.getAll();
        showData();
    }//GEN-LAST:event_btnXoa2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         pgg2.add(getFormm());
        lists = pgg2.getAll();
        showDataa();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
         int row = fromPhieuGiam1.getSelectedRow();
        pgg2.update(getFormm(), lists.get(row).getIdPhieuChiTiet());
        lists = pgg2.getAll();
        showDataa();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        int row = fromPhieuGiam1.getSelectedRow();
        pgg2.delete(lists.get(row).getIdPhieuChiTiet());
        lists = pgg2.getAll();
        showDataa();
    }//GEN-LAST:event_jButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDanhSachSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDanhSachSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDanhSachSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDanhSachSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDanhSachSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSreach;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnXoa2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTable fromPhieuGiam;
    private javax.swing.JTable fromPhieuGiam1;
    private javax.swing.JTable fromPhieuGiam2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoOFF;
    private javax.swing.JRadioButton rdoON;
    private javax.swing.JTextField txtBATDau;
    private javax.swing.JTextField txtBatDau25;
    private javax.swing.JTextField txtFRESEN;
    private javax.swing.JTextField txtGiaGiam2;
    private javax.swing.JTextField txtGiatriKhau;
    private javax.swing.JTextField txtHetHannnnn;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDCT1;
    private javax.swing.JTextField txtIDdk;
    private javax.swing.JTextField txtIDphieucc;
    private javax.swing.JTextField txtIDppkd;
    private javax.swing.JTextField txtKetTHuc;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
