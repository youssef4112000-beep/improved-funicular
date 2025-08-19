import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; 
        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress address = InetAddress.getByName(host);
            byte[] buffer = new byte[256];

            while (true) {
                System.out.print("Enter your guess (1-10): ");
                String guess = scanner.nextLine();

                
                byte[] sendBytes = guess.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, address, port);
                socket.send(sendPacket);

                
                DatagramPacket recvPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(recvPacket);

                String response = new String(recvPacket.getData(), 0, recvPacket.getLength());
                System.out.println("Server: " + response);

                if (response.contains("Correct!")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
