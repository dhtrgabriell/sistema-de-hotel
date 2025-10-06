package model.DAO;

import java.sql.*;

public class ConnectionFactory {

    private static final String driver = "com.mysql.jbdc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/hotel";
    private static final String usuario = "root";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(banco + "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&USER=" + usuario + "&password=" + senha + "&serverTimezone=UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conexao) {
        try {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm) {
        try {
            pstm.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst) {
        try {
            pstm.close();
            rst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
