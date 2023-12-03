/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.MaVoucher;

/**
 *
 * @author Tom
 */
public class MaVoucherService {

    public List<MaVoucher> getAll() {
        String sql = """
                     SELECT [ID]
                           ,[PhanTramGiamGia]
                           ,[SoLuong]
                       FROM [dbo].[MaVoucher]
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<MaVoucher> dsma = new ArrayList<>();
            while (rs.next()) {
                MaVoucher mvc = new MaVoucher(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                dsma.add(mvc);
            }
            return dsma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(MaVoucher ma) {
        String sql = """
                INSERT INTO [dbo].[MaVoucher]
                           ([ID]
                           ,[PhanTramGiamGia]
                           ,[SoLuong])
                     VALUES
                           (?,?,?)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma.getId());
            ps.setObject(2, ma.getPhanTram());
            ps.setObject(3, ma.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(int id) {
        String sql = """
                     DELETE FROM [dbo].[MaVoucher]
                           WHERE ID=?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(MaVoucher mavc, int id) {
        String sql = """
                     UPDATE [dbo].[MaVoucher]
                        SET [ID]=?
                           ,[PhanTramGiamGia] = ?
                           ,[SoLuong] = ?
                      WHERE ID=?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mavc.getId());
            ps.setObject(2, mavc.getPhanTram());
            ps.setObject(3, mavc.getSoLuong());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        MaVoucherService mvc = new MaVoucherService();
        ArrayList<MaVoucher> list = (ArrayList<MaVoucher>) mvc.getAll();
        for (MaVoucher mnv : list) {
            System.out.println(mnv.toString());
        }
    }
}
