import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Vector<PrintWriter> clientWriters = new Vector<>(); // Store writers for all connected clients

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming client connections
                System.out.println("Client connected: " + clientSocket);

                // Create a new thread to handle communication with the client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Class to handle communication with a client
    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter writer;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);

                // Add this client's writer to the set
                synchronized (clientWriters) {
                    clientWriters.add(writer);
                }

                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Message from " + clientSocket.getInetAddress() + ": " + inputLine);

                    // Broadcast the message to all connected clients
                    synchronized (clientWriters) {
                        for (PrintWriter clientWriter : clientWriters) {
                            clientWriter.println(clientSocket.getInetAddress() + ":" + inputLine);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // Remove this client's writer from the set
                if (writer != null) {
                    synchronized (clientWriters) {
                        clientWriters.remove(writer);
                    }
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
