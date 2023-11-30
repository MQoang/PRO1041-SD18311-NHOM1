package Model;

import java.math.BigDecimal;
import java.util.Date;


public class PhieuDoi {
   private String MaPhieuDoi;
   private String TenKhachHang;
   private String TenSanPham;
   private BigDecimal giaBan;
   private Date NgayDoi;
   private String LyDoDoi;
   private String LyDoDoiChiTiet;

    public PhieuDoi() {
    }

    public PhieuDoi(String MaPhieuDoi, String TenKhachHang, String TenSanPham, BigDecimal giaBan, Date NgayDoi, String LyDoDoi, String LyDoDoiChiTiet) {
        this.MaPhieuDoi = MaPhieuDoi;
        this.TenKhachHang = TenKhachHang;
        this.TenSanPham = TenSanPham;
        this.giaBan = giaBan;
        this.NgayDoi = NgayDoi;
        this.LyDoDoi = LyDoDoi;
        this.LyDoDoiChiTiet = LyDoDoiChiTiet;
    }

    public String getMaPhieuDoi() {
        return MaPhieuDoi;
    }

    public void setMaPhieuDoi(String MaPhieuDoi) {
        this.MaPhieuDoi = MaPhieuDoi;
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

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgayDoi() {
        return NgayDoi;
    }

    public void setNgayDoi(Date NgayDoi) {
        this.NgayDoi = NgayDoi;
    }

    public String getLyDoDoi() {
        return LyDoDoi;
    }

    public void setLyDoDoi(String LyDoDoi) {
        this.LyDoDoi = LyDoDoi;
    }

    public String getLyDoDoiChiTiet() {
        return LyDoDoiChiTiet;
    }

    public void setLyDoDoiChiTiet(String LyDoDoiChiTiet) {
        this.LyDoDoiChiTiet = LyDoDoiChiTiet;
    }

    
    
}
