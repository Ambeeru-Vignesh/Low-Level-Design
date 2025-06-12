public class Player {
    private String Name;
    private PlayingType playingType;

    public Player(String Name, PlayingType playingType){
        this.Name = Name;
        this.playingType = playingType;
    }

    public String getName(){
        return Name;
    }

    public PlayingType getPlayingType(){
        return playingType;
    }
}
