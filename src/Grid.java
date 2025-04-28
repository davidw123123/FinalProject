public class Grid {
    private Space[][] board;
    private Player player;

    public Grid(){
        setBoard();
        printBoard();
    }
    public void setBoard(){
        this.board = new Space[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Space("0");
            }
        }
    }
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getSymbol());
            }
            System.out.println();
        }
    }

}
