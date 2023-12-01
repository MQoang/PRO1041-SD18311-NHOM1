/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class PhieuGiamGiaChiTiet {
    private String idPhieuChiTiet;
    private String idPhieu;
    private String thoiGianBatDau;
    private String giaGiam;

    public PhieuGiamGiaChiTiet() {
    }

    public String getIdPhieuChiTiet() {
        return idPhieuChiTiet;
    }

    public void setIdPhieuChiTiet(String idPhieuChiTiet) {
        this.idPhieuChiTiet = idPhieuChiTiet;
    }

    public String getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(String idPhieu) {
        this.idPhieu = idPhieu;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(String giaGiam) {
        this.giaGiam = giaGiam;
    }

    public PhieuGiamGiaChiTiet(String idPhieuChiTiet, String idPhieu, String thoiGianBatDau, String giaGiam) {
        this.idPhieuChiTiet = idPhieuChiTiet;
        this.idPhieu = idPhieu;
        this.thoiGianBatDau = thoiGianBatDau;
        this.giaGiam = giaGiam;
    }

    @Override
    public String toString() {
        return "PhieuGiamGiaChiTiet{" + "idPhieuChiTiet=" + idPhieuChiTiet + ", idPhieu=" + idPhieu + ", thoiGianBatDau=" + thoiGianBatDau + ", giaGiam=" + giaGiam + '}';
    }


}
