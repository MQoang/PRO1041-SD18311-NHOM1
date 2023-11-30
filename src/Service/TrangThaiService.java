/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TrangThaiGiaoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC MSI
 */
public class TrangThaiService {
    public List<TrangThaiGiaoHang> getAll() {

        String sql = """
                    SELECT [MaTrangThai]
                          ,[MaPhieu]
                          ,[ThoiGianCapNhat]
                          ,[TrangThai]
                        FROM [dbo].[TrangThaiGiaoHang]
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<TrangThaiGiaoHang> list = new ArrayList<>();
            while (rs.next()) {
                TrangThaiGiaoHang dcgh = new TrangThaiGiaoHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(dcgh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean Add(TrangThaiGiaoHang ttgh) {

        String sql = """
                    INSERT INTO [dbo].[TrangThaiGiaoHang]
                               ([MaTrangThai]
                               ,[MaPhieu]
                               ,[ThoiGianCapNhat]
                               ,[TrangThai])
                        VALUES (?,?,?,?)
                    """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ttgh.getMaTrangThai());
            ps.setObject(2, ttgh.getMaPhieu());
            ps.setObject(3, ttgh.getThoiGianCapNhat());
            ps.setObject(4, ttgh.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean Update(TrangThaiGiaoHang ttgh, String ma) {
        String sql = """
                  UPDATE [dbo].[TrangThaiGiaoHang]
                                    SET [MaTrangThai] = ?
                                       ,[MaPhieu] = ?
                                       ,[ThoiGianCapNhat] = ?
                                       ,[TrangThai] = ?
                                  WHERE MaTrangThai = ?        
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ttgh.getMaTrangThai());
            ps.setObject(2, ttgh.getMaPhieu());
            ps.setObject(3, ttgh.getThoiGianCapNhat());
            ps.setObject(4, ttgh.getTrangThai());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean Xoa(String ma) {
        String sql = """
                    DELETE FROM [dbo].[TrangThaiGiaoHang]
                                WHERE MaTrangThai = ?               
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
