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
    private int Id;
    private String hoTen;
    private String sdt;

    public NguoiNhan() {
    }

    public NguoiNhan(String maNguoiNhan, int Id, String hoTen, String sdt) {
        this.maNguoiNhan = maNguoiNhan;
        this.Id = Id;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public String getMaNguoiNhan() {
        return maNguoiNhan;
    }

    public void setMaNguoiNhan(String maNguoiNhan) {
        this.maNguoiNhan = maNguoiNhan;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
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

    @Override
    public String toString() {
        return "NguoiNhan{" + "maNguoiNhan=" + maNguoiNhan + ", Id=" + Id + ", hoTen=" + hoTen + ", sdt=" + sdt + '}';
    }

}
