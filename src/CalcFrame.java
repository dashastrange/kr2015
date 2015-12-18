import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame {
    JTextArea display = new JTextArea();
    JPanel buttonPanel = new JPanel(new GridLayout(5, 3));
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonSum = new JButton("+");
    JButton buttonBack = new JButton("C");
    JButton buttonDivide = new JButton("/");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonStart = new JButton("=");
    int firstValue = 0;
    String operation = "+";

    public void calculate_it() {
        setBounds(300, 300, 300, 300);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = display.getText();
                display.setText(temp.substring(0, temp.length() - 1));
            }
        });
        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "+";
            }
        });
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "*";
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "/";
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "-";
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secondValue = Integer.valueOf(display.getText());
                if ("+".equals(operation)) {
                    display.setText((firstValue + secondValue) + "");
                }
                if ("-".equals(operation)) {
                    display.setText((firstValue - secondValue) + "");
                }
                if ("*".equals(operation)) {
                    display.setText((firstValue * secondValue) + "");
                }
                if ("/".equals(operation)) {
                    display.setText((firstValue / secondValue) + "");
                }
                firstValue = 0;
                operation = "+";
            }
        });

        display.setLineWrap(true);
        display.setMargin(new Insets(5, 5, 5, 5));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(200, 300));
        setResizable(false);
        setLayout(new BorderLayout());

        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonStart, BorderLayout.SOUTH);

        buttonPanel.add(button0, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button5, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button7, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button8, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(button9, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonSum, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonSub, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonMul, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonDivide, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonMul, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        buttonPanel.add(buttonBack, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
        //pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(MyLookAndFeel.class.getCanonicalName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        CalcFrame mainGUI = new CalcFrame();
        mainGUI.calculate_it();
    }
}

