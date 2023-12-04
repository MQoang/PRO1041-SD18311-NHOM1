/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.PhieuGiaoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.DBConnect;

/**
 *
 * @author PC MSI
 */
public class PhieuGiaoHangService {

    public List<PhieuGiaoHang> getAllPhieuGiao() {
        String sql = """
                        SELECT PhieuGiaoHang.MaPhieu,PhieuGiaoHang.ID, PhieuGiaoHang.MaKhachHang,PhieuGiaoHang.TenKhachHang,PhieuGiaoHang.SoDienThoai,PhieuGiaoHang.NgayGiao,
                                             	PhieuGiaoHang.DiaChiGiao,PhieuGiaoHang.GhiChu,PhieuGiaoHang.TongTien,ChiTietPhieuGiaoHang.MaChiTiet,ChiTietPhieuGiaoHang.SoLuong
                                                                  FROM PhieuGiaoHang INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.ID = ChiTietPhieuGiaoHang.ID
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<PhieuGiaoHang> list = new ArrayList<>();
            while (rs.next()) {
                PhieuGiaoHang pgh = new PhieuGiaoHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBigDecimal(9), rs.getString(10), rs.getInt(11));
                list.add(pgh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPhieuGiao(PhieuGiaoHang pgh) {
        String sql = """
                     INSERT INTO [dbo].[PhieuGiaoHang]
                                     ([MaPhieu]
                                     ,[ID]
                                     ,[MaKhachHang]
                                     ,[TenKhachHang]
                                     ,[SoDienThoai]
                                     ,[NgayGiao]
                                     ,[DiaChiGiao]
                                     ,[GhiChu]
                                     ,[TongTien])
                               VALUES
                                (?,?,?,?,?,?,?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pgh.getMaPhieu());
            ps.setObject(2, pgh.getId());
            ps.setObject(3, pgh.getMaKhachHang());
            ps.setObject(4, pgh.getTenKhachHang());
            ps.setObject(5, pgh.getSdt());
            ps.setObject(6, pgh.getNgayGiao());
            ps.setObject(7, pgh.getDiaChiGiao());
            ps.setObject(8, pgh.getGhiChu());
            ps.setObject(9, pgh.getTongTien());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deletePhieuGiao(String ma) {
        String sql = """
                     DELETE FROM [dbo].[PhieuGiaoHang]
                                 WHERE MaPhieu = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updatePhieuGiao(PhieuGiaoHang pgh, String ma) {
        String sql = """
                     UPDATE [dbo].[PhieuGiaoHang]
                         SET [MaPhieu] = ?
                            ,[ID] = ?
                            ,[MaKhachHang] = ?
                            ,[TenKhachHang] = ?
                            ,[SoDienThoai] = ?
                            ,[NgayGiao] = ?
                            ,[DiaChiGiao] = ?
                            ,[GhiChu] = ?
                            ,[TongTien] = ?
                       WHERE MaPhieu = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pgh.getMaPhieu());
            ps.setObject(2, pgh.getId());
            ps.setObject(3, pgh.getMaKhachHang());
            ps.setObject(4, pgh.getTenKhachHang());
            ps.setObject(5, pgh.getSdt());
            ps.setObject(6, pgh.getNgayGiao());
            ps.setObject(7, pgh.getDiaChiGiao());
            ps.setObject(8, pgh.getGhiChu());
            ps.setObject(9, pgh.getTongTien());
            ps.setObject(10, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<PhieuGiaoHang> TimKiem(String ma, String ten) {

        String sql = """
                    SELECT PhieuGiaoHang.MaPhieu,PhieuGiaoHang.ID, PhieuGiaoHang.MaKhachHang,PhieuGiaoHang.TenKhachHang,PhieuGiaoHang.SoDienThoai,PhieuGiaoHang.NgayGiao,
                           PhieuGiaoHang.DiaChiGiao,PhieuGiaoHang.GhiChu,PhieuGiaoHang.TongTien,ChiTietPhieuGiaoHang.MaChiTiet,ChiTietPhieuGiaoHang.SoLuong
                                    FROM PhieuGiaoHang INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.ID = ChiTietPhieuGiaoHang.ID
                                    WHERE PhieuGiaoHang.MaPhieu LIKE ? or PhieuGiaoHang.TenKhachHang LIKE ?
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, ten);
            ResultSet rs = ps.executeQuery();
            List<PhieuGiaoHang> list = new ArrayList<>();
            while (rs.next()) {
                PhieuGiaoHang pgh = new PhieuGiaoHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBigDecimal(9), rs.getString(10), rs.getInt(11));
                list.add(pgh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}
