/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.ChiTietPhieuGiaoHang;
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
public class ChiTietService {

    public List<ChiTietPhieuGiaoHang> getAllChiTiet() {

        String sql = """
                    SELECT [MaChiTiet]
                              ,[Id]
                              ,[MaSanPham]
                              ,[SoLuong]
                              ,[GiaBan]
                          FROM [dbo].[ChiTietPhieuGiaoHang]
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ChiTietPhieuGiaoHang> list = new ArrayList<>();
            while (rs.next()) {
                ChiTietPhieuGiaoHang gh = new ChiTietPhieuGiaoHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBigDecimal(5));
                list.add(gh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean AddChiTiet(ChiTietPhieuGiaoHang ct) {

        String sql = """
                    INSERT INTO [dbo].[ChiTietPhieuGiaoHang]
                                                     ([MaChiTiet]
                                                     ,[Id]
                                                     ,[MaSanPham]
                                                     ,[SoLuong]
                                                     ,[GiaBan])
                                    VALUES (?,?,?,?,?)
                    """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ct.getMaChiTiet());
            ps.setObject(2, ct.getId());
            ps.setObject(3, ct.getMaSanPham());
            ps.setObject(4, ct.getSoLuong());
            ps.setObject(5, ct.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean UpdateChiTiet(ChiTietPhieuGiaoHang ct, String ma) {
        String sql = """
                  UPDATE [dbo].[ChiTietPhieuGiaoHang]
                                  SET [MaChiTiet] = ?
                                     ,[Id] = ?
                                     ,[MaSanPham] = ?
                                     ,[SoLuong] = ?
                                     ,[GiaBan] = ?
                                WHERE MaChiTiet = ?         
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ct.getMaChiTiet());
            ps.setObject(2, ct.getId());
            ps.setObject(3, ct.getMaSanPham());
            ps.setObject(4, ct.getSoLuong());
            ps.setObject(5, ct.getGiaBan());
            ps.setObject(6, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean XoaChiTiet(String ma) {
        String sql = """
                   DELETE FROM [dbo].[ChiTietPhieuGiaoHang]
                                  WHERE MaChiTiet = ?               
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
