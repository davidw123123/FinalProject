import java.util.Scanner;
public class GridTester {
    public static void main(String[] args) {
        ConnectFour g = new ConnectFour();
        g.startGame();







//        Scanner s;
//        s = new Scanner(System.in);
//        ConnectFour g = new ConnectFour();
//        //ConnectFour.checkWin(g.getBoard()) == 0
//        while (true){
//            int move = s.nextInt();
//            int c = s.nextInt();
//            g.place(c, move);
//            g.printBoard();
//            test(g.getBoard());
//        }
//
//
    }
//    public static int test(Space[][] board) {
//        int score = 0;
//        for (int i = 0; i < board.length-2; i++) {
//            for (int j = 0; j < board[0].length-2; j++) {
//                if ((board[j][i].getNum()==1) && board[i+1][j+1].getNum() == 1 && (board[i+2][j+2].getNum() == 1)){
//                    System.out.println(i + " " + j);
//                    score += 5;
//                }
//            }
//        }
//        return score;
//    }
}
