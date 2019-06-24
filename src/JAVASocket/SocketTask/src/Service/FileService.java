package JAVASocket.SocketTask.src.Service;

import JAVASocket.SocketTask.src.Bean.UserFile;
import JAVASocket.SocketTask.src.Dao.FileDao;

import java.util.List;
import java.util.Set;

public class FileService {

    public String fileupload(UserFile userFile) {
        FileDao fileDao = new FileDao();
        String info = fileDao.uploadFile(userFile);
        return info;
    }
    public Set<UserFile> filedownload(UserFile userFile){
        FileDao fileDao = new FileDao();
        Set<UserFile> files=fileDao.downloadFile(userFile);
        return files;
    }
}
