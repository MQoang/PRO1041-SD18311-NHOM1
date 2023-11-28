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
public class PhieuGiaoHang {

    private String MaPhieu;
    private String Id;
    private String MaKhachHang;
    private String TenKhachHang;
    private String sdt;
    private String NgayGiao;
    private String DiaChiGiao;
    private String GhiChu;
    private BigDecimal TongTien;
    private String MaChiTiet;
    private int SoLuong;

    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(String MaPhieu, String Id, String MaKhachHang, String TenKhachHang, String sdt, String NgayGiao, String DiaChiGiao, String GhiChu, BigDecimal TongTien, String MaChiTiet, int SoLuong) {
        this.MaPhieu = MaPhieu;
        this.Id = Id;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.sdt = sdt;
        this.NgayGiao = NgayGiao;
        this.DiaChiGiao = DiaChiGiao;
        this.GhiChu = GhiChu;
        this.TongTien = TongTien;
        this.MaChiTiet = MaChiTiet;
        this.SoLuong = SoLuong;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public String getDiaChiGiao() {
        return DiaChiGiao;
    }

    public void setDiaChiGiao(String DiaChiGiao) {
        this.DiaChiGiao = DiaChiGiao;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaChiTiet() {
        return MaChiTiet;
    }

    public void setMaChiTiet(String MaChiTiet) {
        this.MaChiTiet = MaChiTiet;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "PhieuGiaoHang{" + "MaPhieu=" + MaPhieu + ", Id=" + Id + ", MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", sdt=" + sdt + ", NgayGiao=" + NgayGiao + ", DiaChiGiao=" + DiaChiGiao + ", GhiChu=" + GhiChu + ", TongTien=" + TongTien + ", MaChiTiet=" + MaChiTiet + ", SoLuong=" + SoLuong + '}';
    }

}
