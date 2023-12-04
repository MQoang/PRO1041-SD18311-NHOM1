/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.NhanVien;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienService {

    public List<NhanVien> getAll() {
        String sql= """
                    SELECT 
                                           
                                             N.MANV,
                                             L.ID,
                                             N.HOTEN,
                                             N.GioiTinh,
                                             N.NgaySinh,
                    			     N.ChucVu,
                    			     N.DiaChi,
                                             N.Email,           
                                             N.DienThoai,
                                             N.GhiChu,                                            
                                             N.NgayTuyen,
                                             L.LuongCoBan,
                                             L.ThoiGianLam,
                                             L.CaLam
                                       
                                         FROM
                                             NhanVien N
                                         JOIN
                                             LuongNV L ON N.ID = L.ID;
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVien> list = new ArrayList<>();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4),rs.getObject(5, LocalDate.class)
                        , rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getObject(11, LocalDate.class), rs.getInt(12), rs.getInt(13), rs.getInt(14));
              
                        list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 public boolean AddNhanVien(NhanVien nv) {
        String sql = """
                    INSERT INTO [dbo].[NhanVien]
                                    ([MANV]
                                    ,[ID]
                                    ,[HOTEN]
                                    ,[GioiTinh]
                                    ,[NgaySinh]
                                    ,[Email]
                                    ,[DiaChi]
                                    ,[DienThoai]
                                    ,[GhiChu]
                                    ,[ChucVu]
                                    ,[NgayTuyen])
                              VALUES
                               (?,?,?,?,?,?,?,?,?,?,?)
                    """;

        int chek = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {

            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getId());
            ps.setObject(3, nv.getTenNV());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSđt());
            ps.setObject(9, nv.getChuThich());
            ps.setObject(10, nv.getChucVu());
            ps.setObject(11, nv.getNgayTuyen());

            chek = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }
 
 public boolean XoaNV(String ma) {
        String sql = """
                    DELETE FROM [dbo].[NhanVien]
                                     WHERE MANV =?
                    """;

        int chek = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {

            ps.setObject(1, ma);

            chek = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }
 public boolean Update(NhanVien nv ,String ma){
     
     
     String sql="""
                UPDATE [dbo].[NhanVien]
                   SET [MANV] = ?
                      ,[ID] = ?
                      ,[HOTEN] = ?
                      ,[GioiTinh] = ?
                      ,[NgaySinh] = ?
                      ,[Email] = ?
                      ,[DiaChi] = ?
                      ,[DienThoai] = ?
                      ,[GhiChu] = ?
                      ,[ChucVu] = ?
                      ,[NgayTuyen] = ?
                 WHERE MANV =?
                """;
      int chek = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {

            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getId());
            ps.setObject(3, nv.getTenNV());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getNgaySinh());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSđt());
            ps.setObject(9, nv.getChuThich());
            ps.setObject(10, nv.getChucVu());
            ps.setObject(11, nv.getNgayTuyen());
            ps.setObject(12, ma);

            chek = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
 }
    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienService().getAll();
        for (NhanVien nhanVien : list) {
            System.out.println(nhanVien.toString());
        }
    }
    
      public List<NhanVien> search(String TenNv, String MAnv) {
        String sql = """
                  SELECT 
                                                                
                                                                  N.MANV,
                                                                  L.ID,
                                                                  N.HOTEN,
                                                                  N.GioiTinh,
                                                                  N.NgaySinh,
                                         			     N.ChucVu,
                                         			     N.DiaChi,
                                                                  N.Email,           
                                                                  N.DienThoai,
                                                                  N.GhiChu,                                            
                                                                  N.NgayTuyen,
                                                                  L.LuongCoBan,
                                                                  L.ThoiGianLam,
                                                                  L.CaLam
                                                            
                                                              FROM
                                                                  NhanVien N
                                                              JOIN
                                                                  LuongNV L ON N.ID = L.ID 
                     WHERE N.MANV =? OR N.HOTEN =?
                     
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, TenNv);
            ps.setObject(2, MAnv);

            ResultSet rs = ps.executeQuery();
            List<NhanVien> listD = new ArrayList<>();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4),rs.getObject(5, LocalDate.class)
                        , rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getObject(11, LocalDate.class), rs.getInt(12), rs.getInt(13), rs.getInt(14));
              
                        listD.add(nv);
            }
            return listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
       public ArrayList<NhanVien> findByCVTUVAN() {
        String sql = """
                         SELECT 
                                                                                                                
                                                                                                                  N.MANV,
                                                                                                                  L.ID,
                                                                                                                  N.HOTEN,
                                                                                                                  N.GioiTinh,
                                                                                                                  N.NgaySinh,
                                                                                         			  N.ChucVu,
                                                                                         			  N.DiaChi,
                                                                                                                  N.Email,           
                                                                                                                  N.DienThoai,
                                                                                                                  N.GhiChu,                                            
                                                                                                                  N.NgayTuyen,
                                                                                                                  L.LuongCoBan,
                                                                                                                  L.ThoiGianLam,
                                                                                                                  L.CaLam
                                                                                                            
                                                                                                              FROM
                                                                                                                  NhanVien N
                                                                                                              JOIN
                                                                                                                  LuongNV L ON N.ID = L.ID                   	  
                                                WHERE LuongCoBan BETWEEN 5000000 AND 6000000
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
             List<NhanVien> listD = new ArrayList<>();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4),rs.getObject(5, LocalDate.class)
                        , rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getObject(11, LocalDate.class), rs.getInt(12), rs.getInt(13), rs.getInt(14));
              
                        listD.add(nv);
            }
            return (ArrayList<NhanVien>) listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        public ArrayList<NhanVien> findBy7tr8tr() {
        String sql = """
                         SELECT 
                                                                                                                
                                                                                                                  N.MANV,
                                                                                                                  L.ID,
                                                                                                                  N.HOTEN,
                                                                                                                  N.GioiTinh,
                                                                                                                  N.NgaySinh,
                                                                                         			     N.ChucVu,
                                                                                         			     N.DiaChi,
                                                                                                                  N.Email,           
                                                                                                                  N.DienThoai,
                                                                                                                  N.GhiChu,                                            
                                                                                                                  N.NgayTuyen,
                                                                                                                  L.LuongCoBan,
                                                                                                                  L.ThoiGianLam,
                                                                                                                  L.CaLam
                                                                                                            
                                                                                                              FROM
                                                                                                                  NhanVien N
                                                                                                              JOIN
                                                                                                                  LuongNV L ON N.ID = L.ID                   	  
                                                WHERE LuongCoBan BETWEEN 7000000 AND 10000000
                     """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
             List<NhanVien> listD = new ArrayList<>();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4),rs.getObject(5, LocalDate.class)
                        , rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getObject(11, LocalDate.class), rs.getInt(12), rs.getInt(13), rs.getInt(14));
              
                        listD.add(nv);
            }
            return (ArrayList<NhanVien>) listD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
