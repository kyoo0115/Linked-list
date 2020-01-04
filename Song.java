public class Song{
    private String songName;
    private int duration;

    public Song(String name, int duration){
        this.songName = name;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public double getDuration() {
        return duration;
    }
    public Song createNewSong(String name, int duration){
        return new Song(name,duration);
    }

    @Override
    public String toString() {
        return this.songName + ": " + this.duration;
    }
}