import java.io.*;
import java.net.*;
import java.util.*;
class TCPServer {
    public static void main(String argv[]) throws Exception{
        InputStream fileInput = null;
        OutputStream fileOutput = null;
        ServerSocket welcomeSocket = new ServerSocket(49152);
        while(true) {
            long a = 0;
            System.out.println("The server is waiting ");
            Socket connectionSocket = welcomeSocket.accept();
            Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
            fileInput = connectionSocket.getInputStream();

            a = System.currentTimeMillis();
            fileOutput = new FileOutputStream("/Users/wanchairoot/Documents/517312 Operating Systems/fileFromServer/Movie.mp4");

            byte[] bytes = new byte[1000000000];
            //byte data = 0;
            int index;
            while ((index = fileInput.read(bytes)) != -1) {
                fileOutput.write(bytes, 0 ,index);
            }
            double dvi = 1000.00;
            System.out.printf("%.2f second " ,(System.currentTimeMillis() - a)/1000.00 );
        }
    }
}
