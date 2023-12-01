/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.PhieuGiamGiaChiTiet;

/**
 *
 * @author Admin
 */
public class phieuGiamGiaChiTietSevicer {

    public List<PhieuGiamGiaChiTiet> getAll() {
        String sql = """
                    SELECT dbo.PHIEUGIAMGIACHITET.IDphieuChiTet,PHIEUGIAMGIA1.IDphieu,thoiGianBatDau,giaGiam
                     ,PHIEUGIAMGIA1.tenPhieu,PHIEUGIAMGIA1.ngayTao,PHIEUGIAMGIA1.ngayKetThuc,PHIEUGIAMGIA1.trangThai
                    FROM PHIEUGIAMGIACHITET INNER JOIN PHIEUGIAMGIA1 
                    ON PHIEUGIAMGIA1.IDphieu = PHIEUGIAMGIACHITET.IDphieu
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<PhieuGiamGiaChiTiet> pgct = new ArrayList<>();
            while (rs.next()) {
                PhieuGiamGiaChiTiet dot = new PhieuGiamGiaChiTiet(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4));
                pgct.add(dot);
            }
            return pgct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public boolean add(PhieuGiamGiaChiTiet dgg) {
        String sql = """
                    INSERT INTO [dbo].[PHIEUGIAMGIACHITET]
                                ([IDphieuChiTet]
                                ,[IDphieu]
                                ,[thoiGianBatDau]
                                ,[giaGiam])
                          VALUES
                                (?,?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dgg.getIdPhieuChiTiet());
            ps.setObject(2, dgg.getIdPhieu());
            ps.setObject(3, dgg.getThoiGianBatDau());
            ps.setObject(4, dgg.getGiaGiam());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String sql = """
                     DELETE FROM [dbo].[PHIEUGIAMGIACHITET]
                           WHERE IDphieuChiTet = ?
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

    public boolean update(PhieuGiamGiaChiTiet dgg, String ma) {
        String sql = """
                     UPDATE [dbo].[PHIEUGIAMGIACHITET]
                        SET [IDphieuChiTet] = ?
                           ,[IDphieu] = ?
                           ,[thoiGianBatDau] = ? 
                           ,[giaGiam] = ?
                      WHERE IDphieuChiTet = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dgg.getIdPhieuChiTiet());
            ps.setObject(2, dgg.getIdPhieu());
            ps.setObject(3, dgg.getThoiGianBatDau());
            ps.setObject(4, dgg.getGiaGiam());

            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        phieuGiamGiaChiTietSevicer dgg = new phieuGiamGiaChiTietSevicer();
        List<PhieuGiamGiaChiTiet> list = dgg.getAll();
        for (PhieuGiamGiaChiTiet dot : list) {
            System.out.println(dot.toString());
        }
    }
}
