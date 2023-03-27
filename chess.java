import java.util.HashMap;

public class chess {

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
    // chess.chessBoard();
    int[] res = chess.coordinates("C2");
    System.out.println(res[0]);
    System.out.println(res[1]);
  }
}
