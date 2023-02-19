import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://127.0.0.1/db1";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);


        //定义SQL语句
        String sql = "UPDATE account SET money=money+400 WHERE username='吴凯';";

        //获取执行SQL的对象
        Statement statement = connection.createStatement();


        try {
            //获取执行SQL的对象
            int count = statement.executeUpdate(sql);

            //处理结果
            System.out.println(count);
            connection.commit();

        } catch (SQLException throwables) {

            connection.rollback();
            throwables.printStackTrace();
        }
        //释放资源
        statement.close();
        connection.close();
    }
}
