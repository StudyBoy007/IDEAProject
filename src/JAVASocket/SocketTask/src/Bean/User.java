package JAVASocket.SocketTask.src.Bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class User implements Serializable {
    private String username;
    private String password;
    //    private java.sql.Date dob;
    private String cmd;
    //    private Time time;
    private String regisyerTime;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRegisyerTime() {
        return regisyerTime;
    }

    public void setRegisyerTime(String regisyerTime) {
        this.regisyerTime = regisyerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
