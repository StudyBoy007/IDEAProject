package JAVAFileOperate.JAVAIoStream.SerializtionObject;

import java.io.*;

public class ObjectSerializableDemo {
    public static void main(String[] args) {
        String file = "File\\seria.dat";
        try {
          // ObjSerial(file);
           ObjReverSerial(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void ObjSerial(String file) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("310", "tom", 18);
        oos.writeObject(stu);
        oos.flush();
        oos.close();
    }

    public static void ObjReverSerial(String file) throws Exception {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
            ois.close();
    }
}
