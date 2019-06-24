package JAVASocket.SocketTask.src.SocketTaskPackage;

import sun.applet.Main;

import java.io.OutputStream;
import java.util.Arrays;

public class ByetAdd {
    public byte[] byteADD(byte[] bytesBerofe, byte[] bytesAfter) {
        int num = 0;
        int num1 = 0;
        int sizeBefore = bytesBerofe.length;
        int szieAfter = bytesAfter.length;
        byte[] bytes = new byte[sizeBefore + szieAfter];
        for (int i = 0; i < sizeBefore + szieAfter; i++) {
            if (num < sizeBefore) {
                bytes[i] = bytesBerofe[num];
                num++;
            } else {
                if (num1 < szieAfter) {
                    bytes[i] = bytesAfter[num1];
                    num1++;
                }
            }
        }
        return bytes;
    }

    public byte[] smallByte(int size,byte[]bytes){
        byte[]bytesNew=new byte[size];
        for (int i=0;i<size;i++){
            bytesNew[i]=bytes[i];
        }
        return bytesNew;
    }

    public static void main(String[] args) {
        byte[]bytes1=new byte[0];
        System.out.println(Arrays.toString(bytes1));
        System.out.println(bytes1.length);
        byte[]bytes2="哈哈".getBytes();
        System.out.println(Arrays.toString(bytes2));
        System.out.println(bytes2.length);
        ByetAdd obj=new ByetAdd();
       byte[]bytes=obj.byteADD(bytes1, bytes2);
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes.length);
    }
}

