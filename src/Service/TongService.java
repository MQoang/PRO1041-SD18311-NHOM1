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
import model.Tong;

/**
 *
 * @author Quanglm
 */
public class TongService {
    public List<Tong> getAll() {
        String sql = """
                     SELECT BienThe.MaBienThe, SanPham.MaSanPham, BienThe.MauSac,BienThe.GiaBan, MaIMEI.IMEI,SanPham.TenSanPham, SanPham.HeDieuHanh FROM SanPham INNER JOIN BienThe ON SanPham.MaSanPham = BienThe.MaSanPham
                     INNER JOIN MaIMEI ON BienThe.MaBienThe = MaIMEI.MaBienThe;
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Tong> lists = new ArrayList<>();
            while (rs.next()) {
                Tong nv = new Tong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                lists.add(nv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        List<Tong> list = new TongService().getAll();
        for (Tong nhanVien : list) {
            System.out.println(nhanVien.toString());
        }
    }
}
