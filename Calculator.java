import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener{
    TextField result;
    Button buttons[];
    String operator = " ";
    double number1,number2;

    public Calculator(){
        super ("Calculator");
        result = new TextField(20);
        add(result,BorderLayout.NORTH);
        buttons= new Button[16];
        String labels[]= {
            "7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"
        };
        int k =0;
        Panel p = new Panel(new GridLayout(4,4));
        for(int i =0;i<4;i++){
            for(int j = 0;j<4;j++){
                buttons[k] = new Button(labels[k]);
                buttons[k].addActionListener(this);
                p.add(buttons[k]);
                k++;
            }
        }
        add(p);
        setSize(300,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
            if (!operator.equals("")) {
                calculate();
            }
            operator = label;
            number1 = Double.parseDouble(result.getText());
            result.setText("");
        } else if (label.equals("=")) {
            calculate();
            operator = "";
        } else {
            result.setText(result.getText() + label);
        }
    }

    void calculate() {
        number2 = Double.parseDouble(result.getText());
        switch (operator) {
            case "+":
                result.setText("" + (number1 + number2));
                break;
            case "-":
                result.setText("" + (number1 - number2));
                break;
            case "*":
                result.setText("" + (number1 * number2));
                break;
            case "/":
                if (number2 == 0) {
                    result.setText("Error: Division by zero");
                } else {
                    result.setText("" + (number1 / number2));
                }
                break;
        }
    }

    public static void main(String args[]) {
        new Calculator();
    }
}
