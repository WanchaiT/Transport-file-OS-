import java.io.*;
import java.net.*;
import java.util.*;
class TCPClient {
    public static void main(String argv[]) throws Exception{
        long a = System.currentTimeMillis();

        String path = "/Users/wanchairoot/Documents/517312 Operating Systems/a.zip";
        InputStream file = new FileInputStream(path);
        byte[] bytes = new byte[1000000000];
        Socket clientSocket = new Socket("localhost", 49153);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        int index;
        int data = 0;
        while ((index = file.read(bytes)) != -1) {
            outToServer.write(bytes ,0 ,index);
            System.out.println(index);
        }
        clientSocket.close();
        System.out.printf("%.2f second " ,(System.currentTimeMillis() - a)/1000.00 );
    }
 }
