/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.BienThe;
import model.IMEI;
import model.SanPham;
import service.BienTheService;
import service.MaIMEIService;
import service.SanPhamService;

/**
 *
 * @author Quanglm
 */
public class viewSanPham extends javax.swing.JFrame {

    private SanPhamService serviceSanPham = new SanPhamService();
    private List<SanPham> listSanPham = new ArrayList<>();
    private DefaultTableModel modelSanPham = new DefaultTableModel();
    private DefaultTableModel modelBienThe = new DefaultTableModel();
    private BienTheService serviceBienThe = new BienTheService();
    private List<BienThe> listBienThe = new ArrayList<>();
    private MaIMEIService serviceMaIMEI = new MaIMEIService();
    private List<IMEI> listMaIMEI = new ArrayList<>();
    private DefaultTableModel modelMaIMEI = new DefaultTableModel();

    public viewSanPham() {
        initComponents();
        listSanPham = serviceSanPham.getAll();
        modelSanPham = (DefaultTableModel) tblViewSp.getModel();
        showTableSanPham();
        listBienThe = serviceBienThe.getAll();
        modelBienThe = (DefaultTableModel) tblVieBienThe.getModel();
        showTableBT();
        listMaIMEI = serviceMaIMEI.getAll();
        modelMaIMEI = (DefaultTableModel) tblIMEI.getModel();
        showTableMaIMEI();
    }

    public void showTableSanPham() {
        modelSanPham.setRowCount(0);
        for (SanPham sp : listSanPham) {
            modelSanPham.addRow(new Object[]{
                sp.getMaSanPham(), sp.getTenSanPham(), sp.getHeDieuHanh(), sp.getManHinh(), sp.getCanNang(), sp.getTonKho()
            });
        }
    }

    public void showTableBT() {
        modelBienThe.setRowCount(0);
        for (BienThe bt : listBienThe) {
            modelBienThe.addRow(new Object[]{
                bt.getMaBienThe(), bt.getMaSanPham(), bt.getMauSac(), bt.getCPU(), bt.getRam(), bt.getCard(), bt.getoCung(), bt.getGiaBan()
            });
        }
    }
    
    public void showTableMaIMEI(){
        modelMaIMEI.setRowCount(0);
        for (IMEI im : listMaIMEI) {
            modelMaIMEI.addRow(new Object[]{
                im.getMaBienThe(),im.getMaIMEI()
            });
        }
    }

    public void showDetalSanPham(int index) {
        
        SanPham sp = listSanPham.get(index);
        
        txtMaSP.setText(sp.getMaSanPham());
        txtMaSp1.setText(sp.getMaSanPham());
        txtTenSP.setText(sp.getTenSanPham());
        if(sp.getHeDieuHanh() == "WinDows"){
            cboHeDieuHanh.setSelectedItem("WinDows");
        }
        else if(sp.getHeDieuHanh() == "MacOS"){
            cboHeDieuHanh.setSelectedItem("MacOS");
        }
        if(sp.getHeDieuHanh() == "Linux"){
            cboHeDieuHanh.setSelectedItem("Linux");
        }
        txtManHinh.setText(sp.getManHinh());
        txtCanNang.setText(sp.getCanNang());
        txtTonKho.setText(sp.getTonKho());
        
                
        
    }

    public void showDetalBT(int index) {
        BienThe bt = listBienThe.get(index);
        txtCPU.setText(bt.getCPU());
        txtCard.setText(bt.getCard());
        txtGiaBan.setText(String.valueOf(bt.getGiaBan()) );
        txtMaBienThe.setText(bt.getMaBienThe());
        txtMaSp1.setText(bt.getMaSanPham());
        txtMauSac.setText(bt.getMauSac());
        txtOCung.setText(bt.getoCung());
        txtRam.setText(bt.getRam());
        

    }
    
    public void showDetalIMEI(int index){
        IMEI im = listMaIMEI.get(index);
        txtMaBienThe.setText(im.getMaBienThe());
        txtMaIMEI.setText(im.getMaIMEI());
    }

    private SanPham getFormSanPham() {
        SanPham sp = new SanPham();
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        String heDieuHanh = null;
        if (cboHeDieuHanh.getSelectedItem() == "WinDows") {
            heDieuHanh = "WinDows";
        }
        if (cboHeDieuHanh.getSelectedItem() == "MacOS") {
            heDieuHanh = "MacOS";
        }
        if (cboHeDieuHanh.getSelectedItem() == "Linux") {
            heDieuHanh = "Linux";
        }
        String manHinh = txtManHinh.getText();
        String canNang = txtCanNang.getText();
        String tonKho = txtTonKho.getText();

        sp.setMaSanPham(maSP);
        sp.setTenSanPham(tenSP);
        sp.setHeDieuHanh(heDieuHanh);
        sp.setManHinh(manHinh);
        sp.setCanNang(canNang);
        sp.setTonKho(tonKho);
        return sp;
    }

