package JAVASocket.SocketTask.src.SocketTaskPackage;


import JAVASocket.SocketTask.src.Bean.SaveObject;
import JAVASocket.SocketTask.src.Bean.User;
import JAVASocket.SocketTask.src.Bean.UserFile;
import JAVASocket.SocketTask.src.Service.FileService;
import JAVASocket.SocketTask.src.Service.UserService;


import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Set;

public class ServerThread extends Thread {
    public Socket socket;
    private InputStream is;
    private OutputStream os;
    private PrintWriter pw;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;


    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //接收客户端发来的消息
//            is = socket.getInputStream();
//            ois = new ObjectInputStream(is);
//            SaveObject saveObject = (SaveObject) ois.readObject();
            SaveObject saveObject = receiveObject();

            //调用UserService来进行业务逻辑处理
            if ((saveObject.getObject() instanceof User)) {
                User user = (User) saveObject.getObject();
                if (user.getCmd().equals("register")) {
                    UserService userService = new UserService();
                    try {
                        userService.registerService(user);
                    } catch (Exception e) {
                        //                    String info = e.getMessage();
                        //                    os = socket.getOutputStream();
                        //                    pw = new PrintWriter(os);
                        //                    pw.println(info);
                        senddata(e.getMessage());
                    }
                }

                if (user.getCmd().equals("login")) {
                    UserService userService = new UserService();
                    try {
                        userService.loginService(user);
                    } catch (Exception e) {
                        senddata(e.getMessage());
                    }
                }
            }

            if ((saveObject.getObject() instanceof UserFile)) {
                UserFile userFile = (UserFile) saveObject.getObject();
                if (userFile.getCmd().equals("upload")) {
                    FileService fileService = new FileService();

                    String info = fileService.fileupload(userFile);
                    senddata(info);
                }
                if (userFile.getCmd().equals("download")) {
                    FileService fileService = new FileService();

                    Set<UserFile> files = fileService.filedownload(userFile);

                    int size = files.size();
                    System.out.println("集合长度为："+size);
                    senddata(size);
                    for (UserFile file : files) {
                        sendObject(file);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

    }

    //关闭资源方法
    public void closeResource() {
        try {
            if (pw != null)
                pw.close();
            if (os != null)
                os.close();
            if (ois != null)
                ois.close();
            if (oos != null)
                oos.close();
            if (is != null)
                is.close();
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SaveObject receiveObject() throws IOException, ClassNotFoundException {
        is = socket.getInputStream();
        ois = new ObjectInputStream(is);
        SaveObject obj = (SaveObject) ois.readObject();
        socket.shutdownInput();
        return obj;
    }

    public void senddata(Object object) throws IOException {
        os = socket.getOutputStream();
        pw = new PrintWriter(os);
        pw.println(object);
        pw.flush();
    }

    public void sendObject(Object object) throws IOException {
        OutputStream os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        oos.writeObject(object);
    }
}
