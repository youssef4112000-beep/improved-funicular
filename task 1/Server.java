import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(6000);

            CalculatorImpl calc = new CalculatorImpl();

            Naming.rebind("rmi://localhost:6000/CalculatorService", calc);

            System.out.println("Server --> Calculator Service bound.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
