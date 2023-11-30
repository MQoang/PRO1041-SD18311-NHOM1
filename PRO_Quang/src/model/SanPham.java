/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Quanglm
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String heDieuHanh;
    private String manHinh;
    private String canNang;
    private String tonKho;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String heDieuHanh, String manHinh, String canNang, String tonKho) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.heDieuHanh = heDieuHanh;
        this.manHinh = manHinh;
        this.canNang = canNang;
        this.tonKho = tonKho;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", heDieuHanh=" + heDieuHanh + ", manHinh=" + manHinh + ", canNang=" + canNang + ", tonKho=" + tonKho + '}';
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    public String getTonKho() {
        return tonKho;
    }

    public void setTonKho(String tonKho) {
        this.tonKho = tonKho;
    }

    
    
    
}
