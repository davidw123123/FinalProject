import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener{

    private Rectangle column1;
    private Rectangle column2;
    private Rectangle column3;
    private Rectangle column4;
    private Rectangle column5;
    private Rectangle column6;
    private Rectangle column7;
    private int move;
    private Rectangle restartButton;
    private ConnectFour connectFour;
    private boolean clicked = false;
    public DrawPanel() {
        connectFour = new ConnectFour();
        move = 1;
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;

        column1 = new Rectangle(50, 50,40,300);
        column2 = new Rectangle(100, 50, 40, 300);
        column3 = new Rectangle(150, 50,40,300);
        column4 = new Rectangle(200, 50,40,300);
        column5 = new Rectangle(250, 50,40,300);
        column6 = new Rectangle(300, 50,40,300);
        column7 = new Rectangle(350, 50,40,300);

        restartButton = new Rectangle(415, 10, 20,20);
        g.setColor(Color.GREEN);

        g.fillRect(415, 10, 20,20);
        g.setColor(new java.awt.Color(0, 31, 255));
        g.fillRect(30, 30, 380, 330);


        int x = 50;
        int y = 50;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                int num = connectFour.getBoard()[row][col].getNum();
                if (num == 1 && clicked) {
                    g2.setColor(Color.RED);
                } else if (num == 2 && clicked) {
                    g2.setColor(Color.YELLOW);
                } else {
                    g2.setColor(Color.BLACK);
                }

                g2.fillOval(x, y, 45, 45);
                g2.drawOval(x, y, 45, 45);
                x += 50;
            }
            x = 50;
            y += 50;
        }

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        if (checkWin() == 0){
            if (move == 1) {
                g.setColor(Color.RED);
                g.drawString("Player 1's turn", 80, 30);
            } else {
                g.setColor(Color.YELLOW);
                g.drawString("Player 2's turn", 80, 30);
            }
        } if (checkWin() != 0){
            g.setColor(Color.GRAY);
            g.drawRect(150,0,150,50);
            g2.fillRect(150,0,150,50);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Game Over", 170,25);
            if (checkWin() == 1){
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier New", Font.BOLD, 17));
                g.drawString("Player 1 Wins", 160, 40);
            } else if (checkWin() == 2){
                g.setColor(Color.WHITE);
                g.setFont(new Font("Courier New", Font.BOLD, 17));
                g.drawString("Player 2 Wins", 160, 40);
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickedPoint = e.getPoint();

        if (e.getButton() == MouseEvent.BUTTON1) {
            this.clicked = true;

            if (column1.contains(clickedPoint)){
                if (connectFour.getBoard()[0][0].getNum() == 0) {
                    place(0);
                }
            } else if (column2.contains(clickedPoint)){
                if (connectFour.getBoard()[0][1].getNum() == 0) {
                    place(1);
                }
            } else if (column3.contains(clickedPoint)){
                if (connectFour.getBoard()[0][2].getNum() == 0) {
                    place(2);
                }
            } else if (column4.contains(clickedPoint)){
                if (connectFour.getBoard()[0][3].getNum() == 0) {
                    place(3);
                }
            } else if (column5.contains(clickedPoint)){
                if (connectFour.getBoard()[0][4].getNum() == 0) {
                    place(4);
                }
            } else if (column6.contains(clickedPoint)){
                if (connectFour.getBoard()[0][5].getNum() == 0) {
                    place(5);
                }
            } else if (column7.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][6].getNum() == 0) {
                    place(6);
                }
            }
            if (restartButton.contains(clickedPoint)){
                restart();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private void place(int columnIndex) {
        if (move == 1) {
            connectFour.place(columnIndex, 1);
            move = 2;
        } else {
            connectFour.place(columnIndex, 2);
            move = 1;
        }
        connectFour.printBoard();
    }
    private int checkWin() {
        if (connectFour.horizontalChecker() == 1){

            return 1;

        } else if (connectFour.horizontalChecker() == 2){

            return 2;
        }

        if (connectFour.verticalChecker() == 1){

            return 1;
        } else if (connectFour.verticalChecker() == 2){

            return 2;
        }
        if (connectFour.reverseDiagonalChecker() == 1){

            return 1;
        } else if (connectFour.reverseDiagonalChecker() == 2){

            return 2;
        }
        return connectFour.diagonalChecker();
    }

    private void restart(){
        connectFour = new ConnectFour();
        move = 1;
        repaint();
    }

}