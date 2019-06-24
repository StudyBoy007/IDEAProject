package JAVASocket.SocketTask.src.Dao;

import JAVASocket.SocketTask.src.Bean.UserFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileDao {
    public String uploadFile(UserFile userFile) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socket?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
            String sql = "insert into file(username,filesrc,filecontent,filesize)values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userFile.getUsername());
            ps.setString(2, userFile.getFileSrc());
            ps.setBytes(3, userFile.getBytes());
            ps.setInt(4, userFile.getFilesize());
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
        return "文件上传成功，再见！";
    }


    public Set<UserFile> downloadFile(UserFile userFile) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        List<UserFile> files =new ArrayList<>();
        HashSet<UserFile> files=new HashSet();
        UserFile file = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/socket?useUnicode=true" +
                            "&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
            String sql = "select *from file where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userFile.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                String filesrc = rs.getString("filesrc");
                byte[] bytes = rs.getBytes("filecontent");
                int filesize=rs.getInt("filesize");
                file = new UserFile();
                file.setBytes(bytes);
                file.setFileSrc(filesrc);
                file.setFilesize(filesize);
//                files.add(file);
                files.add(file);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return files;
    }
}
