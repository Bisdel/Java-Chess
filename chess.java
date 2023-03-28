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

        public Player pickAColor(Player player) {
            // asks Player 1 for its name and to pick a color between black and white
            System.out.println("Player 1, what's your name ?");
            player.name = sc.nextLine();
            System.out.println("Welcome " + player.name + " !\nWhich color would you play ? Enter W to play white, or B to play black.");
            while (true) {
                player.color = sc.nextLine();
                if (player.color.equals("W") || player.color.equals("w")) {
                    player.color = "white";
                    System.out.println(player.name + " will play white. The convention in chess is white starts, so it's your turn !");
                    return player;
                } else if (player.color.equals("B") || player.color.equals("b")) {
                    player.color = "black";
                    System.out.println(player.name + " will play black. The convention in chess is white starts, so it's your opponent's turn.");
                    return player;
                } else {
                    System.out.println("You didn't enter W or B. Please focus and pick W or B to choose your color.");
                }
            }
        }

        public Player setupPlayer2(Player player1, Player player2) {
            // setup Player 2's name & color according to the color picked by Player 1
            System.out.println("Hello Player 2, what's your name ?");
            player2.name = sc.nextLine();
            if (player1.color.equals("white")) {
                player2.color = "black";
            } else {
                player2.color = "white";
            }
            System.out.println("Welcome " + player2.name + " !\nYour opponent plays " + player1.color + ", so you will play " + player2.color + ".");
            System.out.println("Press Enter key when you are both ready to play :)");
            sc.nextLine();
            return player2;

        }
    }

    public static class Board {

        public static String board = "\n     A     B     C     D     E     F     G     H     \n  +-----+-----+-----+-----+-----+-----+-----+-----+\n8 |     |     |     |     |     |     |     |     | 8\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n7 |     |     |     |     |     |     |     |     | 7\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n6 |     |     |     |     |     |     |     |     | 6\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n5 |     |     |     |     |     |     |     |     | 5\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n4 |     |     |     |     |     |     |     |     | 4\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n3 |     |     |     |     |     |     |     |     | 3\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n2 |     |     |     |     |     |     |     |     | 2\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n1 |     |     |     |     |     |     |     |     | 1\n  +-----+-----+-----+-----+-----+-----+-----+-----+\n     A     B     C     D     E     F     G     H     \n";

        // Matrice 8x8 representant les emplacements occupes par les pieces. 1>noir
        // -1>blanc
        public static int[][] boardStatus = new int[8][8];

        public HashMap<String, String> piecePositions = new HashMap<String, String>();

        public void initPositions() {
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
        }

        public void displayBoard() {
            System.out.println(board);
        }

        public void goToBoardFirstChar() {
            // if the terminal used accepts \r, cursor scrolls up to the beginning of board,
            // else it prints as much lines as in the board
            String findStr = "\n";
            int countLinefeeds = board.split(findStr, -1).length - 1;
            for (int i = 0; i <= countLinefeeds; i++) {
                System.out.println("\r");
            }
        }

        public static int[] coordinates(String displacement) {
            int x = 7 - (displacement.charAt(1) - '0' - 1);
            int y = displacement.charAt(0) - 'A';
            int[] coordinates = { x, y };
            return coordinates;
        }

        public int chessboardCoordinate(int[] coordinates) {
            return 109 + 106 * coordinates[0] + 6 * coordinates[1] + 2;
        }

        // Init boardStatus attribute of Board class
        public void initBoardStatus(HashMap<String, String> piecePositions) {
            for (HashMap.Entry<String, String> set : piecePositions.entrySet()) {
                String piece = set.getKey(); // BT1, BC1...
                String piecePosition = set.getValue(); // A8, B8...

                int[] pieceCoordinates = coordinates(piecePosition); // {1,4}
                int color = piece.toLowerCase().charAt(0) > 100 ? 1 : -1; // choose between 1 / -1 / 0

                boardStatus[pieceCoordinates[0]][pieceCoordinates[1]] = color; // update boardStatus Entry
            }
        }

        // Update boardStatus attribute of Board class
        public void updateBoardStatus(String oldPosition, String newPosition) { // args -> "A6", "D3"
            int[] oldCoordinates = coordinates(oldPosition); // "A6" -> {1,4}
            int[] newCoordinates = coordinates(newPosition); // "D3" -> {5,2}

            // write old color into the new position
            boardStatus[newCoordinates[0]][newCoordinates[1]] = boardStatus[oldCoordinates[0]][oldCoordinates[1]]; 
            // write 0 into the old position
            boardStatus[oldCoordinates[0]][oldCoordinates[1]] = 0; 
        }
    }

    // abstract for pieces
    public static interface Piece {
        int[][] listMoves();

        int checkAtPosition(int i, int j);

        void updatePosition(String chessboardPosition);

        boolean canCapture(int i, int j);
    }

    public class Pawn implements Piece {
        String name;                    // name of the piece (BP1, WP4)
        int color;                      // color black: 1, white: -1
        int[] position = new int[2];    // position of the piece (on the 8x8 matrix)
        boolean firstMove = true;       // is it the first move of the pawn ? (useful for list of moves)

        // constructor
        public Pawn(String pawnName, String chessboardPosition) {
            this.name = pawnName;
            this.color = (pawnName.toLowerCase().charAt(0) > 100) ? 1 : -1;
            int[] coordinates = Board.coordinates(chessboardPosition);
            this.position[0] = coordinates[0];
            this.position[1] = coordinates[1];
        }

        // check presence of a piece at line i, column j on the 8x8 matrix
        public int checkAtPosition(int i, int j) { // check if a piece at (i, j) returns 1 if black, -1 if white
            return Board.boardStatus[i][j];
        }

        // list of possible moves of the piece located at line i, column j
        public int[][] listMoves() {
            int i = this.position[0];
            int j = this.position[1];
            int[][] moves;
            if (this.firstMove) {
                moves = new int[][] { { i + 1, j }, { i + 2, j } };
                this.firstMove = false;
            } else {
                moves = new int[][] { { i + 1, j } };
            }
            // check if a piece is already at the new position
            for (int k = 0; k < moves.length; k++) {
                if (checkAtPosition(moves[k][0], moves[k][1]) != 0) {
                    moves[k] = null;
                }
            }
            return moves;
        }
        
        // check if the pawn can capture a piece at line i, column j
        public boolean canCapture(int i, int j) {
            // loop to check the piece color at (forward) diagonal
            int diagNeighbor = checkAtPosition(i, j);
            if (diagNeighbor == 0 || diagNeighbor == this.color) {
                return false;
            }
            else {
                return true;
            }
        }

        // update the position of the piece
        public void updatePosition(String chessboardPosition) {
            int[] newCoordinates = Board.coordinates(chessboardPosition);
            boolean moveIsValid = false;
            int[][] listMoves = listMoves();
            for (int k = 0; k < listMoves.length; k++) {
                if (newCoordinates[0] == listMoves[k][0] && newCoordinates[1] == listMoves[k][1]) {
                    moveIsValid = true;
                    break;
                }
            }
            // check if the pawn can move or capture
            if (moveIsValid || canCapture(newCoordinates[0], newCoordinates[1])) { // either the pawn moves forward or diagonally if it can capture a piece
                this.position[0] = newCoordinates[0];
                this.position[1] = newCoordinates[1];
            }
        }
    }

    public class Bishop implements Piece {
        String name;                    // name of the piece (BB1, WB4)
        int color;                      // color black: 1, white: -1
        int[] position = new int[2];    // position of the piece (on the 8x8 matrix)

        // constructor
        public Bishop(String pawnName, String chessboardPosition) {
            this.name = pawnName;
            this.color = (pawnName.toLowerCase().charAt(0) > 100) ? 1 : -1;
            int[] coordinates = Board.coordinates(chessboardPosition);
            this.position[0] = coordinates[0];
            this.position[1] = coordinates[1];
        }

        // list of possible moves of the piece located at line i, column j
        public int[][] listMoves() {
            int i = this.position[0];
            int j = this.position[1];
            int[][] moves;
            
            moves = new int[][] { { i + 1, j } };
            
            return moves;
        }

        @Override
        public int checkAtPosition(int i, int j) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'checkAtPosition'");
        }

        @Override
        public void updatePosition(String chessboardPosition) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'updatePosition'");
        }

        @Override
        public boolean canCapture(int i, int j) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'canCapture'");
        }

    }

    public static class Plays {
        // TO DO : implement playing moves by interacting positions dictionnary,
        // possible moves and refreshing board matrix
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Chess-Mates !");
        Player player1 = new Player("", "");
        player1 = player1.pickAColor(player1);
        Player player2 = new Player("", "");
        player2 = player2.setupPlayer2(player1, player2);

        Board board = new Board();
        board.displayBoard();

        while (true) {
            sc.nextLine(); // to simulate user plays
            board.goToBoardFirstChar(); // if the terminal used accepts \r, cursor scrolls up to the beginning of board, else it prints as much lines as in the board
            board.displayBoard();
        }
    }
}