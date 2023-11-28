/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author PC MSI
 */
public class ChiTietPhieuGiaoHang {

    private String maChiTiet;
    private int Id;
    private String maSanPham;
    private int soLuong;
    private BigDecimal giaBan;

    public ChiTietPhieuGiaoHang() {
    }

    public ChiTietPhieuGiaoHang(String maChiTiet, int Id, String maSanPham, int soLuong, BigDecimal giaBan) {
        this.maChiTiet = maChiTiet;
        this.Id = Id;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(String maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuGiaoHang{" + "maChiTiet=" + maChiTiet + ", Id=" + Id + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", giaBan=" + giaBan + '}';
    }

}
