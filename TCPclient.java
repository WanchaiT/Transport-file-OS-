import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Timer;
class TCPClient {
    public static void main(String argv[]) throws Exception{
        long a = System.currentTimeMillis();

        String sentence;
        String modifiedSentence;
        Scanner inFromUser = new Scanner(System.in);
        Socket clientSocket = new Socket("localhost", 49152);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        Scanner inFromServer = new Scanner (clientSocket.getInputStream());
        System.out.print("Please enter words: ");
        sentence = inFromUser.nextLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.nextLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();

        System.out.println(System.currentTimeMillis() - a);
    }
 }
