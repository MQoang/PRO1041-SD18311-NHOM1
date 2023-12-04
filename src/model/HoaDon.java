/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author PC MSI
 */
public class HoaDon {

    private int MaHoaDon;
    private int MaPhieu;
    private String Ngaylap;
    private BigDecimal TongTien;
    private int MaPTTT;

    public HoaDon() {
    }

    public HoaDon(int MaHoaDon, int MaPhieu, String Ngaylap, BigDecimal TongTien, int MaPTTT) {
        this.MaHoaDon = MaHoaDon;
        this.MaPhieu = MaPhieu;
        this.Ngaylap = Ngaylap;
        this.TongTien = TongTien;
        this.MaPTTT = MaPTTT;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getNgaylap() {
        return Ngaylap;
    }

    public void setNgaylap(String Ngaylap) {
        this.Ngaylap = Ngaylap;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public int getMaPTTT() {
        return MaPTTT;
    }

    public void setMaPTTT(int MaPTTT) {
        this.MaPTTT = MaPTTT;
    }

}
