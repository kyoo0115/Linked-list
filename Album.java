import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
    private String albumName;
    private ArrayList<Song> songs;

    public Album(String title){
        this.albumName = title;
        this.songs = new ArrayList<Song>();
    }
    public String getAlbumName(String title){
        return title;
    }

    public void addSong(String name, int duration){
        Song position = findSong(name);
        if((position) == null){
            this.songs.add(new Song(name, duration));

        }
        else{
            this.songs.add(new Song(name, duration));

        }
    }
    public Song findSong(String name){

        for (Song song : this.songs) {
            if (song.getSongName().equals(name)) {
                return song;
            }
        }
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }
    public void addSongToPlayList(String title, LinkedList<Song>playlist)
    {
        Song foundSong = findSong(title);
        if(foundSong != null)
        {
            playlist.add(foundSong);
        }
        else
        {
            System.out.println("The song " + title + " is not in this album.");
        }
    }
    public boolean hasSong(String name) {
        for(int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
