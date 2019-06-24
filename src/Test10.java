
import java.io.*;

public class Test10 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("File\\test03.dat")));
        PrintWriter pw=new PrintWriter(new File("File\\test03.dat"));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("File\\test03.dat")));
//        pw.println("ni hao");
//        pw.println("hello");
//        pw.flush();
        bw.write("ni hao");
        bw.newLine();
        bw.write("hello");
        bw.flush();
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        pw.close();
    }
}
