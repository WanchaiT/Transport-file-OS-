import java.io.*;
import java.net.*;
import java.util.*;
class TCPServer {
    public static void main(String argv[]) throws Exception{
        InputStream fileInput = null;
        OutputStream fileOutput = null;
        ServerSocket welcomeSocket = new ServerSocket(49153);
        String path = "/Users/wanchairoot/Documents/517312 Operating Systems/a.zip";
        while(true) {
            System.out.println("The server is waiting ");
            Socket connectionSocket = welcomeSocket.accept();
            Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
            Scanner scan = new Scanner(System.in);
            fileInput = new FileInputStream(path);
            System.out.println(fileInput);
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            byte[] bytes = new byte[100000];
            int index;
            String req = inFromClient.nextLine();
            long a = System.currentTimeMillis();
            System.out.println(req);
            if(req.equals("zip")){
                while ((index = fileInput.read(bytes)) != -1) {
                    outToClient.write(bytes ,0 ,index);
                }
            }else{
                continue;
            }
            System.out.printf("%.2f second " ,(System.currentTimeMillis() - a)/1000.00 );
            connectionSocket.close();
            System.out.println("Finish");
            
        }
    }
}
