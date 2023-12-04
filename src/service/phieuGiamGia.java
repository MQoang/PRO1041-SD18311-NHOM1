/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class phieuGiamGia {

    private String idPhieu;
    private String tenPhieu;
    private String ngayKetThuc;
    private String ngayBatDau;
    private Integer giaTriGiam;
    private Boolean trangThai;

    public phieuGiamGia() {
    }

    public phieuGiamGia(String idPhieu, String tenPhieu, String ngayKetThuc, String ngayBatDau, Integer giaTriGiam, Boolean trangThai) {
        this.idPhieu = idPhieu;
        this.tenPhieu = tenPhieu;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayBatDau = ngayBatDau;
        this.giaTriGiam = giaTriGiam;
        this.trangThai = trangThai;
    }

    public String getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(String idPhieu) {
        this.idPhieu = idPhieu;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Integer getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Integer giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "phieuGiamGia{" + "idPhieu=" + idPhieu + ", tenPhieu=" + tenPhieu + ", ngayKetThuc=" + ngayKetThuc + ", ngayBatDau=" + ngayBatDau + ", giaTriGiam=" + giaTriGiam + ", trangThai=" + trangThai + '}';
    }

   

}
