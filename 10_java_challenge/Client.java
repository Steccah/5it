import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("192.168.1.78", 5000);
        System.out.println("Connected to server");

        // in
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // out
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // read from server
        System.out.println("Server: " + in.readLine());

        // write to server
        out.println(4);

        // 8*8
        System.out.println("Server: " + in.readLine());
        System.out.println("Server: " + in.readLine());
        out.println(64);

        // random+random
        System.out.println("Server: " + in.readLine());
        String response = in.readLine();
        System.out.println("Server: " + response);
        response = response.replace("?", "");
        String[] parts = response.split("[+]");
        int sum = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        out.println(sum);
        System.out.println("out: " + sum);

        // random*random
        System.out.println("Server: " + in.readLine());
        response = in.readLine();
        System.out.println("Server: " + response);
        response = response.replace("?", "");
        parts = response.split("[*]");
        sum = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        out.println(sum);
        System.out.println("out: " + sum);

        // random+random
        System.out.println("Server: " + in.readLine());
        response = in.readLine();
        System.out.println("Server: " + response);
        response = response.replace("?", "");
        parts = response.split("[+]");
        sum = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        out.println(sum);
        System.out.println("out: " + sum);
        System.out.println("Server: " + in.readLine());

        // close
        client.close();
    }
}