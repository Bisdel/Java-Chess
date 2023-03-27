import java.util.Scanner;

public class chess {

    public static Scanner sc = new Scanner(System.in);

    public static class Player {
        String name = "";
        String color = "";
        Player(String name, String color) {
            this.name = name;
            this.color = color;
        }
        void pickAColor() {
            System.out.println("What's your name ?");
            String name = sc.nextLine();
            System.out.println("Welcome " + name + " !\nWhich color would you play ? Enter 1 to play white, or 2 to play black.");
            String color = sc.nextLine();
            if (color == "W") {
                System.out.println(name + " will play white. The convention in chess is white starts, so it's your turn !");
            } else if (color == "B") {
                System.out.println(name + " will play black. The convention in chess is white starts, so it's your opponent's turn.");
            } else {
                System.out.println("You didn't entered W or B. Please focus and pick W or B to choose your color.");
            }
        }
    }

    public static void chessBoard() {
        String board = "\n     A     B     C     D     E     F     G     H     \n  +-----+-----+-----+-----+-----+-----+-----+-----+\n8 |     |     |     |     |     |     |     |     | 8\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n7 |     |     |     |     |     |     |     |     | 7\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n6 |     |     |     |     |     |     |     |     | 6\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n5 |     |     |     |     |     |     |     |     | 5\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n4 |     |     |     |     |     |     |     |     | 4\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n3 |     |     |     |     |     |     |     |     | 3\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n2 |     |     |     |     |     |     |     |     | 2\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n1 |     |     |     |     |     |     |     |     | 1\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n     A     B     C     D     E     F     G     H     \n";
        System.out.println(board);
    }

    public static void main(String[] args) {
        Player player1 = new Player("","");
        player1.pickAColor();
        Player player2 = new Player("","");
        player2.pickAColor();
        chessBoard();
    }
}
