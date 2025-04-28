import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener{

    private int[][] grid = new int[8][8];

    public DrawPanel() {
        this.addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.drawRect(30,30,430,420);
        g.fillRect(30,30,430,420);

        int x =50;
        int y =50;

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.WHITE);

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 7; i++) {
                g.drawOval(x, y, 40, 40);
                g.fillOval(x,y,40,40);
                x += 50;
            }
            g.drawOval(x, y, 40, 40);
            g.fillOval(x,y,40,40);
            x = 50;
            y+=50;

        }
    }
    public void createGrid(){

    }


    @Override
    public void mouseClicked(MouseEvent e) {

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