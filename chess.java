import java.util.HashMap;
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
    
        public int[] coordinates(String displacement) {
        int x = 7 - (displacement.charAt(1) - '0' - 1);
        int y = displacement.charAt(0) - 'A';
        int[] coordinates = {x, y};
        return coordinates;
    }

    public int chessboardCoordinate(int[] coordinates) {
        return 109 + 106 * coordinates[0] + 6 * coordinates[1] + 2;
    }

    public static void main(String[] args) {
        chess chess = new chess();
        HashMap<String, String> piecePositions = new HashMap<>();
          piecePositions.put("BT1", "A8");
          piecePositions.put("BC1", "B8");
          piecePositions.put("BB1", "C8");
          piecePositions.put("BK_", "D8");
          piecePositions.put("BQ_", "E8");
          piecePositions.put("BB2", "F8");
          piecePositions.put("BC2", "G8");
          piecePositions.put("BT2", "H8");
          piecePositions.put("BP1", "A7");
          piecePositions.put("BP2", "B7");
          piecePositions.put("BP3", "C7");
          piecePositions.put("BP4", "D7");
          piecePositions.put("BP5", "E7");
          piecePositions.put("BP6", "F7");
          piecePositions.put("BP7", "G7");
          piecePositions.put("BP8", "H7");
          piecePositions.put("WP1", "A2");
          piecePositions.put("WP2", "B2");
          piecePositions.put("WP3", "C2");
          piecePositions.put("WP4", "D2");
          piecePositions.put("WP5", "E2");
          piecePositions.put("WP6", "F2");
          piecePositions.put("WP7", "G2");
          piecePositions.put("WP8", "H2");
          piecePositions.put("WT1", "A1");
          piecePositions.put("WC1", "B1");
          piecePositions.put("WB1", "C1");
          piecePositions.put("WK_", "D1");
          piecePositions.put("WQ_", "E1");
          piecePositions.put("WB2", "F1");
          piecePositions.put("WC2", "G1");
          piecePositions.put("WT2", "H1");
    int[] res = chess.coordinates("C2");
    System.out.println(res[0]);
    System.out.println(res[1]);
  }
}
