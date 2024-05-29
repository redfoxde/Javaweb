import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "fushiyuchen");

            try {
                Statement statement = connection.createStatement();

                try {
                    int i = statement.executeUpdate("insert into rooms values(10122002,102,'标准间',120,0.86,'已预定')");
                    System.out.println("生效了" + i + "行！");
                } catch (Throwable var7) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var6) {
                            var7.addSuppressed(var6);
                        }
                    }

                    throw var7;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var8) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var5) {
                        var8.addSuppressed(var5);
                    }
                }

                throw var8;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var9) {
            SQLException ex = var9;
            ex.printStackTrace();
        }

    }
}
