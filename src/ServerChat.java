import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerChat {
    private static final int PORT = 8190;
    private static ServerSocket server;
    private static Socket socket;



    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter out1 = new PrintWriter(socket.getOutputStream(), true);
            while (true) {

                try {

                    String str = sc.nextLine();
                    out1.println("ECHO: ");

                    if (str.equals("/end")) {
                        System.out.println("Client disconnected");


                    }

                    System.out.println("Client: " + str);
                    String str2 = sc.nextLine();
                    out1.println(str2);

                } catch (Exception e) {

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

