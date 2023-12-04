/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
  
    private String idMa;
    private String tenKH;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private Boolean gioiTinh;
    private Date ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String idMa, String tenKH, String email, String soDienThoai, String diaChi, Boolean gioiTinh, Date ngaySinh) {
        this.idMa = idMa;
        this.tenKH = tenKH;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public String getIdMa() {
        return idMa;
    }

    public void setIdMa(String idMa) {
        this.idMa = idMa;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idMa=" + idMa + ", tenKH=" + tenKH + ", email=" + email + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + '}';
    }

    

   

    
}
