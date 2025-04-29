import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawPanel extends JPanel implements MouseListener{

    private int[][] grid = new int[6][6];
    private Rectangle column1;
    private Rectangle column2;
    private Rectangle column3;
    private Rectangle column4;
    private Rectangle column5;
    private Rectangle column6;
    private Rectangle column7;
    private int move;
    private ConnectFour connectFour;
    public DrawPanel() {
        move = 1;
        this.addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        column1 = new Rectangle(50, 50,40,300);
        column2 = new Rectangle(100, 50, 40, 300);
        column3 = new Rectangle(150, 50,40,300);
        column4 = new Rectangle(200, 50,40,300);
        column5 = new Rectangle(250, 50,40,300);
        column6 = new Rectangle(300, 50,40,300);
        column7 = new Rectangle(350, 50,40,300);


        g.drawRect(30,30,380,350);
        g.fillRect(30,30,380,350);

        int x =50;
        int y =50;

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.WHITE);

        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                g.drawOval(x, y, 40, 40);
                g.fillOval(x,y,40,40);
                x += 50;
            }
            g.drawOval(x, y, 40, 40);
            g.fillOval(x,y,40,40);
            x = 50;
            y+=50;

        }


        if (move == 0){
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.setColor(Color.RED);
            g.drawString("Player 1's turn", 450,50);
        }
        if (move == 1){
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.setColor(Color.BLUE);
            g.drawString("Player 2's turn", 450,50);
        }
    }
    public void createGrid(){

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point clicked = e.getPoint();
        if (e.getButton() ==1 ){
            if (column1.contains(clicked)){
                System.out.println("clicked 1");
                if (move == 1){
                    connectFour.place(1,move);
                    move = 2;
                } else
                    connectFour.place(1,move);
                    move = 1;

            }
            if (column2.contains(clicked)){
                System.out.println("clicked 2");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
            }
            if (column3.contains(clicked)){
                System.out.println("clicked 3");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
            }
            if (column4.contains(clicked)){
                System.out.println("clicked 4");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
            }
            if (column5.contains(clicked)){
                System.out.println("clicked 5");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
            }
            if (column6.contains(clicked)){
                System.out.println("clicked 6");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
            }
            if (column7.contains(clicked)){
                System.out.println("clicked 7");
                if (move == 0){
                    move = 1;
                } else
                    move = 0;
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
}