import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private PlayingPiece[][] board;

    public Board(int size, PlayingPiece[][] board) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int Row, int Col, PlayingPiece playingPiece){
        if(board[Row][Col] != null){
            return false;
        }
        board[Row][Col] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){

        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>();
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                if (board[i][j] != null){
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println( " | ");
        }
    }

}