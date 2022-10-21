import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Okno extends JFrame implements ActionListener{

    JPanel p1;
    JButton[] buttons = new JButton[625];
    char playMark = 'x';
    boolean ruch = false;
    boolean gameOver = false;
    String ktorePole = "";

    Okno(){
        setSize(700,700);
        setTitle("Serwer");
        setLocation(1200, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        p1 = new JPanel(new GridLayout(25, 25));
        p1.setPreferredSize(new Dimension(680,680));

        for (int i = 0; i < 625; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(this);
            p1.add(buttons[i]);
        }
        add(p1);

    }

    public void send(String message) throws IOException, ClassNotFoundException {

        try{
            if(Polacz.oos != null){
                System.out.println(Polacz.oos);
                Polacz.oos.writeObject(message);
            }
        } catch (IOException e){
            System.out.println("brak klienta");
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e){
        JButton buttonClicked = (JButton) e.getSource();
        buttonClicked.setText(String.valueOf(playMark));

        if (playMark == 'x') {
            playMark = 'o';
            buttonClicked.setBackground(Color.CYAN);
        } else {
            playMark = 'x';
            buttonClicked.setBackground(Color.ORANGE);
        }
        if (checkForWinner() == true) {
            if (playMark == 'x') playMark = 'o';
            else playMark = 'x';

            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane,
                    "Game Over " + playMark + " wins. Would you like to play again?",
                    "Game over", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) resetButtons();
            else System.exit(0);
        }

        else if(checkDraw()){
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Play again?",
                    "Game over.",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) resetButtons();
            else System.exit(0);
        }
        else{
            if(((JButton) e.getSource()).getText().equalsIgnoreCase(" ")){

                if(ruch == true){
                    ((JButton) e.getSource()).setText("o");
                    ktorePole = ( ((JButton) e.getSource()).getName());
                    System.out.println(ktorePole);
                    try{
                        send(ktorePole);
                    } catch (IOException ex){
                        ex.printStackTrace();
                        System.out.println("Uruchom serwer i zrestartuj klienta. ");
                    } catch (ClassNotFoundException ex){
                        ex.printStackTrace();
                        System.out.println("Blad polacznia");
                    }
                    ruch = !ruch;
                }
            }

        }
    }
    

    public boolean checkForWinner() {
        if (checkRows() == true || checkColumns() == true || checkDiagonals() == true) return true;
        else return false;
    }

    public void resetButtons(){
        for(int i=0; i<625; i++){
            playMark = 'x';
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
        }
        gameOver = false;
    }
    public boolean checkDraw(){

        boolean full = true;
        for(int i=0; i<625; i++) {
            if (buttons[i].getText().charAt(0) == ' ')
                full = false;
        }
        return full;
    }

    public boolean checkRows() {
        int i = 0;
        for (int j = 0; j < 25; j++) {
            for (int k = 0; k <= 20; k++) {
                if (buttons[i + k].getText().equals(buttons[i + k + 1].getText()) &&
                        buttons[i + k].getText().equals(buttons[i + k + 2].getText()) &&
                        buttons[i + k].getText().equals(buttons[i + k + 3].getText()) &&
                        buttons[i + k].getText().equals(buttons[i + k + 4].getText()) &&
                        buttons[i + k].getText().charAt(0) != ' ') {
                    return true;
                }

            }
            i += 25;
        }
        return false;
    }

    public boolean checkColumns() {

        for(int j=0; j<25; j++) {
            for (int k = 0; k <= 20; k++) {
                if (buttons[j+25*k].getText().equals(buttons[j+25*(k+1)].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+2)].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+3)].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+4)].getText()) &&
                        buttons[j+25*k].getText().charAt(0) != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonals(){
        for(int j=4; j<25; j++) {
            for (int k = 0; k <= 20; k++) {
                if (buttons[j+25*k].getText().equals(buttons[j+25*(k+1)-1].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+2)-2].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+3)-3].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+4)-4].getText()) &&
                        buttons[j+25*k].getText().charAt(0) != ' ') {
                    return true;
                }
            }
        }

        for(int j=0; j<=20; j++) {
            for (int k = 0; k <= 20; k++) {
                if (buttons[j+25*k].getText().equals(buttons[j+25*(k+1)+1].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+2)+2].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+3)+3].getText()) &&
                        buttons[j+25*k].getText().equals(buttons[j+25*(k+4)+4].getText()) &&
                        buttons[j+25*k].getText().charAt(0) != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

}
