public class ConnectFour {
    private Space[][] board;
    private Player player;

    public ConnectFour(){
        setBoard();
        Player player1 = new Player(0);
        printBoard();
    }
    public void setBoard(){
        this.board = new Space[6][7];
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

    public Space[][] getBoard() {
        return board;
    }

    public void place(int c, int move){
            int x = board.length-1;
            for (int j = 0; j < board.length; j++) {
                if (board[x][c].getNum() == 0) {
                    System.out.println(board[x][c].getNum() == 0);
                    board[x][c] = new Space(move);
                    break;
                }
                x--;
            }
    }

    public boolean verticalChecker(){
        int count = 0;
        for (int i = board.length-1; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                System.out.println((board[i][0]));
                System.out.println(board[j][0]);
                if ( (board[i][0].equals(board[j][0])) ){
                    count++;
                    System.out.println("d");
                }
                if (count == 4){
                    return true;
                }
            }
        }

        return false;
    }

}
