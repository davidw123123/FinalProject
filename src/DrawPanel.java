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
    private ConnectFour connectFour;
    private boolean clicked = false;
    private int winner = 0;
    public DrawPanel() {
        move = 1;
        this.addMouseListener(this);
        connectFour = new ConnectFour();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        column1 = new Rectangle(50, 50,40,300);
        column2 = new Rectangle(100, 50, 40, 300);
        column3 = new Rectangle(150, 50,40,300);
        column4 = new Rectangle(200, 50,40,300);
        column5 = new Rectangle(250, 50,40,300);
        column6 = new Rectangle(300, 50,40,300);
        column7 = new Rectangle(350, 50,40,300);

        g.setColor(Color.BLUE);
        g.fillRect(30, 30, 380, 350);


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
                    g2.setColor(Color.WHITE);
                }

                g2.fillOval(x, y, 40, 40);
                g2.drawOval(x, y, 40, 40);
                x += 50;
            }
            x = 50;
            y += 50;
        }


        g.setFont(new Font("Courier New", Font.BOLD, 30));
        if (move == 1) {
            g.setColor(Color.RED);
            g.drawString("Player 1's turn", 450, 50);
        } else {
            g.setColor(Color.BLUE);
            g.drawString("Player 2's turn", 450, 50);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickedPoint = e.getPoint();

        if (e.getButton() == MouseEvent.BUTTON1) {
            this.clicked = true;

            if (column1.contains(clickedPoint)){
                place(0);

            } else if (column2.contains(clickedPoint)){
                place(1);
            } else if (column3.contains(clickedPoint)){
                place(2);
            } else if (column4.contains(clickedPoint)){
                place(3);
            } else if (column5.contains(clickedPoint)){
                place(4);
            } else if (column6.contains(clickedPoint)){
                place(5);
            } else if (column7.contains(clickedPoint)) {
                place(6);
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
    private boolean checkWin() {
        for (int row = 0; row < 6; row++) {
            if (connectFour.horizontalChecker(row)) return true;
        }
        for (int col = 0; col < 7; col++) {
            if (connectFour.verticalChecker(col)) return true;
        }
        return connectFour.reverseDiagonalChecker();
    }

}