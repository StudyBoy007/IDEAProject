package JAVASocket.SocketTask.src.Bean;

import java.io.Serializable;
import java.util.Arrays;

public class UserFile implements Serializable {
    private String fileSrc;
    private byte[]bytes;
    private String  username;
    private String cmd;
    private int filesize;

    public UserFile() {
    }

    public UserFile(String fileSrc, byte[] bytes, String username) {
        this.fileSrc = fileSrc;
        this.bytes = bytes;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "UserFile{" +
                "fileSrc='" + fileSrc + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                ", username='" + username + '\'' +
                ", cmd='" + cmd + '\'' +
                ", filesize=" + filesize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserFile)) return false;

        UserFile userFile = (UserFile) o;

        return fileSrc != null ? fileSrc.equals(userFile.fileSrc) : userFile.fileSrc == null;
    }

    @Override
    public int hashCode() {
        return fileSrc != null ? fileSrc.hashCode() : 0;
    }
}
