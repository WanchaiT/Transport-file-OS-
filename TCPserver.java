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
            //DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            fileInput = new FileInputStream(inFromClient.nextLine());
            a = System.currentTimeMillis();
            fileOutput = new FileOutputStream("/Users/wanchairoot/Documents/517312 Operating Systems/fileFromServer/Movie.mp4");

            byte[] bytes = new byte[1000000000];
            int index;

            while ((index = fileInput.read(bytes)) != -1) {
                fileOutput.write(bytes, 0, index);
            }
            System.out.println((System.currentTimeMillis() - a) / 1000 + " second");
            /*capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);*/
        }
      }
  }
