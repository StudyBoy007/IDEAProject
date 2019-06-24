package JAVASocket.SocketTask.src.SocketTaskPackage;


import JAVASocket.SocketTask.src.Bean.SaveObject;
import JAVASocket.SocketTask.src.Bean.User;
import JAVASocket.SocketTask.src.Bean.UserFile;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Client {
    private Scanner input;
    private Socket socket = null;
    private InputStream is = null;
    private OutputStream os = null;
    private ObjectOutputStream oos = null;
    private InputStreamReader isr = null;
    private BufferedReader br = null;
    private FileInputStream fis = null;
    private BufferedInputStream bis = null;
    private ObjectInputStream ois = null;
    private BufferedOutputStream bos = null;


    public Client() {
        this.input = new Scanner(System.in);
    }


    public void showMenu() {
        System.out.println("*****欢迎使用文件上传器*****");
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("1.登陆\n2.注册\n3.退出");
                System.out.println("*************************");
                System.out.println("请选择：");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        System.out.println("感谢你对本系统的支持！欢迎下次使用~");
                        System.exit(0);
                    default:
                        System.out.println("你的输入有误！请重新输入~");
                        showMenu();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数!");
            }
        }
    }

    public void register() {
        User user = new User();
        String cmd = "register";
        user.setCmd(cmd);
        while (true) {
            System.out.println("请输入用户名：");
            user.setUsername(input.next());
            System.out.println("请输入密码");
            user.setPassword(input.next());
            System.out.println("请再次输入密码：");
            String password = input.next();
            if (!user.getPassword().equals(password)) {
                System.out.println("两次输入的密码不一致，请重新输入！");
                continue;
            }
            break;
        }

        try {
            socket = new Socket("localhost", 8099);
//                os = socket.getOutputStream();
//                oos = new ObjectOutputStream(os);
//                oos.writeObject(user);
//                socket.shutdownOutput();//关闭输入流
            //发送对象给服务端
            sendObject(user);

            //接受服务器发来的消息
//                is=socket.getInputStream();
//                isr=new InputStreamReader(is);
//                br=new BufferedReader(isr);
//                String info;
//                while ((info=br.readLine())!=null){
//                    System.out.println(info);
//                }
            //接受服务端反馈的消息
            receivedata();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            closeResource();
        }
        //注册完成后执行登入操作
        login();
    }

    public void login() {
        String cmd = "login";
        User user = new User();
        user.setCmd(cmd);
        int count = 0;
        count++;
        if (count == 3) {
            System.exit(0);
        }
        System.out.println("请输入用户名：");
        user.setUsername(input.next());
        System.out.println("请输入密码");
        user.setPassword(input.next());

        try {
            //发送对象给服务端
            socket = new Socket("localhost", 8099);

            sendObject(user);

            //接受服务端反馈的消息
            receivedata();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }
        selectUtility(user);
    }

    public void selectUtility(User user) {
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("*****文件的操作有如下选择*****");
                System.out.println("1.上传文件\n2.下载文件\n3.退出");
                System.out.println("*************************");
                System.out.println("请选择：");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        fileToDateBase(user);
                    case 2:
                        filedownloadinDataBase(user);
                    case 3:
                        System.out.println("感谢你对本系统的支持！欢迎下次使用~");
                        System.exit(0);
                    default:
                        System.out.println("你的输入有误！请重新输入~");
                        selectUtility(user);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("输入格式不正确！请重新输入~");
            }
        }
    }

    //下载文件的方法
    public void filedownloadinDataBase(User user) {
        List<UserFile> files = new ArrayList<>();
        try {
            socket = new Socket("localhost", 8099);
            UserFile file = new UserFile();
            file.setUsername(user.getUsername());
            file.setCmd("download");
            sendObject(file);

            //接受文件
            String info = receivedataTwo(user);
            int size = Integer.valueOf(info);
            for (int i = 0; i < size; i++) {
                UserFile file1 = (UserFile) receiveObject();
                files.add(file1);
            }
            for (UserFile userFile : files) {
                System.out.println("在集合中的索引为：" + files.indexOf(userFile));
            }
            for (UserFile userfile : files) {
                String name = userfile.getFileSrc();
                int index = name.lastIndexOf("/");
                String filename = name.substring(index + 1);
                int big = userfile.getBytes().length;
                System.out.println((files.indexOf(userfile) + 1) + ":" + "名称-->" + name + ",文件大小-->" + big);
            }
            while (true) {
                try {
                    System.out.println("请输入想要下载的文件序号：");
                    Scanner input = new Scanner(System.in);
                    int a = input.nextInt();
                    if (a > size) {
                        throw new Exception("你的输入超出了选择范围，请重新输入！");
                    }
                    while (true) {
                        try {
                            System.out.println("文件选择成功！请输入文件的安装目录！!");
                            Scanner input1 = new Scanner(System.in);
                            String url = input1.next();
                            File filesrc = new File(url);
                            int index = url.lastIndexOf("/");
                            String urlDir = url.substring(0, index + 1);
                            File fileDir = new File(urlDir);
                            if (!fileDir.isDirectory()) {
                                throw new IllegalArgumentException("该文件路径不是目录，请重新输入！");
                            }
                            UserFile file1 = files.get(a - 1);
                            bos = new BufferedOutputStream(new FileOutputStream(filesrc));
                            bos.write(file1.getBytes(), 0, file1.getFilesize());
                            bos.flush();
                            System.out.println("文件下载成功！请选择接下来的操作~");
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("请输入有误，请输入整数！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            selectUtility(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }
    }

//  //上传文件的方法
//    public void fileSend(User user) {
//        System.out.println("请输入上传文件的绝对路径(如e:/imooc/dog.jpg)");
//        user.setCmd("upload");
//        String src = null;
//        while (true) {
//            src = input.next();
//            File file = new File(src);
//            if (!file.exists()) {
//                System.out.println("该文件不存在，请重新输入！");
//                continue;
//            }
//            if (!file.isFile()) {
//                System.out.println("该文件不是文件，请重新输入！");
//            }
//            break;
//        }
//        try {
//            fis = new FileInputStream(src);
//            bis = new BufferedInputStream(fis);
//            byte[] bytes = new byte[20 * 1024];
////            bis.read(bytes,0 ,bytes.length );
//            int a;
//            while ((a = bis.read(bytes, 0, bytes.length)) != -1) {
//            }
//            UserFile userFile = new UserFile();
//            //给UserFile对象赋值
//            userFile.setUsername(user.getUsername());
//            userFile.setFileSrc(src);
//            userFile.setBytes(bytes);
//
//            //将对象发送给服务端
//            socket = new Socket("localhost", 8099);
//            os = socket.getOutputStream();
//            oos = new ObjectOutputStream(os);
//            oos.writeObject(user);
//            oos.writeObject(userFile);
//            oos.flush();
//            socket.shutdownOutput();
//
//            //服务端的响应
//            receiveString();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeResource();
//        }
//
//    }

    public void fileToDateBase(User user) {
        System.out.println("请输入上传文件的绝对路径(如e:/imooc/dog.jpg)");
        File file = null;
        String src;
        while (true) {
            src = input.next();
            file = new File(src);
            if (!file.exists()) {
                System.out.println("该路径的文件不存在，请重新输入！");
                continue;
            }
            if (!file.isFile()) {
                System.out.println("该路径不是文件！请重新输入！");
                continue;
            }
            break;
        }
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[1024];
            byte[]bytesAll=new byte[0];
            int b;
            int num = 0;
            while ((b = bis.read(bytes, 0, bytes.length)) != -1) {
                num = num + b;
                ByetAdd obj=new ByetAdd();
                if (b<bytes.length){
                    byte[]bytesNew=obj.smallByte(b, bytes);
                    bytesAll=obj.byteADD(bytesAll, bytesNew);
                    break;
                }
                bytesAll=obj.byteADD(bytesAll, bytes);
            }
            System.out.println(bytesAll.length);
            UserFile file1 = new UserFile(src, bytesAll, user.getUsername());
            file1.setFilesize(num);
            file1.setCmd("upload");
            socket = new Socket("localhost", 8099);
            sendObject(file1);

            receivedata();
            selectUtility(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResource();
        }

    }

//    public void fileToDateBase(User user) {
//        System.out.println("请输入上传文件的绝对路径(如e:/imooc/dog.jpg)");
//        File file = null;
//        String src;
//        while (true) {
//            src = input.next();
//            file = new File(src);
//            if (!file.exists()) {
//                System.out.println("该路径的文件不存在，请重新输入！");
//                continue;
//            }
//            if (!file.isFile()) {
//                System.out.println("该路径不是文件！请重新输入！");
//                continue;
//            }
//            break;
//        }
//        try {
//            fis = new FileInputStream(file);
//            bis = new BufferedInputStream(fis);
//            byte[] bytes = new byte[2 * 1024 * 1024];
//            int b;
//            int num = 0;
//            while ((b = bis.read(bytes, 0, bytes.length)) != -1) {
//                num = num + b;
//            }
//            UserFile file1 = new UserFile(src, bytes, user.getUsername());
//            file1.setFilesize(num);
//            file1.setCmd("upload");
//            socket = new Socket("localhost", 8099);
//            sendObject(file1);
//
//            receivedata();
//            selectUtility(user);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeResource();
//        }
//
//    }

    //关闭资源方法
    public void closeResource() {
        try {
            if (bis != null)
                bis.close();
            if (fis != null)
                fis.close();
            if (br != null)
                br.close();
            if (isr != null)
                isr.close();
            if (is != null)
                is.close();
            if (oos != null)
                oos.close();
            if (ois != null)
                ois.close();
            if (os != null)
                os.close();
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) throws IOException {
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        SaveObject saveObject = new SaveObject();
        saveObject.setObject(object);
        oos.writeObject(saveObject);
    }

    public String receivedata() throws IOException {
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        String info = br.readLine();
        System.out.println(info);
        if (info.equals("该用户名已存在，请重新输入！")) {
            register();
        }

        if (info.equals("该用户名或密码错误！请重新输入~")) {
            login();
        }
        System.out.println("*************************");
        return info;
    }

    public String receivedataTwo(User user) throws IOException {
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        String info = br.readLine();
        System.out.println(user.getUsername() + "用户存在数据库中的文件共有" + info + "个！");
        if (info.equals("0")) {
            System.out.println("该用户在数据库中没有文件可以下载，请重新选择操作！");
            selectUtility(user);
        }
        return info;
    }

    public Object receiveObject() throws IOException, ClassNotFoundException {
        InputStream is = socket.getInputStream();
        ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        return obj;
    }
}