/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC MSI
 */
public class DiaChiGiaoHang {

    private String Id;
    private String MaDiaChi;
    private String DiaChi;
    private String GhiChu;

    public DiaChiGiaoHang() {
    }

    public DiaChiGiaoHang(String Id, String MaDiaChi, String DiaChi, String GhiChu) {
        this.Id = Id;
        this.MaDiaChi = MaDiaChi;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaDiaChi() {
        return MaDiaChi;
    }

    public void setMaDiaChi(String MaDiaChi) {
        this.MaDiaChi = MaDiaChi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "DiaChiGiaoHang{" + "Id=" + Id + ", MaDiaChi=" + MaDiaChi + ", DiaChi=" + DiaChi + ", GhiChu=" + GhiChu + '}';
    }

}
