/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Luong;

/**
 *
 * @author Administrator
 */
public class LuongServie {

    public List<Luong> getAll2() {
        String sql = """
                    SELECT [ID]
                           ,[LuongCoBan]
                           ,[ThoiGianLam]
                           ,[CaLam]
                       FROM [dbo].[LuongNV]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Luong> dsl = new ArrayList<>();
            while (rs.next()) {
                Luong mvc = new Luong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                dsl.add(mvc);
            }
            return dsl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add2(Luong luong) {
        String sql = """
                INSERT INTO [dbo].[LuongNV]
                                           ([ID]
                                           ,[LuongCoBan]
                                           ,[ThoiGianLam]
                                           ,[CaLam])
                                     VALUES
                                           (?,?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, luong.getId());
            ps.setObject(2, luong.getLuong());
            ps.setObject(3, luong.getThoigian());
            ps.setObject(4, luong.getCa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete2(int id) {
        String sql = """
                     DELETE FROM [dbo].[LuongNV]
                           WHERE ID=?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update2(Luong luong, int id) {
        String sql = """
                   UPDATE [dbo].[LuongNV]
                        SET [ID] = ?
                           ,[LuongCoBan] = ?
                           ,[ThoiGianLam] = ?
                           ,[CaLam] = ?
                      WHERE ID =?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, luong.getId());
            ps.setObject(2, luong.getLuong());
            ps.setObject(3, luong.getThoigian());
            ps.setObject(4, luong.getCa());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public static void main(String[] args) {
        LuongServie mvc = new LuongServie();
        ArrayList<Luong> list = (ArrayList<Luong>) mvc.getAll2();
        for (Luong mnv : list) {
            System.out.println(mnv.toString());
        }
    }
}
