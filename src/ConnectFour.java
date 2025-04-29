import java.util.Scanner;

public class ConnectFour {
    private Space[][] board;
    private Player player;

    public ConnectFour(){
        setBoard();
        Player player1 = new Player(0);
        printBoard();
    }
    public void setBoard(){
        this.board = new Space[6][6];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Space(0);
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getNum());
            }
            System.out.println();
        }
    }

    public void place(int c, int move){
            int x = board[0].length;
            for (int j = 0; j < board.length; j++) {
                if (board[x][c].getNum() == 0){
                    board[x][c] = new Space(move);
                }
            }
    }

    public void versusPlayer(){

    }

}
