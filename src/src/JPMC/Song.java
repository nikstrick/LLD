package JPMC;

import java.util.UUID;

public class Song {
    private UUID id;
    private String title; // String
    private String artist; // String
    private Genre genre; // Enum (Rock/ Pop)
    private int no_of_times_played;  // number

    public Song(UUID id, String title, String artist, Genre genre, int no_of_times_played) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.no_of_times_played = no_of_times_played;
    }
    public int getNo_of_times_played() {
        return this.no_of_times_played;
    }
    public String getTitle() {
        return this.title;
    }

}
