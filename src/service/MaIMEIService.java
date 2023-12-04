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
import model.IMEI;

/**
 *
 * @author Quanglm
 */
public class MaIMEIService {
    public  List<IMEI> getAll(){
        String sql = """
                     SELECT [MaBienThe]
                     ,[MaIMEI]
                     FROM [dbo].[MaIMEI]
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<IMEI> lists = new ArrayList<>();
            while(rs.next()){
                IMEI im = new IMEI(rs.getString(1), rs.getString(2));
                lists.add(im);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addIMEI(IMEI imei) {
        String sql = """
                     INSERT INTO [dbo].[MaIMEI]
                                ([MaBienThe]
                                ,[MaIMEI])
                          VALUES
                                (?,?);
                     """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, imei.getMaBienThe());
            ps.setObject(2, imei.getMaIMEI());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
     public boolean DeleteIMEI(String ma) {
        String sql = """
                      DELETE FROM [dbo].[MaIMEI]
                            WHERE MaIMEI = ?
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
     public boolean UpdateIMEI(IMEI imei, String ma) {
        String sql = """
                      UPDATE [dbo].[MaIMEI]
                         SET [MaBienThe] = ?
                            ,[MaIMEI] = ?
                       WHERE MaIMEI = ?;
                      """;
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, imei.getMaBienThe());
            ps.setObject(2, imei.getMaIMEI());
            ps.setObject(3, ma);
            
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
