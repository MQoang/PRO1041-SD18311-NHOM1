/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Service.DBConnect;
import Service.phieuGiamGia;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class PhieuGiamGiaSevicer {

    public List<phieuGiamGia> getAll() {
        String sql = """
                     SELECT [IDphieu]
                           ,[tenPhieu]
                           ,[ngayTao]
                           ,[ngayKetThuc]
                           ,[giaTriGiam]
                           ,[trangThai]
                       FROM [dbo].[PHIEUGIAMGIA1]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<phieuGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                phieuGiamGia pg = new phieuGiamGia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
                list.add(pg);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean themNV(phieuGiamGia pg) {
        String sql = """
                     INSERT INTO [dbo].[PHIEUGIAMGIA1]
                                ([IDphieu]
                                ,[tenPhieu]
                                ,[ngayTao]
                                ,[ngayKetThuc]
                                ,[giaTriGiam]
                                ,[trangThai])
                          VALUES
                                (?,?,?,?,?,?);
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pg.getIdPhieu());
            ps.setObject(2, pg.getTenPhieu());
            ps.setObject(3, pg.getNgayBatDau());
            ps.setObject(4, pg.getNgayKetThuc());
            ps.setObject(5, pg.getGiaTriGiam());
            ps.setObject(6, pg.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoaPhieu(String IDphieu) {
        String sql = """
                     DELETE FROM [dbo].[PHIEUGIAMGIA1]
                           WHERE IDphieu = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, IDphieu);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean suaNV(phieuGiamGia pg, String id) {
        String Sql = """
                        UPDATE [dbo].[PHIEUGIAMGIA1]
                           SET [IDphieu] = ?
                              ,[tenPhieu] = ?
                              ,[ngayTao] = ?
                              ,[ngayKetThuc] = ?
                              ,[giaTriGiam] = ?
                              ,[trangThai] = ?
                         WHERE        IDphieu = ?;              
                        """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(Sql)) {
            ps.setObject(1, pg.getIdPhieu());
            ps.setObject(2, pg.getTenPhieu());
            ps.setObject(3, pg.getNgayBatDau());
            ps.setObject(4, pg.getNgayKetThuc());
            ps.setObject(5, pg.getGiaTriGiam());
            ps.setObject(6, pg.getTrangThai());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<phieuGiamGia> timKiem(int giaTriGiam) {
        String sql = """
                     SELECT [IDphieu]
                                                ,[tenPhieu]
                                                ,[ngayTao]
                                                ,[ngayKetThuc]
                                                ,[giaTriGiam]
                                                ,[trangThai]
                                            FROM [dbo].[PHIEUGIAMGIA1]
                       WHERE giaTriGiam=?
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, giaTriGiam);
            ps.execute();
            ArrayList<phieuGiamGia> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phieuGiamGia pg = new phieuGiamGia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
                list.add(pg);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<phieuGiamGia> list = new PhieuGiamGiaSevicer().timKiem(30);
        for (phieuGiamGia pg : list) {
            System.out.println(pg.toString());
        }

    }
}
