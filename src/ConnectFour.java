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

            for (int j = 0; j < board.length; j++) {
                for (int k = j + 1; k < board.length; k++) {
                    if ( (board[j][0].equals(board[k][0])) ){
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
