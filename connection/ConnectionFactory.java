package connection;

import java.sql.*;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/urna?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";


    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro de conexão ", ex);
        }
    }

    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt)  {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs ){
        closeConnection(con, stmt, rs);
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
