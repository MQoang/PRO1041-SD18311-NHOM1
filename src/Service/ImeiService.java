/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.BienThe;
import model.Imei;
import model.SanPham;

/**
 *
 * @author Quanglm
 */
public class ImeiService {
    public  List<Imei> getAll(){
        String sql = """
                     SELECT [MaBienThe]
                     ,[IMEI]
                     FROM [dbo].[MaIMEI]
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Imei> lists = new ArrayList<>();
            while(rs.next()){
                Imei im = new Imei(rs.getString(1), rs.getString(2));
                lists.add(im);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addBienThe(Imei imei) {
        String sql = """
                     INSERT INTO [dbo].[MaIMEI]
                                ([MaBienThe]
                                ,[IMEI])
                          VALUES
                                (?,?);
                     """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, imei.getMaBienThe());
            ps.setObject(2, imei.getMaImei());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
     public boolean DeleteBienThe(String ma) {
        String sql = """
                      DELETE FROM [dbo].[MaIMEI]
                            WHERE MaBienThe = ?
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
     public boolean UpdateBienThe(Imei imei, String ma) {
        String sql = """
                      UPDATE [dbo].[MaIMEI]
                         SET [MaBienThe] = ?
                            ,[IMEI] = ?
                       WHERE MaBienThe = ?;
                      """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, imei.getMaBienThe());
            ps.setObject(2, imei.getMaImei());
            ps.setObject(3, ma);
            
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
