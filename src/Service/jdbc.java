package Service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class jdbc {

    public static void main(String[] args) {
        Connection conn = getConnection();
//        System.out.println(conn);
    }

    public static Connection getConnection() {
        String Url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn;encrypt = false";
        String User = "sa";
        String Pass = "12345";
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(Url, User, Pass);
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM HoaDon";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
//                String Ma = rs.getString("Ma");
//                String HoTen=rs.getString("HoTen");
//                String Diem = rs.getString("Diem");
//                String nganh = rs.getString("nganh");
//                String GioiTinh = rs.getString("gioiTinh");
                
//                System.out.print("Ma:"+Ma);
//                System.out.print(",passwords:"+HoTen);
//                System.out.print(",setSelected(true):"+Diem);
//                System.out.print(",passwords:"+nganh);
//                System.out.println(",roles:"+GioiTinh);
            }
//            rs.close();stm.close();conn.close()PreparedStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
