import java.io.*;
import java.net.*;
import java.util.*;
class TCPServer {
    public static void main(String argv[]) throws Exception{
        InputStream fileInput = null;
        OutputStream fileOutput = null;
        ServerSocket welcomeSocket = new ServerSocket(49153);
        while(true) {
            System.out.println("The server is waiting ");
            Socket connectionSocket = welcomeSocket.accept();
            System.out.printf("%d " ,(System.currentTimeMillis()) );
            Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
            Scanner scan = new Scanner(System.in);
            fileInput = connectionSocket.getInputStream();
            System.out.printf("%d second " ,(System.currentTimeMillis()));
            System.out.println(fileInput);
            fileOutput = new FileOutputStream("/Users/wanchairoot/Documents/517312 Operating Systems/fileFromServer/a.zip");
            byte[] bytes = new byte[10000];
            int index;
            while ((index = fileInput.read(bytes)) != -1) {
                fileOutput.write(bytes ,0 ,index);
                System.out.println(index);
                System.out.printf("%d second " ,(System.currentTimeMillis()));
            }
            System.out.printf("%d second " ,(System.currentTimeMillis()));

            System.out.println("Finish");
            if (scan.next().equals("exit")) {
                connectionSocket.close();
                System.exit(0);
            }
        }
    }
}
