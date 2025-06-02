import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConnectFour {
    private boolean show;
    private BufferedImage image;
    private String imageFileName;
    private Space[][] board;
    private Player player;

    public ConnectFour() {
        setBoard();
        this.imageFileName = "restart" + ".png";
        this.image = readImage();
        printBoard();
    }

    public void setBoard() {
        this.board = new Space[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Space(0);
            }
        }
    }

    public void printBoard() {
        for (Space[] spaces : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(spaces[j].getNum());
            }
            System.out.println();
        }
    }

    public Space[][] getBoard() {
        return board;
    }

    public void place(int c, int move) {
        int x = board.length - 1;
        for (int j = 0; j < board.length; j++) {
            if (board[x][c].getNum() == 0) {
                board[x][c] = new Space(move);
                break;
            }
            x--;
        }
    }

    public int horizontalChecker(){
        for (Space[] spaces : board) {
            for (int j = 0; j < board[j].length - 4; j++) {
                try {
                    if ((spaces[j].getNum() != 0) && (spaces[j].getNum() == spaces[j + 1].getNum()) && (spaces[j].getNum() == spaces[j + 2].getNum()) && (spaces[j].getNum() == spaces[j + 3].getNum())) {
                        if (spaces[j].getNum() == 1) {
                            return 1;
                        } else
                            return 2;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
        return 0;
    }


    public int verticalChecker(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                try {
                    if ( (board[i][j].getNum()!= 0) && (board[i][j].getNum() == board[i+1][j].getNum())  && ( board[i][j].getNum() == board[i+2][j].getNum() )&& ( board[i][j].getNum() == board[i+3][j].getNum() )){
                        if (board[i][j].getNum() == 1) {
                            return 1;
                        } else
                            return 2;
                    }
                } catch (Exception e){
                    break;
                }
            }
        }
        return 0;
    }

    public int reverseDiagonalChecker() {
        for (int i = 0; i <= board.length - 4; i++) {
            for (int j = 0; j <= board[0].length - 4; j++) {
                if ((board[i][j].getNum() != 0) && (board[i][j].getNum() == board[i + 1][j + 1].getNum()) && (board[i][j].getNum() == board[i + 2][j + 2].getNum()) && (board[i][j].getNum() == board[i + 3][j + 3].getNum())) {
                    if (board[i][j].getNum() == 1) {
                        return 1;
                    } else
                        return 2;
                }
            }
        }
        return 0;
    }

    public int diagonalChecker() {
        for (int i = 0; i <= board.length - 4; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (board[i][j].getNum() != 0 && board[i][j].getNum() == board[i + 1][j - 1].getNum() && board[i][j].getNum() == board[i + 2][j - 2].getNum() && board[i][j].getNum() == board[i + 3][j - 3].getNum()) {
                    if (board[i][j].getNum() == 1) {
                        return 1;
                    } else
                        return 2;
                }
            }
        }

        return 0;
    }

    public boolean checkWin() {
        if (diagonalChecker() > 0 || reverseDiagonalChecker() > 0 || horizontalChecker() > 0 || verticalChecker() > 0){
            return true;
        }
        return false;
    }


    public BufferedImage getImage() {
        try {
            BufferedImage image;
            // if this is true, show the front
            // otherwise show the back
                image = ImageIO.read(new File(imageFileName));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public BufferedImage readImage() {
        try {
            BufferedImage image = getImage();
            if (show) {
                image = ImageIO.read(new File(imageFileName));
            }
            return image;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
