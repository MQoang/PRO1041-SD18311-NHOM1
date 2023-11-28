/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Quanglm
 */
public class Tong {
    private String maBienThe;
    private String maSanPham;
    private String mauSac;
    private String giaBan;
    private String iMeI;
    private String tenSanPham;
    private String heDieuHanh;


    public Tong() {
    }

    public Tong(String maBienThe, String maSanPham, String mauSac, String giaBan, String iMeI, String tenSanPham, String heDieuHanh) {
        this.maBienThe = maBienThe;
        this.maSanPham = maSanPham;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.iMeI = iMeI;
        this.tenSanPham = tenSanPham;
        this.heDieuHanh = heDieuHanh;
    }

    public String getMaBienThe() {
        return maBienThe;
    }

    public void setMaBienThe(String maBienThe) {
        this.maBienThe = maBienThe;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getiMeI() {
        return iMeI;
    }

    public void setiMeI(String iMeI) {
        this.iMeI = iMeI;
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

    @Override
    public String toString() {
        return "Tong{" + "maBienThe=" + maBienThe + ", maSanPham=" + maSanPham + ", mauSac=" + mauSac + ", giaBan=" + giaBan + ", iMeI=" + iMeI + ", tenSanPham=" + tenSanPham + ", heDieuHanh=" + heDieuHanh + '}';
    }

  
}
