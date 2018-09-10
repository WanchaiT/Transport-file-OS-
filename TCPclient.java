import java.io.*;
import java.net.*;
import java.util.*;
class TCPClient {
    public static void main(String argv[]) throws Exception{
        Scanner scan = new Scanner(System.in);
        OutputStream fileOutput = new FileOutputStream("/Users/wanchairoot/Documents/517312 Operating Systems/fileFromServer/a.zip");
        byte[] bytes = new byte[100000];
        String req = scan.next();
        Socket clientSocket = new Socket("localhost", 49153);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(req + "\n");
        InputStream fileInput = clientSocket.getInputStream();
        int index;
        while ((index = fileInput.read(bytes)) != -1) {
            fileOutput.write(bytes ,0 ,index);
            System.out.println(index);
        }
        System.out.println("dd");
        clientSocket.close();
    }
 }
