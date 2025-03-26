package JPMC;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        /**
         * Song
         * - id // UUID
         * - title // String
         * - artist // String
         * - genre // Enum (Rock/ Pop)
         * - no. of time played // number
         * - fn given list of  pick the  song with highest plays
         */

        /**
         * Add songs to the lib    -----> done
         * Search by artist, title or genre
         * Get 5 most popular songs
         * Update the metadata of songs
         */
        Scanner sc = new Scanner(System.in);
        Song song1 = new Song(UUID.randomUUID(), "SOng1", "Artist1", Genre.ROCK, 10);
        Song song2 = new Song(UUID.randomUUID(), "SOng2", "Artist2", Genre.POP, 1000);
        Song song3 = new Song(UUID.randomUUID(), "SOng3", "Artist3", Genre.ROCK, 125);
        List<Song> songs = new ArrayList<>(Arrays.asList(song1, song2, song3));

//        addSong(songs, sc);    // add song
        Optional<List<Song>> filtered = searchSong("song1", songs);
        filtered.ifPresent(songList -> songList.forEach(song -> System.out.println(song.getTitle())));

        sc.close();

    }

    public static void addSong(List<Song> songs, Scanner sc) {
        System.out.println("Please enter the song details you would like to add: title, artist, genre");
        String title  = sc.nextLine();
        String artist = sc.nextLine();
        String genre = sc.nextLine();
        UUID id = UUID.randomUUID();
        Song song = new Song(id, title, artist, Genre.valueOf(genre), 0);
        System.out.println(song.getTitle()+" "+ song.getNo_of_times_played());
        songs.add(song);
    }

    public static Optional<List<Song>> searchSong(String query, List<Song> songs) {
        return Optional.of(songs.stream()
                .filter(song -> song.getTitle().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList()));
    }

}
