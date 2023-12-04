/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.ChiTietPhieuGiaoHang;
import model.DiaChiGiaoHang;
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
public class DiaChiService {
    public List<DiaChiGiaoHang> getAllDiaChi() {

        String sql = """
                    SELECT [ID]
                          ,[MaDiaChi]
                          ,[DiaChi]
                          ,[GhiChu]
                        FROM [dbo].[DiaChiGiaoHang]
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<DiaChiGiaoHang> list = new ArrayList<>();
            while (rs.next()) {
                DiaChiGiaoHang dcgh = new DiaChiGiaoHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(dcgh);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean AddDiaChi(DiaChiGiaoHang dc) {

        String sql = """
                    INSERT INTO [dbo].[DiaChiGiaoHang]
                            ([ID]
                            ,[MaDiaChi]
                            ,[DiaChi]
                            ,[GhiChu])
                    VALUES (?,?,?,?)
                    """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, dc.getId());
            ps.setObject(2, dc.getMaDiaChi());
            ps.setObject(3, dc.getDiaChi());
            ps.setObject(4, dc.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean UpdateDiaChi(DiaChiGiaoHang dc, String ma) {
        String sql = """
                  UPDATE [dbo].[DiaChiGiaoHang]
                                    SET [ID] = ?
                                       ,[MaDiaChi] = ?
                                       ,[DiaChi] = ?
                                       ,[GhiChu] = ?
                                  WHERE MaDiaChi = ?         
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, dc.getId());
            ps.setObject(2, dc.getMaDiaChi());
            ps.setObject(3, dc.getDiaChi());
            ps.setObject(4, dc.getGhiChu());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean XoaDiaChi(String ma) {
        String sql = """
                    DELETE FROM [dbo].[DiaChiGiaoHang]
                            WHERE MaDiaChi = ?               
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
