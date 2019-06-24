package JAVAFileOperate.JAVAIoStream.SerializtionObject;

import java.io.*;

public class ObjectSeriaDemotwo {
    public static void main(String[] args) throws Exception {
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("File\\obj.dat"));
//        demo3 obj=new demo3();
//        oos.writeObject(obj);
//        oos.flush();
//        oos.close();


        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("File\\obj.dat"));
        demo3 obj= (demo3) ois.readObject();
        System.out.println(obj);
    }
}
class demo {
    public demo(){
        System.out.println("demo..");
    }
}

class demo2 extends demo implements Serializable{   //这里序列化 demo父类没有序列化，所以他的构造函数的信息没有被序列化，
                                                      //在readobj的时候不能重文件读到构造函数，所以要显示的调用demo的构造函数，
                                                    //所以只有demo的构造函数的内容输出了，而demo2 ,和demo3构造函数的内容都在序列化
                                                    //文件中，所以不需要调用构造函数
    public demo2(){
        System.out.println("demo2..");
    }
}

class demo3 extends demo2{
    public demo3(){
        System.out.println("demo3..");
    }
}
