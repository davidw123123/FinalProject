import java.util.Scanner;

public class GridTester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean gameOver = false;
        ConnectFour g = new ConnectFour();
        System.out.println();

            while (g.checkWin()){
                int move = s.nextInt();
                int c = s.nextInt();
                g.place(c, move);
                g.printBoard();
                g.verticalChecker();
                g.horizontalChecker();
                g.reverseDiagonalChecker();
                g.diagonalChecker();
            }

    }
}
