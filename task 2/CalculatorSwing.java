import javax.swing.*;

public class CalculatorSwing {
    public static void main(String[] args) {
        // إنشاء نافذة
        JFrame frame = new JFrame("Simple Calculator");

        // حقول إدخال
        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();

        // لابل للنتيجة
        JLabel result = new JLabel("Result: ");

        // زرارين (جمع وطرح)
        JButton addBtn = new JButton("Add");
        JButton subBtn = new JButton("Subtract");

        // تحديد أماكن العناصر
        num1.setBounds(50, 50, 150, 25);
        num2.setBounds(50, 90, 150, 25);
        addBtn.setBounds(50, 130, 80, 30);
        subBtn.setBounds(140, 130, 100, 30);
        result.setBounds(50, 180, 200, 30);

        // Action للزرار Add
        addBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(num1.getText());
                double b = Double.parseDouble(num2.getText());
                result.setText("Result: " + (a + b));
            } catch (Exception ex) {
                result.setText("Invalid input!");
            }
        });

        // Action للزرار Subtract
        subBtn.addActionListener(e -> {
            try {
                double a = Double.parseDouble(num1.getText());
                double b = Double.parseDouble(num2.getText());
                result.setText("Result: " + (a - b));
            } catch (Exception ex) {
                result.setText("Invalid input!");
            }
        });

        // إضافة العناصر للنافذة
        frame.add(num1);
        frame.add(num2);
        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(result);

        // إعدادات النافذة
        frame.setSize(320, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
