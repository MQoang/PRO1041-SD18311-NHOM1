package Model;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDon {
    private String MaHoaDon;
    private String TenKhachHang;
    private String TenSanPham;
    private Date NgayMua;
    private BigDecimal GiaBan;

    public HoaDon() {
    }

    public HoaDon(String MaHoaDon, String TenKhachHang, String TenSanPham, Date NgayMua, BigDecimal GiaBan) {
        this.MaHoaDon = MaHoaDon;
        this.TenKhachHang = TenKhachHang;
        this.TenSanPham = TenSanPham;
        this.NgayMua = NgayMua;
        this.GiaBan = GiaBan;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    
}
