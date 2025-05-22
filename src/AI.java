import java.util.ArrayList;

public class AI {
    private static Space[][] copyOfBoard;
    private int aiSymbol;
    private int playerSymbol;
    public AI(){
        aiSymbol = 2;
        playerSymbol = 1;
    }

    public static int miniMax(Space[][] board, int depth, int end,boolean maximizing ){
        // Base statement for when to stop the recursion
        if (isFull() || depth == 0){
            return 0;
        }

        // Check if the method is maximizing
        // if it is, iterate through the columns of the board and if it is not an empty space, skip it.
        // create a copy of the board and apply possible moves in those test boards. And then set the score of those to the miniMax method with a lower depth
        // check if the score gotten from the recursion is better than the best score, if it is, change best score to score and best move to the column
        // else if its minimizing, AI wants to get the lowest score for the human
        // iterate through the columns of the board and if it is not an empty space, skip it.
        // create a copy of the board and apply possible moves in those test boards. And then set the score of those to the miniMax method with a lower depth
        // check if the score gotten from the recursion is lower than the best score, if it is, change best score to score
        // at the end, if depth is reached, return bestMove else if its not, return best score.

        return 1;
    }

    public static boolean isFull(){
        int count = 0;
        for (int i = 0; i < copyOfBoard.length; i++) {
            for (int j = 0; j < copyOfBoard[0].length; j++) {
                if (copyOfBoard[i][j].getNum() == 0){
                    count++;
                }
            }
        }
        if (count != 0){
            return false;
        }
        return true;
    }

//    public boolean isValid(int col, Space[][] gameBoard){
//        if (col < 0 || col >= gameBoard[0].length){
//            return false;
//        }
//        return copyOfBoard[copyOfBoard.length - 1][col].getNum() == 0;
//    }

    public static Space[][] copyBoard(Space[][] board){
        Space[][] newBoard = new Space[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = new Space(board[i][j].getNum());
            }
        }
        return newBoard;
    }

    public void placeMove(Space[][] gameBoard, int col, Player player){
        for (int i = 0; i < gameBoard.length; i ++) {
            if (gameBoard[i][col].getNum() == 0){
                gameBoard[i][col] = new Space(playerSymbol);
                break;
            }
        }
    }

    // not finished
    public static int evaluateBoard(Space[][] gameBoard, String aiSymbol, String humanSymbol){
        int aiCount = 0;
        int humanCount = 0;
        for (int c = 2; c <= 4 ; c++) {
            for (int i = 0; i < gameBoard.length; i++) {
                if (gameBoard[i][c].getNum() == 2){
                    aiCount++;
                } else if (gameBoard[i][c].getNum() == 1){
                    humanCount++;
                }
            }
        }
        return 0;
    }

    public int[] getValidLocations(){
        ArrayList<Integer> validLocations = new ArrayList<Integer>();
        for (int i = 0; i < copyOfBoard[0].length; i++) {
            if (isValid(i)){
                validLocations.add(i);
            }
        }
        int[] valid = new int[validLocations.size()];
        for (int i = 0; i < validLocations.size(); i++) {
            valid[i] = validLocations.get(i);
        }
        return valid;
    }

    public static boolean isValid(int col){
        return copyOfBoard[copyOfBoard.length - 1][col].getNum() == 0;
    }

    public static int evaluateLines(Space[][] board, int num, Player player){
        //determines the importance of each space
        int score = 0;

        //checks for three ina  row and if it is, adds score
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[j].length; j++) {
                try {
                    if ( (board[i][j].getNum()== 1) && (board[i][j].getNum() == board[i][j+1].getNum())  && ( board[i][j].getNum() == board[i][j+2].getNum() )){
                        score += 150;
                    } else
                        score += 100;
                } catch (Exception e){
                    break;
                }
            }
        }
        return score;
    }
}
