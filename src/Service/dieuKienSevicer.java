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
import model.DieuKien;
/**
 *
 * @author Admin
 */
public class dieuKienSevicer {
      public  List<DieuKien> getAll(){
        String sql = """
                     SELECT [IDDieuKien]
                           ,[ngayHetHan]
                           ,[GiaTrietKhau]
                           ,[ngiChu]
                           ,[IDphieu]
                       FROM [dbo].[DIEUKIEN]
                     """;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<DieuKien> lists = new ArrayList<>();
            while(rs.next()){
                DieuKien sp = new DieuKien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                lists.add(sp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
      }
      public static void main(String[] args) {
         List<DieuKien> list = new dieuKienSevicer().getAll();
        for (DieuKien sp : list) {
            System.out.println(sp.toString());
        }
    }
}

