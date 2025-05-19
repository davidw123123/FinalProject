public class AI extends Space {
    private Space[][] copyOfBoard;
    public AI(int symbol){
        super(symbol);
    }

    public int miniMax(int depth, Space[][] board){
        if (isFull() || depth == 0){
            return 0;
        }

        return 1;
    }

    public void copyBoard(Space[][] board){
        copyOfBoard = board;
    }

    public boolean isFull(){
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
}
