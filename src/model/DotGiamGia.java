/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Tom
 */
public class DotGiamGia {

    private String maDot;
    private int id;
    private String tenDot;
    private Date ngayBD;
    private Date ngayKT;
    private String mota;
    private String dieuKienApDung;
    private int phanTram;
    private int soLuong;

    public DotGiamGia() {
    }

    public DotGiamGia(String maDot, int id, String tenDot, Date ngayBD, Date ngayKT, String mota, String dieuKienApDung, int phanTram, int soLuong) {
        this.maDot = maDot;
        this.id = id;
        this.tenDot = tenDot;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.mota = mota;
        this.dieuKienApDung = dieuKienApDung;
        this.phanTram = phanTram;
        this.soLuong = soLuong;
    }

    public String getMaDot() {
        return maDot;
    }

    public void setMaDot(String maDot) {
        this.maDot = maDot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDot() {
        return tenDot;
    }

    public void setTenDot(String tenDot) {
        this.tenDot = tenDot;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "DotGiamGia{" + "maDot=" + maDot + ", id=" + id + ", tenDot=" + tenDot + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", mota=" + mota + ", dieuKienApDung=" + dieuKienApDung + ", phanTram=" + phanTram + ", soLuong=" + soLuong + '}';
    }

}
