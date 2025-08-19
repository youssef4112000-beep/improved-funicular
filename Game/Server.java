import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientChoice;
            while ((clientChoice = in.readLine()) != null) {
                if (clientChoice.equalsIgnoreCase("quit")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                String serverChoice = choices[random.nextInt(choices.length)];
                String result = getResult(clientChoice, serverChoice);

                out.println("Server chose: " + serverChoice + " | Result: " + result);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getResult(String client, String server) {
        if (client.equals(server)) {
            return "Draw";
        }
        if ((client.equals("rock") && server.equals("scissors")) ||
            (client.equals("paper") && server.equals("rock")) ||
            (client.equals("scissors") && server.equals("paper"))) {
            return "You win";
        }
        return "You lose";
    }
}
