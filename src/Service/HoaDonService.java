package Service;

import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonService {
    ArrayList<HoaDon> listHD = new ArrayList<>();
    public ArrayList<HoaDon> getAll() {
        String Query = """
                        SELECT HoaDon.MaHoaDon, KhachHang.tenKH,SanPham.TenSanPham,HoaDon.NgayMua , SanPham.GiaBan 
                        FROM HoaDon 
                        INNER JOIN KhachHang ON HoaDon.id_ma = KhachHang.id_ma 
                        INNER JOIN SanPham ON HoaDon.MaSanPham = SanPham.MaSanPham   
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon HD = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBigDecimal(5));
                list.add(HD);
            }
            return (ArrayList<HoaDon>) list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listHD;
    }
    
    public ArrayList<HoaDon> search(String MaHD,String TenKH) {
        String sql = """
                    SELECT HoaDon.MaHoaDon, KhachHang.tenKH,SanPham.TenSanPham,HoaDon.NgayMua , SanPham.GiaBan 
                    FROM HoaDon 
                    INNER JOIN KhachHang ON HoaDon.id_ma = KhachHang.id_ma 
                    INNER JOIN SanPham ON HoaDon.MaSanPham = SanPham.MaSanPham
                    where  HoaDon.MaHoaDon = ? or KhachHang.tenKH = ?                    
                 """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, MaHD);
            ps.setObject(2, TenKH);

            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setTenKhachHang(rs.getString(2));
                hd.setTenSanPham(rs.getString(3));
                hd.setNgayMua(rs.getDate(4));
                hd.setGiaBan(rs.getBigDecimal(5));
                
                list.add(hd);
            }
            return (ArrayList<HoaDon>) list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
}
