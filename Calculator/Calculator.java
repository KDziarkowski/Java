import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
    private JFrame frame = new JFrame("Calculator by Java");

    private JTextArea txtScreen = new JTextArea();
    private JTextArea outputScreen = new JTextArea();

    //private ImageIcon image = new

    private JButton button1 = new JButton("0");
    private JButton button2 = new JButton("1");
    private JButton button3 = new JButton("2");
    private JButton button4 = new JButton("3");
    private JButton button5 = new JButton("4");
    private JButton button6 = new JButton("5");
    private JButton button7 = new JButton("6");
    private JButton button8 = new JButton("7");
    private JButton button9 = new JButton("8");
    private JButton button10 = new JButton("9");

    private JButton dividebutton = new JButton("/");
    private JButton multiplybutton = new JButton("*");
    private JButton addbutton = new JButton("+");
    private JButton substractbutton = new JButton("-");
    private JButton powerOf = new JButton("**");
    private JButton root = new JButton("sqrt");
    private JButton clears = new JButton("c");
    private JButton parenthesis_left = new JButton("(");
    private JButton parenthesis_right = new JButton(")");

    private JButton equals = new JButton("=");

    public Calculator(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,550);
        frame.setResizable(false);
        frame.setLayout(null);
        Color customOrange = new Color(244,220,191);
        Color customGray = new Color(230,230,230);
        frame.getContentPane(). setBackground(customOrange);

        txtScreen.setSize(380,50);
        txtScreen.setLocation(7,5);

        outputScreen.setSize(380,50);
        outputScreen.setLocation(7,70);
        outputScreen.setBackground(customGray);

        equals.setSize(100,50);
        equals.setLocation(270,450);
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     double x = Evaluation.eval(txtScreen.getText());

                    if(x == (1.0/0.0) || x == (-1.0/0.0) || x == (0.0/0.0)){
                        System.out.println("Division by 0 is not allowed");
                        outputScreen.setText("Division by 0 is not allowed");
                    }
                    else{
                        outputScreen.setText(Double.toString(x));
                        System.out.println(x);
                    }
                } catch (Exception  e1){

                    outputScreen.setText("Invalid Input, Please try again");
                    outputScreen.append("\n"+e1.getMessage());
                    e1.printStackTrace();
                }
            }
        });

        createButtons();

        createActionListeners();

        addObjectsToScreen();

        frame.setVisible(true);

    }

    private void addObjectsToScreen(){
        frame.add(txtScreen);
        frame.add(outputScreen);
        frame.add(clears);
        frame.add(equals);
        frame.add(parenthesis_left);
        frame.add(parenthesis_right);
        frame.add(root);
        frame.add(powerOf);
        frame.add(dividebutton);
        frame.add(multiplybutton);
        frame.add(substractbutton);
        frame.add(addbutton);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
    }
    private void createButtons(){

        button1.setSize(100,50);
        button1.setLocation(69,450);

        button2.setSize(100,50);
        button2.setLocation(69,399);

        button3.setSize(100,50);
        button3.setLocation(169,399);

        button4.setSize(100,50);
        button4.setLocation(270,399);

        button5.setSize(100,50);
        button5.setLocation(69,349);

        button6.setSize(100,50);
        button6.setLocation(169,349);

        button7.setSize(100,50);
        button7.setLocation(270,349);

        button8.setSize(100,50);
        button8.setLocation(69,299);

        button9.setSize(100,50);
        button9.setLocation(169,299);

        button10.setSize(100,50);
        button10.setLocation(270,299);

        clears.setSize(100,50);
        clears.setLocation(169,450 );

        dividebutton.setSize(100,50);
        dividebutton.setLocation(270,220);

        multiplybutton.setSize(100,50);
        multiplybutton.setLocation(169,220);

        addbutton.setSize(100,50);
        addbutton.setLocation(69,220);

        substractbutton.setSize(100,50);
        substractbutton.setLocation(270, 170);

        powerOf.setSize(100,50);
        powerOf.setLocation(169,170);

        root.setSize(100,50);
        root.setLocation(69,170);

        parenthesis_left.setSize(50,50);
        parenthesis_left.setLocation(9,170);

        parenthesis_right.setSize(50,50);
        parenthesis_right.setLocation(9,220);


    }
    private void createActionListeners(){
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("9");
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("8");
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("7");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("6");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("5");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("4");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("3");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("2");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("1");
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("0");
            }
        });

        dividebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("/");
            }
        });

        multiplybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("*");
            }
        });

        substractbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("-");
            }
        });

        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("+");
            }
        });

        powerOf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("^");
            }
        });

        root.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("sqrt(");
            }
        });

        clears.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.setText(null);
            }
        });

        parenthesis_left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append("(");
            }
        });

        parenthesis_right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScreen.append(")");
            }
        });
    }
}
