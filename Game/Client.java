import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // ممكن تغيره لـ IP السيرفر لو شغال على جهاز تاني
        int port = 12345;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server. Type rock/paper/scissors or quit to exit.");

            while (true) {
                System.out.print("Your choice: ");
                String choice = scanner.nextLine().toLowerCase();

                out.println(choice);

                if (choice.equals("quit")) {
                    break;
                }

                String response = in.readLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
