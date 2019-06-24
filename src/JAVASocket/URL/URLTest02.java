package JAVASocket.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest02 {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
            InputStream is = url.openStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);

            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
