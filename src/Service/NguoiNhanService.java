package Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.NguoiNhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC MSI
 */
public class NguoiNhanService {

    public List<NguoiNhan> getAll() {

        String sql = """
                    SELECT [MaNguoiNhan]
                          ,[Id]
                          ,[HoTen]
                          ,[DienThoai]
                        FROM [dbo].[NguoiNhanHang]
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<NguoiNhan> list = new ArrayList<>();
            while (rs.next()) {
                NguoiNhan nn = new NguoiNhan(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                list.add(nn);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean AddNguoiNhan(NguoiNhan nn) {
        String sql = """
                    INSERT INTO [dbo].[NguoiNhanHang]
                                    ([MaNguoiNhan]
                                    ,[MaPhieu]
                                    ,[HoTen]
                                    ,[DienThoai])
                              VALUES (?,?,?,?)
                    """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, nn.getMaNguoiNhan());
            ps.setObject(2, nn.getId());
            ps.setObject(3, nn.getHoTen());
            ps.setObject(4, nn.getSdt());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean XoaNguoiNhan(String ten) {
        String sql = """
                    DELETE FROM [dbo].[NguoiNhanHang]
                                        WHERE HoTen =?
                    """;

        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean Update(NguoiNhan nn, String ten) {
        String sql = """
                   UPDATE [dbo].[NguoiNhanHang]
                                   SET [MaNguoiNhan] = ?
                                      ,[MaPhieu] = ?
                                      ,[HoTen] = ?
                                      ,[DienThoai] = ?
                                   WHERE HoTen = ?
                    """;

        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {

            ps.setObject(1, nn.getMaNguoiNhan());
            ps.setObject(2, nn.getId());
            ps.setObject(3, nn.getHoTen());
            ps.setObject(4, nn.getSdt());
            ps.setObject(5, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
