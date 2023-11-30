/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC MSI
 */
public class TrangThaiGiaoHang {

    private String MaTrangThai;
    private String MaPhieu;
    private String ThoiGianCapNhat;
    private String TrangThai;

    public TrangThaiGiaoHang() {
    }

    public TrangThaiGiaoHang(String MaTrangThai, String MaPhieu, String ThoiGianCapNhat, String TrangThai) {
        this.MaTrangThai = MaTrangThai;
        this.MaPhieu = MaPhieu;
        this.ThoiGianCapNhat = ThoiGianCapNhat;
        this.TrangThai = TrangThai;
    }

    public String getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(String MaTrangThai) {
        this.MaTrangThai = MaTrangThai;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getThoiGianCapNhat() {
        return ThoiGianCapNhat;
    }

    public void setThoiGianCapNhat(String ThoiGianCapNhat) {
        this.ThoiGianCapNhat = ThoiGianCapNhat;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "TrangThaiGiaoHang{" + "MaTrangThai=" + MaTrangThai + ", MaPhieu=" + MaPhieu + ", ThoiGianCapNhat=" + ThoiGianCapNhat + ", TrangThai=" + TrangThai + '}';
    }

}
