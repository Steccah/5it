import java.net.*;
import java.io.*;

public class ClientEcho {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 6789);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Il server dice: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        client.close();
    }
}