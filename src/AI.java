import java.util.ArrayList;

public class AI {
    private static Space[][] copyOfBoard;
    private int aiSymbol;
    private int playerSymbol;
    public AI(){
        aiSymbol = 2;
        playerSymbol = 1;
    }

    public static  int miniMax(int depth, Space[][] board){
        if (isFull() || depth == 0){
            return 0;
        }
        return 1;
    }

    public static void copyBoard(Space[][] board){
        copyOfBoard = board;
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

    public static boolean isValid(int col){
        return copyOfBoard[copyOfBoard.length - 1][col].getNum() == 0;
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

}
