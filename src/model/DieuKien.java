/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class DieuKien {
    private String idDieuKien;
    private String ngayHetHan;
    private Integer giaTriTrietKhau;
    private String nghiChu;
    private String idPhieu;

    public DieuKien() {
    }

    public DieuKien(String idDieuKien, String ngayHetHan, Integer giaTriTrietKhau, String nghiChu, String idPhieu) {
        this.idDieuKien = idDieuKien;
        this.ngayHetHan = ngayHetHan;
        this.giaTriTrietKhau = giaTriTrietKhau;
        this.nghiChu = nghiChu;
        this.idPhieu = idPhieu;
    }

    public String getIdDieuKien() {
        return idDieuKien;
    }

    public void setIdDieuKien(String idDieuKien) {
        this.idDieuKien = idDieuKien;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public Integer getGiaTriTrietKhau() {
        return giaTriTrietKhau;
    }

    public void setGiaTriTrietKhau(Integer giaTriTrietKhau) {
        this.giaTriTrietKhau = giaTriTrietKhau;
    }

    public String getNghiChu() {
        return nghiChu;
    }

    public void setNghiChu(String nghiChu) {
        this.nghiChu = nghiChu;
    }

    public String getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(String idPhieu) {
        this.idPhieu = idPhieu;
    }

    @Override
    public String toString() {
        return "DieuKien{" + "idDieuKien=" + idDieuKien + ", ngayHetHan=" + ngayHetHan + ", giaTriTrietKhau=" + giaTriTrietKhau + ", nghiChu=" + nghiChu + ", idPhieu=" + idPhieu + '}';
    }
    
}
