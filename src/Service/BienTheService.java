/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.BienThe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Quanglm
 */
public class BienTheService {

    public List<BienThe> getAll1() {
        String sql = """
                     SELECT [MaBienThe]
                           ,[MaSanPham]
                           ,[MauSac]
                           ,[CPU]
                           ,[Ram]
                           ,[Card]
                           ,[Ocung]
                           ,[GiaBan]
                       FROM [dbo].[BienThe];
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<BienThe> lists = new ArrayList<>();
            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                lists.add(bt);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addBienThe(BienThe bt) {
        String sql = """
                     INSERT INTO [dbo].[BienThe]
                                ([MaBienThe]
                                ,[MaSanPham]
                                ,[MauSac]
                                ,[CPU]
                                ,[Ram]
                                ,[Card]
                                ,[Ocung]
                                ,[GiaBan])
                          VALUES
                                (?,?,?,?,?,?,?,?);
                     """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, bt.getMaBienThe());
            ps.setObject(2, bt.getMaSanPham());
            ps.setObject(3, bt.getMauSac());
            ps.setObject(4, bt.getCPU());
            ps.setObject(5, bt.getRam());
            ps.setObject(6, bt.getCard());
            ps.setObject(7, bt.getoCung());
            ps.setObject(8, bt.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean DeleteBienThe(String ma) {
        String sql = """
                      DELETE FROM [dbo].[BienThe]
                            WHERE MaBienThe = ?;
                      """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean UpdateBienThe(BienThe bt, String ma) {
        String sql = """
                      UPDATE [dbo].[BienThe]
                         SET [MaBienThe] = ?
                            ,[MaSanPham] = ?
                            ,[MauSac] = ?
                            ,[CPU] = ?
                            ,[Ram] = ?
                            ,[Card] = ?
                            ,[Ocung] = ?
                            ,[GiaBan] = ?
                       WHERE MaBienThe = ?;
                      """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, bt.getMaBienThe());
            ps.setObject(2, bt.getMaSanPham());
            ps.setObject(3, bt.getMauSac());
            ps.setObject(4, bt.getCPU());
            ps.setObject(5, bt.getRam());
            ps.setObject(6, bt.getCard());
            ps.setObject(7, bt.getoCung());
            ps.setObject(8, bt.getGiaBan());
            ps.setObject(9, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<BienThe> findbyMauDen() {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE MauSac = N'Đen';
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }

    public List<BienThe> findbyMauTrang() {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE MauSac = N'Trắng';
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }

    public List<BienThe> findbyMauXanh() {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE MauSac = N'Xanh';
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }
public List<BienThe> findByPriceNho() {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE GiaBan BETWEEN 10000000 AND 14000000;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }
    public List<BienThe> findByPriceLon() {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE GiaBan > 14000000;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }
    
    public List<BienThe> findByID(String id,String mausac) {
        String sql = """
                     SELECT [MaBienThe]
                                                ,[MaSanPham]
                                                ,[MauSac]
                                                ,[CPU]
                                                ,[Ram]
                                                ,[Card]
                                                ,[Ocung]
                                                ,[GiaBan]
                                            FROM [dbo].[BienThe] WHERE MaBienThe LIKE ? OR MauSac LIKE ? ;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.setObject(2, mausac);
            ResultSet rs = ps.executeQuery();
            List<BienThe> findsql = new ArrayList<>();

            while (rs.next()) {
                BienThe bt = new BienThe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                findsql.add(bt);
            }
            return findsql;
        } catch (Exception e) {

        }
        return null;
    }
    

    public static void main(String[] args) {
        List<BienThe> lists = new BienTheService().findByID("","Đen");
        for (BienThe bt : lists) {
            System.out.println(bt.toString());
        }
    }
}
