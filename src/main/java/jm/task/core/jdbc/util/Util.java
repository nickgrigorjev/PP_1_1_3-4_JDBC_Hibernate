package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {
    private static final String URL ="jdbc:mysql://localhost:3306/usersdb";
    private static final String USERNAME ="nsgrigorjev";
    private static final String PASSWORD ="Jldq7fN09Kcn-F(W24";

    private Util() {

    }
    public static void LoadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
