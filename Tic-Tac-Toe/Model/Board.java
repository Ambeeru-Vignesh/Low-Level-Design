import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
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

    public List<SimpleEntry<Integer, Integer>> getFreeCells(){
        List<SimpleEntry<Integer, Integer>> freeCells = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new SimpleEntry<>(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPlayingType() + " ");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }
}