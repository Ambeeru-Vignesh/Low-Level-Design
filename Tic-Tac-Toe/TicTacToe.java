import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class TicTacToe {
    private Deque<Player> players;
    private Board gamingBoard;

    public void intializeGame(){
            players = new LinkedList<>();

            PlayingPieceX playingPieceX = new PlayingPieceX(PlayingType.X);
            PlayingPieceO playingPieceO = new PlayingPieceO(PlayingType.O);

            Player player1 = new Player("Player1", playingPieceX);
            Player player2 = new Player("Player2", playingPieceO);

            players.add(player1);
            players.add(player2);

            gamingBoard = new Board(3);
    }

    public String startGame() {
            boolean isWinner = true;

            while (isWinner) {
                Player playerTurn = players.removeFirst();

                gamingBoard.printBoard();
                List<SimpleEntry<Integer, Integer>> freeCells = gamingBoard.getFreeCells();

                if(freeCells.isEmpty()){
                    isWinner = false;
                    continue;
                }

                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();

                String[] values = s.split(",");

                int Row = Integer.valueOf(values[0]);
                int Col = Integer.valueOf(values[1]);

                boolean pieceAdded = gamingBoard.addPiece(Row, Col, playerTurn.getPlayingPiece());
                if (!pieceAdded){
                    players.addFirst(playerTurn);
                    continue;
                }
                players.addLast(playerTurn);

                boolean winner = isThereWinner(Row, Col, playerTurn.getPlayingPiece().getPlayingType());
                if (winner){
                    return playerTurn.getName();
                }
            }
            return "Tie";
    }

    public boolean isThereWinner(int row, int column, PlayingType pieceType) {
            boolean rowMatch = true;
            boolean columnMatch = true;
            boolean diagonalMatch = true;
            boolean antiDiagonalMatch = true;

            //need to check in row
            for(int i=0;i<gamingBoard.getSize();i++) {
                if(gamingBoard.getBoard()[row][i] == null || gamingBoard.getBoard()[row][i].getPlayingType() != pieceType) {
                    rowMatch = false;
                }
            }

            //need to check in column
            for(int i=0;i<gamingBoard.getSize();i++) {
                if(gamingBoard.getBoard()[i][column] == null || gamingBoard.getBoard()[i][column].getPlayingType() != pieceType) {
                    columnMatch = false;
                }
            }
            
            //need to check diagonals
            for(int i=0, j=0; i<gamingBoard.getSize();i++,j++) {
                if (gamingBoard.getBoard()[i][j] == null || gamingBoard.getBoard()[i][j].getPlayingType() != pieceType) {
                    diagonalMatch = false;
                }
            }

            //need to check anti-diagonals
            for(int i=0, j=gamingBoard.getSize()-1; i<gamingBoard.getSize();i++,j--) {
                if (gamingBoard.getBoard()[i][j] == null || gamingBoard.getBoard()[i][j].getPlayingType() != pieceType) {
                    antiDiagonalMatch = false;
                }
            }

            return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}   
