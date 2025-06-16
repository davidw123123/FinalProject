import java.util.ArrayList;

public class AI {

    private int aiSymbol = 2;
    private int playerSymbol = 1;
    public AI(){
    }

    // Check if the method is maximizing
    // if it is, iterate through the columns of the board and if it is not an empty space, skip it.
    // create a copy of the board and apply possible moves in those test boards. And then set the score of those to the miniMax method with a lower depth
    // check if the score gotten from the recursion is better than the best score, if it is, change best score to score and best move to the column
    // else if its minimizing, AI wants to get the lowest score for the human
    // iterate through the columns of the board and if it is not an empty space, skip it.
    // create a copy of the board and apply possible moves in those test boards. And then set the score of those to the miniMax method with a lower depth
    // check if the score gotten from the recursion is lower than the best score, if it is, change best score to score
    // at the end, if depth is reached, return bestMove else if it's not, return best score.
    public static int miniMax(Space[][] board, int depth, int end,boolean maximizing ){
        // Base statement for when to stop the recursion
        if (depth == 0 || isFull(board) || ConnectFour.checkWin(board) != 0){

            return evaluateBoard(board);
        }
        int bestScore;
        int bestMove = -1;
        if (maximizing){
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < board[0].length; i++) {
                if (!isValid(board, i)){
                    continue;
                }
                Space[][] copy = copyBoard(board);
                applyMove(copy, i, 2);
                int score = miniMax(copy, depth-1, end, false);
                if (score > bestScore){
                    bestScore = score;
                    bestMove = i;
                }
            }

        }
        else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < board[0].length; i++) {
                if (!isValid(board, i)){
                    continue;
                }
                Space[][] copy = copyBoard(board);
                applyMove(copy, i, 1);
                int score = miniMax(copy, depth-1, end, true);
                if (score < bestScore){
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        if (depth == end){
            return bestMove;
        } else {
            return bestScore;
        }
    }

    //evaluates the board and gives a score
    public static int evaluateBoard(Space[][] board){
        int score = 0;
        if (ConnectFour.checkWin(board) == 1){
            return -9999;
        } else if (ConnectFour.checkWin(board) == 2){
            return 9999;
        }
        score += evaluateCenter(board, 2, 1);
        score += evaluateLines(board, 2);
        score -= evaluateLines(board, 1);

        return score;
    }

    //
    public static void applyMove(Space[][] board, int col, int player){
        for (int i = board.length-1; i >= 0; i--) {
            if (board[i][col].getNum() == 0){
                board[i][col] = new Space(player);
                break;
            }
        }
    }
    public static boolean isFull(Space[][] board){
        int count = 0;
        for (Space[] spaces : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (spaces[j].getNum() == 0) {
                    count++;
                }
            }
        }
        return count == 0;
    }


    public static Space[][] copyBoard(Space[][] board){
        Space[][] newBoard = new Space[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = new Space(board[i][j].getNum());
            }
        }
        return newBoard;
    }

    // evaluates the center of the board which is very important to the control of the game. Counts the amount of spaces ai has vs human.
    // negative number means unfavorable for ai while positive means favorable
    public static int evaluateCenter(Space[][] gameBoard, int aiSymbol, int humanSymbol){
        int aiCount = 0;
        int humanCount = 0;
        for (int c = 2; c <= 4 ; c++) {
            for (Space[] spaces : gameBoard) {
                if (spaces[c].getNum() == 2) {
                    aiCount++;
                } else if (spaces[c].getNum() == 1) {
                    humanCount++;
                }
            }
        }
        return (int) ((aiCount - humanCount) * 2.5);
    }


    public static boolean isValid(Space[][] board, int col){
        return board[0][col].getNum() == 0;
    }

    public static int evaluateLines(Space[][] board, int num){
        //determines the score for the overall board
        int score = 0;

        //checks for three in a row and if it is, adds score
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 2; j++) {
                if ((board[i][j].getNum() == num) && (board[i][j].getNum() == board[i][j + 1].getNum()) && (board[i][j].getNum() == board[i][j + 2].getNum())) {
                    score += 150;
                }
            }
        }

        // horizontal two in a row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if ((board[i][j].getNum() == num) && (board[i][j + 1].getNum() == num)){
                    score += 5;
                }
            }
        }

        //vertical 3 in a row checker
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j].getNum() == num) && (board[i][j].getNum() == board[i+1][j].getNum()) && (board[i][j].getNum() == board[i+2][j].getNum())) {
                    score += 150;
                }
            }
        }

        //vertical two in a row
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j].getNum() == num) && (board[i+1][j].getNum() == num)) {
                    score += 5;
                }
            }
        }

        //diagonal three in a row
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 0; j < board[0].length - 2; j++) {
                if ((board[i][j].getNum() == num) && (board[i+1][j+1].getNum() == num) && (board[i+2][j+2].getNum() == num)){
                    score += 150;
                }
            }
        }

        //reverse diagonal three in a row
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 2; j < board[0].length; j++) {
                if ((board[i][j].getNum() == num) && (board[i+1][j-1].getNum() == num) && (board[i+2][j-2].getNum() == num)){
                    score += 150;
                }
            }
        }

        //diagonal two in a row
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = 2; j < board[0].length; j++) {
                if ((board[i][j].getNum() == num) && (board[i+1][j-1].getNum() == num) && (board[i+2][j-2].getNum() == num)){
                    score += 150;
                }
            }
        }
        //reverse diagonal two in a row
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if ((board[i][j].getNum() == num) && (board[i+1][j-1].getNum() == num)){
                    score += 5;
                }
            }
        }

        return score;
    }
}
