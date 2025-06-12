public abstract class PlayingPiece {
    protected PlayingType playingType;
    
    public PlayingPiece(PlayingType playingType) {
        this.playingType = playingType;
    }
    
    public PlayingType getPlayingType() {
        return playingType;
    }
}
