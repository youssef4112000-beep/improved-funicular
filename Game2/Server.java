import java.net.*;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Server started. Waiting for guesses...");

            
            Random random = new Random();
            int secretNumber = 1 + random.nextInt(10);
            System.out.println("Secret number chosen (1-10).");

            byte[] buffer = new byte[256];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String guessStr = new String(packet.getData(), 0, packet.getLength());
                int guess = Integer.parseInt(guessStr.trim());

                String response;
                if (guess < secretNumber) {
                    response = "Too low";
                } else if (guess > secretNumber) {
                    response = "Too high";
                } else {
                    response = "Correct! You win!";

                    byte[] respBytes = response.getBytes();
                    DatagramPacket respPacket = new DatagramPacket(
                            respBytes, respBytes.length,
                            packet.getAddress(), packet.getPort());
                    socket.send(respPacket);
                    break;
                }

                
                byte[] respBytes = response.getBytes();
                DatagramPacket respPacket = new DatagramPacket(
                        respBytes, respBytes.length,
                        packet.getAddress(), packet.getPort());
                socket.send(respPacket);
            }

            System.out.println("Game over. Server shutting down.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
