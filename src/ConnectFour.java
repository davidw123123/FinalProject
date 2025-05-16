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

    public void setBoard(Space[][] board) {
        this.board = board;
    }

    public Space[][] getBoard() {
        return board;
    }

    public void place(int c, int move){
            int x = board.length-1;
            for (int j = 0; j < board.length; j++) {
                if (board[x][c].getNum() == 0) {
                    board[x][c] = new Space(move);
                    break;
                }
                x--;
            }
    }

    public boolean verticalChecker(int column){
        for (int i = 0; i < 6; i++) {
            try{
                if ( (board[i][column].getNum() != 0) &&  (board[i][column].getNum() == board[i+1][column].getNum() ) && ( board[i][column].getNum() == board[i+2][column].getNum() ) && ( board[i][column].getNum() == board[i+3][column].getNum() )){
                    System.out.println("Win");
                    return true;
                }            } catch (Exception e){
                break;
            }
        }
        return false;
    }
    
    public boolean horizontalChecker(int row){
        for (int i = 0; i < 7; i++) {
            try{
                if ( (board[row][i].getNum() != 0) &&  (board[row][i].getNum() == board[row][i+1].getNum() ) && ( board[row][i].getNum() == board[row][i+2].getNum() ) && ( board[row][i].getNum() == board[row][i+3].getNum() )){
                    System.out.println("Win");
                    return true;
                }
            } catch (Exception e){
                break;
            }
        }
        return false;
    }

    public boolean reverseDiagonalChecker() {
        for (int i = 0; i <= board.length - 4; i++) {
            for (int j = 0; j <= board[0].length - 4; j++) {
                if ( (board[i][j].getNum() != 0) && (board[i][j].getNum()  == board[i+1][j+1].getNum())  && ( board[i][j].getNum() == board[i+2][j+2].getNum())   && ( board[i][j].getNum() == board[i+3][j+3].getNum() ) ) {
                    return true;
                }
            }
        }
        return false;
    }


}
