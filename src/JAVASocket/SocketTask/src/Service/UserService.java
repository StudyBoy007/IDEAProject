package JAVASocket.SocketTask.src.Service;


import JAVASocket.SocketTask.src.Bean.User;
import JAVASocket.SocketTask.src.Dao.UserDao;

import java.sql.Date;
import java.sql.Time;

public class UserService {

    public void registerService(User user) throws Exception {
        //调用dao层次进行数据库的一些操作
        Date date = new Date(new java.util.Date().getTime());
        Time time=new Time(new java.util.Date().getTime());
        String registerTime=date.toString()+"  "+time.toString();
        System.out.println(registerTime);
        user.setRegisyerTime(registerTime);
        UserDao userDao = new UserDao();
        User userByDao = userDao.selectUser(user.getUsername());
        if (userByDao == null) {
            userDao.registerDao(user);
            throw new Exception("注册成功！请登入~");
        } else if (userByDao != null) {
            throw new Exception("该用户名已存在，请重新输入！");
        }
    }

    public void loginService(User user) throws Exception {
        UserDao userDao = new UserDao();
        User userByDao = userDao.selectUser(user.getUsername());
        if (userByDao == null) {
            throw new Exception("该用户名或密码错误！请重新输入~");
        } else if (userByDao != null) {
            if (userByDao.getPassword().equals(user.getPassword())) {
                throw new Exception("登入成功！");
            } else {
                throw new Exception("该用户名或密码错误！请重新输入~");
            }
        }
    }

}
