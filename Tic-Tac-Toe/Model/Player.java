public class Player {
    private String Name;
    private PlayingPiece playingPiece;

    public Player(String Name, PlayingPiece playingPiece){
        this.Name = Name;
        this.playingPiece = playingPiece;
    }

    public String getName(){
        return Name;
    }

    public PlayingPiece getPlayingPiece(){
        return playingPiece;
    }
}
