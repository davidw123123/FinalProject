import java.util.Scanner;

public class ConnectFour {
    private Space[][] board;
    private Scanner s;
    public ConnectFour() {
        setBoard();

    }
    public void startGame(){
        s = new Scanner(System.in);
        // turn this into menu/title screen
        // transfer all this to drawPanel
        System.out.println("1. Player vs Player"+"\n"+"2. Player vs AI");
        setBoard();
        int pick = s.nextInt();
        if (pick == 1){

            while (checkWin(this.board) == 0){
                printBoard();
                int move = s.nextInt();
                int c = s.nextInt();
                place(c, move);
            }
            if (checkWin(board) == 1){
                System.out.println("Player 1 Wins");
            } else
                System.out.println("Player 2 Wins");
        } else if (pick == 2){
            while (checkWin(this.board) == 0){
                printBoard();
                int move = s.nextInt();
                int c = s.nextInt();
                place(c, move);
                System.out.println( AI.miniMax(board, 2, 2, true));
            }

        }
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

    public static int checkWin(Space[][] board) {
        //diagonal
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

        //reverse diagonal
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

        //vertical
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

        //horizontal
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

}
