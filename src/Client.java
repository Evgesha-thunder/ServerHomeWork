
    import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

    public class Client {
        private static final int PORT = 8190;
        private static Socket socket;
        private static final String IP_ADDRESS = "localhost";

        public static void main(String[] args) {
            try {
                socket = new Socket(IP_ADDRESS, PORT);


                Scanner sc = new Scanner(socket.getInputStream());

                Scanner scanner1 = new Scanner(System.in);
                String str = scanner1.nextLine();

                new Thread(() -> {

                    try {


                        PrintWriter out2 = new PrintWriter(socket.getOutputStream(),true);
                        out2.println(str);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }).start();


            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


