import java.io.*;

public class Test18 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("File\\1.dat");
        PrintWriter pw=new PrintWriter(fos);

        FileInputStream fis=new FileInputStream("File\\1.dat");
        BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        fos.write(1);
        pw.println("ni hao");
        pw.flush();
//        int a=fis.read();
//        System.out.println(a);
       String line=br.readLine();
        System.out.println(line);
//        String a=br.readLine();
//        System.out.println(a);
//        a=br.readLine();
//        System.out.println(a);
    }

}
