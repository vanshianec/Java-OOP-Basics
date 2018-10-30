import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Playlist playlist = new Playlist();
        while( N -- > 0){
            String tokens[] = reader.readLine().split(";");
                String authorName = tokens[0];
                String songName = tokens[1];
                int minutes=0;
                int seconds=0;
                try {
                    minutes = Integer.parseInt(tokens[2].split(":")[0]);
                    seconds = Integer.parseInt(tokens[2].split(":")[1]);
                }
                catch(Exception e){
                    System.out.println(Constants.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
                    continue;
                }
                Song song;
                try {
                    song = new Song(authorName, songName, minutes, seconds);
                    playlist.addSong(song);
                    System.out.println("Song added.");
                } catch (InvalidSongException e) {
                    System.out.println(e.getMessage());
                }

        }
        System.out.println("Songs added: "+playlist.getTotalSongs());
        System.out.println("Playlist length: "+ playlist.getPlaylistLength());

    }
}

class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;
    private static final int MAX_SONG_LENGTH_SECONDS = 899;
    private static final int MIN_SONG_LENGTH_SECONDS = 0;

    public Song(String artistName, String songName, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        checkSongLength(this.minutes,this.seconds);

    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException(Constants.INVALID_ARTIST_NAME_EXCEPTION_MESSAGE);
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException(Constants.INVALID_SONG_NAME_EXCEPTION_MESSAGE);
        }
        this.songName = songName;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(Constants.INVALID_SONG_MINUTES_EXCEPTION_MESSAGE);
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {

        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(Constants.INVALID_SONG_SECONDS_EXCEPTION_MESSAGE);
        }
        this.seconds = seconds;
    }

    private void checkSongLength(int minutes, int seconds) {
        int currentLength = minutes * 60 + seconds;
        if (currentLength < MIN_SONG_LENGTH_SECONDS || currentLength > MAX_SONG_LENGTH_SECONDS) {
            throw new InvalidSongLengthException(Constants.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
        }
    }



}

class Playlist {
    private List<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public int getTotalSongs() {
        return songs.size();
    }

    public String getPlaylistLength() {
        int totalSeconds = 0;
        for (Song song : songs) {
            totalSeconds+=song.getMinutes()*60+song.getSeconds();
        }
        return String.format("%dh %dm %ds",totalSeconds/3600,(totalSeconds%3600)/60,totalSeconds%60);

    }
}

class Constants {
    public static final String INVALID_ARTIST_NAME_EXCEPTION_MESSAGE = "Artist name should be between 3 and 20 symbols.";
    public static final String INVALID_SONG_NAME_EXCEPTION_MESSAGE = "Song name should be between 3 and 30 symbols.";
    public static final String INVALID_SONG_LENGTH_EXCEPTION_MESSAGE = "Invalid song length.";
    public static final String INVALID_SONG_MINUTES_EXCEPTION_MESSAGE = "Song minutes should be between 0 and 14.";
    public static final String INVALID_SONG_SECONDS_EXCEPTION_MESSAGE = "Song seconds should be between 0 and 59.";


}

class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}

class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String message) {
        super(message);
    }
}

class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException(String message) {
        super(message);
    }
}

class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException(String message) {
        super(message);
    }
}

class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}

class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}

//bad practice just for testing purpose










