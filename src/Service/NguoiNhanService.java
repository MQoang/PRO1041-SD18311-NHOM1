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

    public List<NguoiNhan> getAllNguoiNhan() {

        String sql = """
                    SELECT NguoiNhanHang.MaNguoiNhan,NguoiNhanHang.Id,NguoiNhanHang.HoTen,NguoiNhanHang.DienThoai,DiaChiGiaoHang.MaDiaChi,DiaChiGiaoHang.DiaChi,DiaChiGiaoHang.GhiChu 
                        FROM NguoiNhanHang INNER JOIN DiaChiGiaoHang ON NguoiNhanHang.Id = DiaChiGiaoHang.Id
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            List<NguoiNhan> list = new ArrayList<>();
            while (rs.next()) {
                NguoiNhan nn = new NguoiNhan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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
                                    ,[Id]
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

    public Boolean XoaNguoiNhan(String ma) {
        String sql = """
                    DELETE FROM [dbo].[NguoiNhanHang]
                                        WHERE MaNguoiNhan = ?
                    """;

        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean UpdateNguoiNhan(NguoiNhan nn, String ma) {
        String sql = """
                   UPDATE [dbo].[NguoiNhanHang]
                                   SET [MaNguoiNhan] = ?
                                      ,[Id] = ?
                                      ,[HoTen] = ?
                                      ,[DienThoai] = ?
                                   WHERE MaNguoiNhan = ?
                    """;

        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {

            ps.setObject(1, nn.getMaNguoiNhan());
            ps.setObject(2, nn.getId());
            ps.setObject(3, nn.getHoTen());
            ps.setObject(4, nn.getSdt());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
