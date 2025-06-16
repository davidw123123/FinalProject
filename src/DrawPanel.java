import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class
DrawPanel extends JPanel implements MouseListener{

    private Rectangle column1;
    private Rectangle column2;
    private Rectangle column3;
    private Rectangle column4;
    private Rectangle column5;
    private Rectangle column6;
    private Rectangle column7;
    private Rectangle playerRect;
    private Rectangle aiRect;
    private int move;
    private boolean vsPlayerMouseOver;
    private boolean mouseOnScreen;
    private boolean vsAiMouseOver;
    private Rectangle restartButton;
    private ConnectFour connectFour;
    private boolean clicked = false;
    public int gameState;
    public boolean vsAi;

    public DrawPanel() {
        connectFour = new ConnectFour();
        gameState = 1;
        move = 1;
        this.addMouseListener(this);
        vsPlayerMouseOver = false;
        vsAiMouseOver = false;
        vsAi = false;
        playerRect = new Rectangle(100,110,190, 60);
        aiRect = new Rectangle(100, 190, 190, 60);
        column1 = new Rectangle(50, 50, 40, 300);
        column2 = new Rectangle(100, 50, 40, 300);
        column3 = new Rectangle(150, 50, 40, 300);
        column4 = new Rectangle(200, 50, 40, 300);
        column5 = new Rectangle(250, 50, 40, 300);
        column6 = new Rectangle(300, 50, 40, 300);
        column7 = new Rectangle(350, 50, 40, 300);
        restartButton = new Rectangle(415, 10, 20, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //checks if mouse position is over vs AI or vs Player
        // draws > over which one the mouse is over
        if (mouseOnScreen) {
            Point mousePosition = this.getMousePosition();
            if (mousePosition != null) {
                if (playerRect.contains(mousePosition)) {
                    vsPlayerMouseOver = true;
                }
                else if (aiRect.contains(mousePosition)){
                    vsAiMouseOver = true;
                } else
                    vsPlayerMouseOver = false;
            }
        }

        setBackground(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == 1){
            g.setFont(new Font("Courier New", Font.BOLD, 40));
            g.setColor(Color.YELLOW);
            g.drawString("Connect ", 70, 50);
            g.setColor(Color.RED);
            g.drawString("Four ", 250, 50);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 30));

            g.drawString("Vs Player", 120, 150);
             playerRect = new Rectangle(100,110,190, 60);
            g.drawRect(110,110,190,60);

            g.drawString("Vs AI", 140, 230);
            g.drawRect(110,190,190,60);
            g.setFont(new Font("Courier New", Font.PLAIN, 50));
            if (vsPlayerMouseOver){
                g.drawString(">", 60, 150);
            } else if (vsAiMouseOver) {
                g.drawString(">", 60, 230);
            }
        }
        else if (gameState == 2) {

            g.setColor(Color.GREEN);

            g.fillRect(415, 10, 20, 20);
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
            if (checkWin() == 0) {
                if (vsAi){
                    if (move == 1){
                        g.setColor(Color.RED);
                        g.drawString("Your turn", 120,30);
                    } else {
                        g.setColor(Color.YELLOW);
                        g.drawString("AI's turn",80,30);
                    }
                } else {
                    if (move == 1) {
                        g.setColor(Color.RED);
                        g.drawString("Player 1's turn", 80, 30);
                    } else {
                        g.setColor(Color.YELLOW);
                        g.drawString("Player 2's turn", 80, 30);
                    }
                }
            }

            if (checkWin() != 0) {
                g.setColor(Color.GRAY);
                g.drawRect(150, 0, 150, 50);
                g2.fillRect(150, 0, 150, 50);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString("Game Over", 170, 25);

                if (checkWin() == 1) {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Courier New", Font.BOLD, 17));
                    if (vsAi){
                        g.drawString("You Win",175,40);
                    } else {
                        g.drawString("Player 1 Wins", 160, 40);
                    }
                } else if (checkWin() == 2) {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Courier New", Font.BOLD, 17));
                    if (vsAi){
                        g.drawString("AI Win",175,40);
                    } else {
                        g.drawString("Player 2 Wins", 160, 40);
                    }
                }
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickedPoint = e.getPoint();


        if (gameState == 2) {
            clickedPoint = e.getPoint();
        }
        if (gameState == 1) {
            if (playerRect.contains(clickedPoint)) {
                gameState = 2;
                vsAi = false;
            } else if (aiRect.contains(clickedPoint)) {
                gameState = 2;
                vsAi = true;
            }
        } else if (gameState == 2) {
            if (restartButton.contains(clickedPoint)) {
                restart();
                return;
            }

            if (vsAi && move == 2) {
                return;
            }

            if (checkWin() != 0) {
                return;
            }

            this.clicked = true;
            if (column1.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][0].getNum() == 0) {
                    place(0);
                }
            } else if (column2.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][1].getNum() == 0) {
                    place(1);
                }
            } else if (column3.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][2].getNum() == 0) {
                    place(2);
                }
            } else if (column4.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][3].getNum() == 0) {
                    place(3);
                }
            } else if (column5.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][4].getNum() == 0) {
                    place(4);
                }
            } else if (column6.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][5].getNum() == 0) {
                    place(5);
                }
            } else if (column7.contains(clickedPoint)) {
                if (connectFour.getBoard()[0][6].getNum() == 0) {
                    place(6);
                }
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
        mouseOnScreen = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOnScreen = false;
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

        if (vsAi && move == 2 && checkWin() == 0){
            makeAIMove();
        }
        repaint();
    }
    public void makeAIMove(){
        int aiMove = AI.miniMax(connectFour.getBoard(),4 ,4, true);
        if (aiMove >= 0 && aiMove < 7) {
            connectFour.place(aiMove, 2);
            move = 1;
        }
        repaint();
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

        this.connectFour = new ConnectFour();
        this.gameState = 1;
        this.move = 1;
        this.clicked = false;
        this.vsPlayerMouseOver = false;
        this.vsAiMouseOver = false;
        this.vsAi = false;
        this.playerRect = new Rectangle(100,110,190, 60);
        this.aiRect = new Rectangle(100, 190, 190, 60);
        this.column1 = new Rectangle(50, 50, 40, 300);
        this.column2 = new Rectangle(100, 50, 40, 300);
        this.column3 = new Rectangle(150, 50, 40, 300);
        this.column4 = new Rectangle(200, 50, 40, 300);
        this.column5 = new Rectangle(250, 50, 40, 300);
        this.column6 = new Rectangle(300, 50, 40, 300);
        this.column7 = new Rectangle(350, 50, 40, 300);
        this.restartButton = new Rectangle(415, 10, 20, 20);

        repaint();
    }

}