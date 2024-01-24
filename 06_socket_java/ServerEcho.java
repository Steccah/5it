import java.net.*;
import java.io.*;

public class ServerEcho {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        Socket newconnection = server.accept();
        PrintWriter out = new PrintWriter(newconnection.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(newconnection.getInputStream()));
        String inputLine;
        int i = 0;
        while ((inputLine = in.readLine()) != null) {
            i++;
            out.println(i + " " + inputLine);
        }
        out.close();
        in.close();
        newconnection.close();
        server.close();
    }
}