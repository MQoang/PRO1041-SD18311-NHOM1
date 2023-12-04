/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class NhanVien {

    private String maNV;
    private int id;
    private String tenNV;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String chucVu;
    private String diaChi;
    private String email;
    private String Sđt;
    private String chuThich;
    private LocalDate ngayTuyen;
    private int luong;
    private int thoigian;
    private int calam;

    public NhanVien() {
    }

    public NhanVien(String maNV, int id, String tenNV, Boolean gioiTinh, LocalDate ngaySinh, String chucVu, String diaChi, String email, String Sđt, String chuThich, LocalDate ngayTuyen, int luong, int thoigian, int calam) {
        this.maNV = maNV;
        this.id = id;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.email = email;
        this.Sđt = Sđt;
        this.chuThich = chuThich;
        this.ngayTuyen = ngayTuyen;
        this.luong = luong;
        this.thoigian = thoigian;
        this.calam = calam;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", id=" + id + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu + ", diaChi=" + diaChi + ", email=" + email + ", S\u0111t=" + Sđt + ", chuThich=" + chuThich + ", ngayTuyen=" + ngayTuyen + ", luong=" + luong + ", thoigian=" + thoigian + ", calam=" + calam + '}';
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSđt() {
        return Sđt;
    }

    public void setSđt(String Sđt) {
        this.Sđt = Sđt;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public LocalDate getNgayTuyen() {
        return ngayTuyen;
    }

    public void setNgayTuyen(LocalDate ngayTuyen) {
        this.ngayTuyen = ngayTuyen;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getCalam() {
        return calam;
    }

    public void setCalam(int calam) {
        this.calam = calam;
    }

 
   

   

  

}
