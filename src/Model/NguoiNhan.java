/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC MSI
 */
public class NguoiNhan {

    private String maNguoiNhan;
    private String Id;
    private String hoTen;
    private String sdt;
    private String MaDiaChi;
    private String DiaChi;
    private String GhiChu;

    public NguoiNhan() {
    }

    public NguoiNhan(String maNguoiNhan, String Id, String hoTen, String sdt, String MaDiaChi, String DiaChi, String GhiChu) {
        this.maNguoiNhan = maNguoiNhan;
        this.Id = Id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.MaDiaChi = MaDiaChi;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
    }

    public String getMaNguoiNhan() {
        return maNguoiNhan;
    }

    public void setMaNguoiNhan(String maNguoiNhan) {
        this.maNguoiNhan = maNguoiNhan;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
        return "NguoiNhan{" + "maNguoiNhan=" + maNguoiNhan + ", Id=" + Id + ", hoTen=" + hoTen + ", sdt=" + sdt + ", MaDiaChi=" + MaDiaChi + ", DiaChi=" + DiaChi + ", GhiChu=" + GhiChu + '}';
    }

}
