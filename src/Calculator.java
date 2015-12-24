import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;

public class Calculator {
    boolean flag;
    JFrame frame;
    JPanel MainWindow;
    JPanel p1;
    JPanel p2;
    JTextField display;
    JButton[] numButtons = new JButton[10];
    JButton btnDel;
    JButton btnEqual;
    JButton btnPlus;
    JButton btnMinus;
    JButton btnMultiply;
    JButton btnDivide;
    JButton btnLeftBracket;
    JButton btnRightBracket;

    Calculator() {
        MainWindow = new JPanel(new BorderLayout());
        p1 = new JPanel();
        p2 = new JPanel();
        display = new JTextField(15);
        display.setEditable(false);
        display.setMargin(new Insets(5, 5, 5, 5));
        p1.setLayout(new GridLayout(4, 3, 2, 2));
        p2.setLayout(new GridLayout(4, 2, 2, 2));

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton("" + i);
            numButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag) {
                        display.setText("");
                        flag = false;
                    }
                    String input = e.getActionCommand();
                    display.setText(display.getText() + input);
                }
            });
        }
        btnDel = new JButton("C");
        btnEqual = new JButton("=");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnLeftBracket = new JButton("(");
        btnRightBracket = new JButton(")");

        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = display.getText();
                System.out.println(task);
                display.setText(evalRPN(RevPolNot(task)));
                flag = true;
            }
        });

        ActionListener insert = new InsertOperatorAction();
        btnPlus.addActionListener(insert);
        btnMinus.addActionListener(insert);
        btnMultiply.addActionListener(insert);
        btnDivide.addActionListener(insert);
        btnLeftBracket.addActionListener(insert);
        btnRightBracket.addActionListener(insert);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText().substring(0,
                        display.getText().length() - 1));
            }
        });

        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                p1.add(numButtons[0]);
                continue;
            }
            p1.add(numButtons[i]);
        }

        p1.add(btnDel);
        p1.add(btnEqual);
        p2.add(btnPlus);
        p2.add(btnLeftBracket);
        p2.add(btnMinus);
        p2.add(btnRightBracket);
        p2.add(btnMultiply);
        p2.add(btnDivide);

        MainWindow.add(display, BorderLayout.NORTH);
        MainWindow.add(p1, BorderLayout.CENTER);
        MainWindow.add(p2, BorderLayout.EAST);

        frame = new JFrame("Calculator666");
        frame.setContentPane(MainWindow);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(200,170));
        //frame.pack();

    }

    private class InsertOperatorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (flag) {
                display.setText("");
                flag = false;
            }
            String input = event.getActionCommand();
            display.setText(display.getText() + input);
        }
    }

    public static String RevPolNot(String input) {
        if (input == null)
            return "";
        char[] in = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder out = new StringBuilder();

        for (char anIn : in) {
            switch (anIn) {
                case '+':
                case '-':
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    out.append(' ');
                    stack.push(anIn);
                    break;
                case '*':
                case '/':
                    out.append(' ');
                    stack.push(anIn);
                    break;
                case '(':
                    stack.push(anIn);
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() != '(') {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    out.append(anIn);
                    break;
            }
        }
        while (!stack.isEmpty())
            out.append(' ').append(stack.pop());

        return out.toString();
    }

    public static String evalRPN(String expr) {
        String cleanUpExpr = cleanUpExpr(expr);
        LinkedList<Double> stack = new LinkedList<Double>();
        System.out.println("Input\tOperation\tStack after");
        for (String token : cleanUpExpr.split("\\s")) {
            System.out.print(token + "\t");
            Double tokenNum = null;
            try {
                tokenNum = Double.parseDouble(token);
            } catch (NumberFormatException e) {
            }
            if (tokenNum != null) {
                System.out.print("Push\t\t");
                stack.push(Double.parseDouble(token + ""));
            } else if (token.equals("*")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            } else if (token.equals("/")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            } else if (token.equals("-")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            } else if (token.equals("+")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            } else if (token.equals("^")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(Math.pow(firstOperand, secondOperand));
            } else {// just in case
                System.out.println("Error");
                return "err";
            }
            System.out.println(stack);
        }
        String total = String.valueOf(Math.round(stack.pop()));
        System.out.println("Final answer: " + total);

        return total;

    }

    private static String cleanUpExpr(String expr) {
        //delete operators for right RPN
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(MyLookAndFeel.class.getCanonicalName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }

}
