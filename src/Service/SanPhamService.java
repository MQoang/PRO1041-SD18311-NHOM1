/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs:nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Quanglm
 */
public class SanPhamService {
    public  List<SanPham> getAll(){
        String sql = """
                     SELECT [MaSanPham]
                           ,[TenSanPham]
                           ,[HeDieuHanh]
                           ,[ManHinh]
                           ,[CanNang]
                       FROM [dbo].[SanPham]
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> lists = new ArrayList<>();
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lists.add(sp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public boolean addSanPham(SanPham sp){
        String sql = """
                     INSERT INTO [dbo].[SanPham]
                                ([MaSanPham]
                                ,[TenSanPham]
                                ,[HeDieuHanh]
                                ,[ManHinh]
                                ,[CanNang])
                          VALUES(?,?,?,?,?);
                     """;
        int check = 0;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.getHeDieuHanh());
            ps.setObject(4, sp.getManHinh());
            ps.setObject(5, sp.getCanNang());
            check = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
   public boolean updateSP(SanPham sp, String MaSanPham){
        String sql = """
                     UPDATE [dbo].[SanPham]
                        SET [MaSanPham] = ?
                           ,[TenSanPham] = ?
                           ,[HeDieuHanh] = ?
                           ,[ManHinh] = ?
                           ,[CanNang] = ?
                      WHERE MaSanPham = ?;
                     """;
        int check = 0;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.getHeDieuHanh());
            ps.setObject(4, sp.getManHinh());
            ps.setObject(5, sp.getCanNang());
            ps.setObject(6, MaSanPham);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
            
    }
    
   public boolean deleteSP(String ma){
        String sql = """
                     DELETE FROM [dbo].[SanPham]
                           WHERE TenSanPham = ?;
                     """;
        int check = 0;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
   public List<SanPham> findName(String  ten){
       String sql = """
                    SELECT [MaSanPham]
                                               ,[TenSanPham]
                                               ,[HeDieuHanh]
                                               ,[ManHinh]
                                               ,[CanNang]
                                           FROM [dbo].[SanPham]  WHERE TenSanPham = ?;
                    """;
       try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
           
           ps.setObject(1, ten);
           ResultSet rs = ps.executeQuery();
           List<SanPham> searchName = new ArrayList<>();
           while(rs.next()){
               SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
               searchName.add(sp);
           }
           return searchName;
       } catch (Exception e) {
           
       }
       return null;
   }
    
    public static void main(String[] args) {
//        List<SanPham> lists = new SanPhamService().getAll();
//        for (SanPham nv : lists) {
//            System.out.println(nv.toString());
//        }
        List<SanPham> list = new SanPhamService().findName("LG Gram");
        for (SanPham sp : list) {
            System.out.println(sp.toString());
        }
    }
}
