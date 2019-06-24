package JAVASocket.SocketTask.src.Dao;

import JAVASocket.SocketTask.src.Bean.User;

import java.sql.*;

public class UserDao {

    //通过用户名字查找用户的方法
    public User selectUser(String username) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socket?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
            String sql = "select *from user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("username");
                String password = rs.getString("password");
                user = new User();
                user.setUsername(name);
                user.setPassword(password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public void registerDao(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socket?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
            String sql = "insert into user(username,password,date)values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRegisyerTime());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
