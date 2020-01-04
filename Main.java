import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();
    private static boolean forward = true;
    private static ListIterator<Song> listIterator;
    public static void main(String[] args) {

        listIterator = playlist.listIterator();
        System.out.println("Welcome to Mark's playlist!");
        System.out.println("============================");
        Album newAlbum = new Album("Coast to coast");
        newAlbum.addSong("My Love", 353);
        newAlbum.addSong("What makes a man", 351);
        newAlbum.addSong("I lay my love on you", 331);
        newAlbum.addSong("I have a dream", 416);
        newAlbum.addSong("Against all odds", 322);
        albums.add(newAlbum);

        albums.get(0).addSongToPlayList("My Love", playlist);
        albums.get(0).addSongToPlayList("What makes a man", playlist);
        albums.get(0).addSongToPlayList("I lay my love on you", playlist);
        albums.get(0).addSongToPlayList("I have a dream", playlist);
        albums.get(0).addSongToPlayList("Against all odds", playlist);

        play(playlist);
    }

    private static void printPlaylistAlbums(Album album) {

        System.out.println("List of Songs added in the Album:\n");

        for(int i=0;i<album.getSongs().size();i++) {
            System.out.println(album.getSongs().get(i).getSongName());
        }
    }
    private static void play(LinkedList<Song> songs){
        boolean quit = false;

        if(playlist.size()==0){
            System.out.println("No songs in playlist.");
        }
        else{
            for(int i = 0; i<playlist.size();i++) {
                System.out.println("Now playing " + listIterator.next().toString());
            }
        }
        while(!quit){
            System.out.println("Choose your option please.");
            int choose = scan.nextInt();
            scan.nextLine();

            switch(choose){
                case -1:
                    quit = true;
                    System.out.println("Exiting the playlist!");
                    break;
                case 1:
                    goForward();
                    break;
                case 2:
                    goPrevious();
                    break;
                case 3:
                    replaySong();
                    break;
//                case 4:
//                    listSongsInCurrentPlaylist();
//                    break;
//                case 5:
//                    removeCurrentSong();
//                    break;
//                case 0:
//                    printOptions();
                default:
                    System.out.println("Please type the correct number.");
                    break;
            }
        }
    }
    private static void goForward() {
        if (!forward) {
            if (listIterator.hasNext()) {
                listIterator.next();
                forward = true;
            }
        }
        if (!listIterator.hasNext()) {
            System.out.println("Reached the end of the playlist.");
            return;
        }
        System.out.print("Playing ");
        playMessage(listIterator.next());
    }


    public static void goPrevious() {
        if (forward) {
            if (listIterator.hasPrevious()) {
                listIterator.previous();
                forward = false;
            }
        }
        if (!listIterator.hasPrevious()) {
            System.out.println("We are at the beginning of the playlist");
            return;
        }
        System.out.print("Playing ");
        playMessage(listIterator.previous());
    }

    public static void replaySong() {
        Song song = null;

        if (forward) {
            if (listIterator.hasPrevious()) {
                song = listIterator.previous();
                forward = false;
            }
        } else {
            if (listIterator.hasNext()) {
                song = listIterator.next();
                forward = true;
            }
        }
        if (song == null) {
            System.out.println("Nothing to play");
            return;
        }
        System.out.print("Playing ");
        playMessage(song);
    }
    private static void playMessage(Song song) {
        System.out.println("'" + song.getSongName() + "' from the album '" + getAlbumTitleBySong(song) + "'.  Duration: " + (song.getDuration()/60) + ":" + (song.getDuration()%60));
    }
    private static String getAlbumTitleBySong(Song song) {
        for(int i = 0; i < albums.size(); i++) {
            if (albums.get(i).hasSong(song.getSongName())) {
                return albums.get(i).getAlbumName();
            }
        }
        return null;
    }
}