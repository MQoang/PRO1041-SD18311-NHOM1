package Service;

import Model.PhieuDoi;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuDoiService {

    ArrayList<PhieuDoi> listPD = new ArrayList<>();

    public ArrayList<PhieuDoi> sapXep() {
        String Query = """
                        select*from PhieuDoiChiTiet order by TenKhachHang asc 
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ResultSet rs = ps.executeQuery();
            List<PhieuDoi> list = new ArrayList<>();
            while (rs.next()) {
                PhieuDoi PD = new PhieuDoi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                list.add(PD);
            }
            return (ArrayList<PhieuDoi>) list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listPD;
    }
    public ArrayList<PhieuDoi> getAll() {
        String Query = """
                        SELECT * FROM PhieuDoiChiTiet
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ResultSet rs = ps.executeQuery();
            List<PhieuDoi> list = new ArrayList<>();
            while (rs.next()) {
                PhieuDoi PD = new PhieuDoi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                list.add(PD);
            }
            return (ArrayList<PhieuDoi>) list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listPD;
    }

    public boolean ThemPD(PhieuDoi pd) {
        int check = 0;
        String Query = """
                        INSERT INTO PhieuDoiChiTiet(MaPhieuDoiChiTiet,TenKhachHang,TenSanPham,GiaBan,NgayDoi,TenLyDoDoi,LyDoDoiChiTiet) VALUES (?,?,?,?,?,?,?)
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ps.setObject(1, pd.getMaPhieuDoi());
            ps.setObject(2, pd.getTenKhachHang());
            ps.setObject(3, pd.getTenSanPham());
            ps.setObject(4, pd.getGiaBan());
            ps.setObject(5, pd.getNgayDoi());
            ps.setObject(6, pd.getLyDoDoi());
            ps.setObject(7, pd.getLyDoDoiChiTiet());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean XoaPhieuDoi(String mapd) {
        int check = 0;
        String Query = """
                        DELETE FROM [dbo].[PhieuDoiChiTiet]
                                  WHERE MaPhieuDoiChiTiet =?
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ps.setObject(1, mapd);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean SuaPD(PhieuDoi pd, String maPD) {
        int check = 0;
        String Query = """
                        UPDATE [dbo].[PhieuDoiChiTiet]
                                SET 
                                   [TenKhachHang] = ?
                                   ,[TenSanPham] = ?
                                   ,[GiaBan] = ?
                                   ,[NgayDoi] = ?
                                   ,[TenLyDoDoi] = ?
                                   ,[LyDoDoiChiTiet] = ?
                              WHERE [MaPhieuDoiChiTiet] = ?
                      """;
        try (Connection con = jdbc.getConnection(); PreparedStatement ps = con.prepareStatement(Query)) {
            ps.setObject(1, pd.getTenKhachHang());
            ps.setObject(2, pd.getTenSanPham());
            ps.setObject(3, pd.getGiaBan());
            ps.setObject(4, pd.getNgayDoi());
            ps.setObject(5, pd.getLyDoDoi());
            ps.setObject(6, pd.getLyDoDoiChiTiet());
            ps.setObject(7, maPD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public ArrayList<PhieuDoi> Sapxep() {
//        listPD.sort((o1, o2) -> {
//            return o2.getTenKhachHang() - o1.getTenKhachHang();
//        });
//        return listPD;
//    }
}
