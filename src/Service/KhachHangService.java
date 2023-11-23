/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class KhachHangService {

    public List<KhachHang> getAll() {
        String sql = """
                     SELECT [id_ma]
                           ,[tenKH]
                           ,[email]
                           ,[soDienThoai]
                           ,[diaChi]
                           ,[gioiTinh]
                           ,[ngaySinh]
                      FROM [dbo].[KhachHang]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> lists = new ArrayList();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt(1));
                kh.setTenKH(rs.getString(2));
                kh.setEmail(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setGioiTinh(rs.getBoolean(6));
                kh.setNgaySinh(rs.getDate(7));
                lists.add(kh);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(KhachHang kh) {
        String sql = """
                     INSERT INTO [dbo].[KhachHang]
                                ([tenKH]
                                ,[email]
                                ,[soDienThoai]
                                ,[diaChi]
                                ,[gioiTinh]
                                ,[ngaySinh])
                          VALUES
                                (?,?,?,?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getEmail());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, kh.getNgaySinh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(KhachHang kh, String tenKH) {
        String sql = """
                     UPDATE [dbo].[KhachHang]
                        SET [tenKH] = ?
                           ,[email] = ?
                           ,[soDienThoai] = ?
                           ,[diaChi] =  ?
                           ,[gioiTinh] = ?
                           ,[ngaySinh] = ?
                      WHERE [tenKH] = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getEmail());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, kh.getNgaySinh());
            ps.setObject(7, tenKH);
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(String tenKH) {
        String sql = """
                    DELETE FROM [dbo].[KhachHang]
                          WHERE tenKH = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public List<KhachHang> timKiem(String tenKH, String SDT){
        String sql = """
                     SELECT [id_ma]
                           ,[tenKH]
                           ,[email]
                           ,[soDienThoai]
                           ,[diaChi]
                           ,[gioiTinh]
                           ,[ngaySinh]
                      FROM [dbo].[KhachHang] where tenKH = ? or soDienThoai = ?
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setObject(1, tenKH);
                        ps.setObject(2, SDT);
            ResultSet rs = ps.executeQuery();
            List<KhachHang> lists = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt(1));
                kh.setTenKH(rs.getString(2));
                kh.setEmail(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setGioiTinh(rs.getBoolean(6));
                kh.setNgaySinh(rs.getDate(7));
                lists.add(kh);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<KhachHang> lists = new KhachHangService().getAll();
        for (KhachHang kh : lists) {
            System.out.println(kh.toString());
        }
    }
    
}
