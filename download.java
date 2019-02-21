import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.jnlp.*;


public class download {

  public static void main(String[] args) throws IOException {
         


         String fileName = "putty.exe"; //The file that will be saved on your computer
         URL link = new URL("https://the.earth.li/~sgtatham/putty/latest/w64/putty.exe"); //The file that you want to download
        
     //Code to download
         InputStream in = new BufferedInputStream(link.openStream());
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         byte[] buf = new byte[1024];
         int n = 0;
         while (-1!=(n=in.read(buf)))
         {
            out.write(buf, 0, n);
         }
         out.close();
         in.close();
         byte[] response = out.toByteArray();

         FileOutputStream fos = new FileOutputStream(fileName);
         fos.write(response);
         fos.close();
     //End download code
         
         System.out.println("Finished");
		 Process process = new ProcessBuilder("putty.exe").start();

    }

}
