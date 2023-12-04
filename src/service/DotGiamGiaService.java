/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DotGiamGia;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class DotGiamGiaService {

    public List<DotGiamGia> getAll() {
        String sql = """
                     SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                     DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                     MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                     FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<DotGiamGia> dsdot = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                dsdot.add(dot);
            }
            return dsdot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(DotGiamGia dgg) {
        String sql = """
                     INSERT INTO [dbo].[DotGiamGia]
                                ([MaDotGiamGia]
                                ,[ID] 
                                ,[TenChuongTrinh]
                                ,[NgayBatDau]
                                ,[NgayKetThuc]
                                ,[MoTa]
                                ,[DieuKienApDung])
                          VALUES
                                (?,?,?,?,?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dgg.getMaDot());
            ps.setObject(2, dgg.getId());
            ps.setObject(3, dgg.getTenDot());
            ps.setObject(4, dgg.getNgayBD());
            ps.setObject(5, dgg.getNgayKT());
            ps.setObject(6, dgg.getMota());
            ps.setObject(7, dgg.getDieuKienApDung());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String sql = """
                     DELETE FROM [dbo].[DotGiamGia]
                           WHERE MaDotGiamGia=?
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

    public boolean update(DotGiamGia dgg, String ma) {
        String sql = """
                     UPDATE [dbo].[DotGiamGia]
                        SET [MaDotGiamGia] = ?
                           ,[ID] = ?
                           ,[TenChuongTrinh] = ?
                           ,[NgayBatDau] = ?
                           ,[NgayKetThuc] = ?
                           ,[MoTa] = ?
                           ,[DieuKienApDung] = ?
                      WHERE MaDotGiamGia=?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dgg.getMaDot());
            ps.setObject(2, dgg.getId());
            ps.setObject(3, dgg.getTenDot());
            ps.setObject(4, dgg.getNgayBD());
            ps.setObject(5, dgg.getNgayKT());
            ps.setObject(6, dgg.getMota());
            ps.setObject(7, dgg.getDieuKienApDung());
            ps.setObject(8, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<DotGiamGia> timKiem(String ma, String id) {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                        DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                        DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                        MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                        FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                        WHERE DotGiamGia.ID LIKE ? OR DotGiamGia.MaDotGiamGia LIKE ? 
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, id);
            ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findByPT2025() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE PhanTramGiamGia BETWEEN 20 AND 25
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findByPT2635() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE PhanTramGiamGia BETWEEN 26 AND 35
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findByPT1015() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE PhanTramGiamGia BETWEEN 10 AND 15
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findBySL99299() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE SoLuong BETWEEN 99 AND 299
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findBySL3969() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE SoLuong BETWEEN 39 AND 69
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> findBySL919() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE SoLuong BETWEEN 9 AND 19
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> hetHan() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE NgayKetThuc < GETDATE();
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DotGiamGia> conHoatDong() {
        String sql = """
                        SELECT DotGiamGia.MaDotGiamGia,MaVoucher.ID,
                                                DotGiamGia.TenChuongTrinh,DotGiamGia.NgayBatDau,DotGiamGia.NgayKetThuc,
                                                DotGiamGia.MoTa,DotGiamGia.DieuKienApDung,
                                                MaVoucher.PhanTramGiamGia,MaVoucher.SoLuong
                                                FROM DotGiamGia INNER JOIN MaVoucher ON DotGiamGia.ID=MaVoucher.ID                     	  
                                                WHERE NgayKetThuc >= GETDATE();
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            ArrayList<DotGiamGia> list = new ArrayList<>();
            while (rs.next()) {
                DotGiamGia dot = new DotGiamGia(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                list.add(dot);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DotGiamGiaService dgg = new DotGiamGiaService();
        List<DotGiamGia> list = dgg.timKiem("3", "");
        for (DotGiamGia dot : list) {
            System.out.println(dot.toString());
        }
    }
}