    private BienThe getFormBT() {
        BienThe bt = new BienThe();
        String soLuongMay = txtSoLuongMay.getText();
        String CPU = txtCPU.getText();
        String card = txtCard.getText();
        
        BigDecimal giaBan = new BigDecimal(txtGiaBan.getText());
        String maBienThe = txtMaBienThe.getText();
        String maSp = txtMaSp1.getText();
        String mauSac = txtMauSac.getText();
        String oCung = txtOCung.getText();
        String ram = txtRam.getText();

        bt.setCPU(CPU);
        bt.setCard(card);
        bt.setGiaBan(giaBan);
        bt.setMaBienThe(maBienThe);
        bt.setMaSanPham(maSp);
        bt.setMauSac(mauSac);
        bt.setRam(ram);
        bt.setoCung(oCung);
        
        return bt;
    }
    private IMEI getFormIMEI(){
        IMEI im = new IMEI();
        String iMEI = txtMaIMEI.getText();
        String maBT = txtMaBienThe.getText();
        im.setMaIMEI(iMEI);
        im.setMaBienThe(maBT);
        
        return im;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        txtManHinh = new javax.swing.JTextField();
        txtCanNang = new javax.swing.JTextField();
        txtFindByID = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        cboHeDieuHanh = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        txtTonKho = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewSp = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtMaSp1 = new javax.swing.JTextField();
        txtMauSac = new javax.swing.JTextField();
        txtCPU = new javax.swing.JTextField();
        txtRam = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        txtMaBienThe = new javax.swing.JTextField();
        txtCard = new javax.swing.JTextField();
        txtOCung = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtFind = new javax.swing.JTextField();
        txtSoLuongMay = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVieBienThe = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        txtMaIMEI = new javax.swing.JTextField();
        btnAdd1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblIMEI = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jPanel13.setBackground(new java.awt.Color(255, 204, 0));
        jPanel13.setForeground(new java.awt.Color(255, 255, 51));

        jButton10.setBackground(new java.awt.Color(255, 204, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/giỏ hàng.png"))); // NOI18N
        jButton10.setText("Bán Hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 204, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sản phẩm.png"))); // NOI18N
        jButton11.setText("Sản Phẩm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 204, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hóa đơn.png"))); // NOI18N
        jButton12.setText("Hóa Đơn");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 204, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khuyenmai.png"))); // NOI18N
        jButton13.setText("Khuyến Mại");
        jButton13.setToolTipText("");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 204, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Khachhang.png"))); // NOI18N
        jButton14.setText("Nhân Viên");
        jButton14.setToolTipText("");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 204, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png"))); // NOI18N
        jButton15.setText("Khách Hàng");
        jButton15.setToolTipText("");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 204, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thong ke.png"))); // NOI18N
        jButton16.setText("Thống Kê");
        jButton16.setToolTipText("");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(255, 204, 0));
        jButton17.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/out.png"))); // NOI18N
        jButton17.setText("Thoát");
        jButton17.setToolTipText("");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel22.setText("NHÓM 2");

        jButton18.setBackground(new java.awt.Color(255, 204, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-exchange-24.png"))); // NOI18N
        jButton18.setText("Phiếu Đổi");
        jButton18.setToolTipText("");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 204, 0));
        jButton19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-notes-24.png"))); // NOI18N
        jButton19.setText("Phiếu Giao Hàng");
        jButton19.setToolTipText("");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-laptop-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel47.setText("Mã Sản Phẩm:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel48.setText("Tên Sản Phẩm:");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel49.setText("Tìm Kiếm:");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel50.setText("Hệ Điều Hành:");

        btnAdd.setBackground(new java.awt.Color(255, 255, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddbtnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatebtnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletebtnDeleteActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel51.setText("Màn Hình:");

        txtFindByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindByIDtxtFindNameActionPerformed(evt);
            }
        });
        txtFindByID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindByIDtxtFindNameKeyTyped(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel52.setText("Cân Nặng:");

        cboHeDieuHanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WinDows", "MacOS", "Linux" }));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel53.setText("Tồn Kho");

        tblViewSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Hệ Điều Hành", "Màn Hình", "Cân Nặng", "Số Lượng Máy"
            }
        ));
        tblViewSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewSpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblViewSpMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblViewSpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblViewSpMouseReleased(evt);
            }
        });
        tblViewSp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblViewSpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblViewSpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblViewSpKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewSp);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(btnUpdate)
                                        .addGap(108, 108, 108))))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFindByID, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(txtFindByID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel50)
                        .addComponent(cboHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnDelete)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel23.setText("Mã Biến Thể:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel24.setText("Mã Sản phẩm:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel25.setText("Màu Sắc:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel26.setText("CPU:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel27.setText("RAM:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel28.setText("CARD:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel29.setText("Ổ Cứng:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel30.setText("Giá Bán:");

        txtMaSp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSp1ActionPerformed(evt);
            }
        });

        txtMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMauSacActionPerformed(evt);
            }
        });

        txtCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPUActionPerformed(evt);
            }
        });

        txtRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRamActionPerformed(evt);
            }
        });

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThem1.setBackground(new java.awt.Color(255, 255, 51));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(255, 255, 51));
        btnSua1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(255, 255, 51));
        btnXoa1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnThem1)
                .addGap(18, 18, 18)
                .addComponent(btnSua1)
                .addGap(18, 18, 18)
                .addComponent(btnXoa1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtMaBienThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBienTheActionPerformed(evt);
            }
        });

        txtCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardActionPerformed(evt);
            }
        });

        txtOCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOCungActionPerformed(evt);
            }
        });

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindKeyTyped(evt);
            }
        });

        txtSoLuongMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongMayActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel33.setText("Số Lượng Máy");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel35.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel28)
                                .addComponent(jLabel26)
                                .addComponent(jLabel27)
                                .addComponent(jLabel30))
                            .addGap(61, 61, 61))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtGiaBan)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtOCung, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaBienThe, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongMay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMaBienThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        tblVieBienThe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã BT", "Mã SP", "Màu Sắc", "CPU", "RAM", "CARD", "Ổ Cứng", "Giá Bán", "Số Máy"
            }
        ));
        tblVieBienThe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVieBienTheMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVieBienThe);

        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel54.setText("Mã IMEI");

        btnAdd1.setBackground(new java.awt.Color(255, 255, 0));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1btnAddActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(255, 255, 0));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1btnDeleteActionPerformed(evt);
            }
        });

        tblIMEI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã BT", "Mã IMEI"
            }
        ));
        tblIMEI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIMEIMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblIMEI);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnDelete1)
                                .addGap(38, 38, 38)
                                .addComponent(btnUpdate1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(txtMaIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtMaIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnDelete1)
                    .addComponent(btnUpdate1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnAddbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddbtnAddActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Thêm Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            serviceSanPham.addSanPham(getFormSanPham());
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            listSanPham = serviceSanPham.getAll();
            showTableSanPham();
        }


    }//GEN-LAST:event_btnAddbtnAddActionPerformed

    private void btnUpdatebtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatebtnUpdateActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn UPDATE Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblViewSp.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceSanPham.updateSP(getFormSanPham(), listSanPham.get(row).getMaSanPham());
                JOptionPane.showMessageDialog(this, "UPDATE SUCCESS");
                listSanPham = serviceSanPham.getAll();
                showTableSanPham();
            }

        }
    }//GEN-LAST:event_btnUpdatebtnUpdateActionPerformed

    private void btnDeletebtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletebtnDeleteActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn DELETE? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblViewSp.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceSanPham.deleteSP(listSanPham.get(row).getMaSanPham());
                JOptionPane.showMessageDialog(this, "DELETE Thành Công");
                listSanPham = serviceSanPham.getAll();
                showTableSanPham();
            }
        }
    }//GEN-LAST:event_btnDeletebtnDeleteActionPerformed

    private void txtFindByIDtxtFindNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindByIDtxtFindNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindByIDtxtFindNameActionPerformed

    private void txtFindByIDtxtFindNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindByIDtxtFindNameKeyTyped
        // TODO add your handling code here:
        String ma = txtFindByID.getText();
        String ten = txtFindByID.getText();
        listSanPham = serviceSanPham.findByID(ma, ten);
        showTableSanPham();
        if(txtFindByID.getText().isEmpty()){
            listSanPham = serviceSanPham.getAll();
            showTableSanPham();
        }
    }//GEN-LAST:event_txtFindByIDtxtFindNameKeyTyped

    private void txtMaSp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSp1ActionPerformed

    private void txtMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMauSacActionPerformed

    private void txtCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPUActionPerformed

    private void txtRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRamActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Thêm Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            serviceBienThe.addBienThe(getFormBT());
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            listBienThe = serviceBienThe.getAll();
            showTableBT();
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn UPDATE Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblVieBienThe.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceBienThe.UpdateBienThe(getFormBT(), listBienThe.get(row).getMaBienThe());
                JOptionPane.showMessageDialog(this, "UPDATE SUCCESS");
                listBienThe = serviceBienThe.getAll();
                showTableBT();
            }

        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn DELETE? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblVieBienThe.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceBienThe.DeleteBienThe(listBienThe.get(row).getMaBienThe());
                JOptionPane.showMessageDialog(this, "DELETE Thành Công");
                listBienThe = serviceBienThe.getAll();
                showTableBT();
            }
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void txtMaBienTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBienTheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBienTheActionPerformed

    private void txtCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCardActionPerformed

    private void txtOCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOCungActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void txtFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyTyped
        String maBT = txtFind.getText();
        String mausac = txtFind.getText();
        listBienThe=serviceBienThe.findByID(maBT,mausac);
        showTableBT();
        if(txtFind.getText().isEmpty()){
            listBienThe = serviceBienThe.getAll();
            showTableBT();
        }

    }//GEN-LAST:event_txtFindKeyTyped

    private void txtSoLuongMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongMayActionPerformed

    private void tblVieBienTheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVieBienTheMouseClicked
        // TODO add your handling code here:
        int row = tblVieBienThe.getSelectedRow();
        showDetalBT(row);
    }//GEN-LAST:event_tblVieBienTheMouseClicked

    private void tblViewSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSpMouseClicked
        // TODO add your handling code here:
       int row = tblViewSp.getSelectedRow();
        showDetalSanPham(row);
       
    }//GEN-LAST:event_tblViewSpMouseClicked

    private void btnAdd1btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1btnAddActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Bạn có Muốn Thêm Mã IMEI ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            serviceMaIMEI.addIMEI(getFormIMEI());
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            listMaIMEI = serviceMaIMEI.getAll();
            showTableMaIMEI();
        }
    }//GEN-LAST:event_btnAdd1btnAddActionPerformed

    private void btnUpdate1btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1btnUpdateActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn UPDATE Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblIMEI.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceMaIMEI.UpdateIMEI(getFormIMEI(), listMaIMEI.get(row).getMaIMEI());
                JOptionPane.showMessageDialog(this, "UPDATE SUCCESS");
                listMaIMEI = serviceMaIMEI.getAll();
                showTableMaIMEI();
            }

        }
    }//GEN-LAST:event_btnUpdate1btnUpdateActionPerformed

    private void btnDelete1btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1btnDeleteActionPerformed
       int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn DELETE? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            int row = tblIMEI.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Row");
            } else {
                serviceMaIMEI.DeleteIMEI(listMaIMEI.get(row).getMaIMEI());
                JOptionPane.showMessageDialog(this, "DELETE Thành Công");
                listMaIMEI = serviceMaIMEI.getAll();
                showTableMaIMEI();
            }
        }
        
    }//GEN-LAST:event_btnDelete1btnDeleteActionPerformed

    private void tblIMEIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIMEIMouseClicked
        // TODO add your handling code here:
        int row = tblIMEI.getSelectedRow();
        showDetalIMEI(row);
    }//GEN-LAST:event_tblIMEIMouseClicked

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void tblViewSpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblViewSpKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tblViewSpKeyPressed

    private void tblViewSpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblViewSpKeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tblViewSpKeyReleased

    private void tblViewSpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblViewSpKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblViewSpKeyTyped

    private void tblViewSpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSpMousePressed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_tblViewSpMousePressed

    private void tblViewSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSpMouseEntered
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_tblViewSpMouseEntered

    private void tblViewSpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewSpMouseReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_tblViewSpMouseReleased

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
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewSanPham().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cboHeDieuHanh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblIMEI;
    private javax.swing.JTable tblVieBienThe;
    private javax.swing.JTable tblViewSp;
    private javax.swing.JTextField txtCPU;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFindByID;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaBienThe;
    private javax.swing.JTextField txtMaIMEI;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSp1;
    private javax.swing.JTextField txtManHinh;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtOCung;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtSoLuongMay;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTonKho;
    // End of variables declaration//GEN-END:variables
}
