import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kalkulator extends JFrame implements ActionListener {

    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton modButton, equButton, clrButton, delButton;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Kalkulator() {
        setTitle("Kalkulator Sederhana");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 40);
        textField.setEditable(false);
        add(textField);

        panel = new JPanel();
        panel.setBounds(50, 80, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        add(panel);

        // Nomor 1-9
        for (int i = 0; i < 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i + 1));
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }

        // Nomor 0
        numberButtons[9] = new JButton("0");
        numberButtons[9].addActionListener(this);
        panel.add(numberButtons[9]);

        // Tombol fungsi
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("Del");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;
        functionButtons[5] = equButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            panel.add(functionButtons[i]);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        } else if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        textField.setText("Error");
                    } else {
                        result = num1 / num2;
                    }
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }

            textField.setText(String.valueOf(result));
        } else if (e.getSource() == clrButton) {
            textField.setText("");
        } else if (e.getSource() == delButton) {
            String string = textField.getText();
            if (!string.equals("")) {
                textField.setText(string.substring(0, string.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Kalkulator();
    }
}