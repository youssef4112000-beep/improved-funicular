import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
    
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost:6000/CalculatorService");

            int sum = calc.add(5, 3);
            int diff = calc.subtract(10, 4);

            System.out.println("Client --> 5 + 3 = " + sum);
            System.out.println("Client --> 10 - 4 = " + diff);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
