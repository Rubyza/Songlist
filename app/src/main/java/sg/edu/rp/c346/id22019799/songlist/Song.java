package sg.edu.rp.c346.id22019799.songlist;

import java.io.Serializable;
import java.util.Calendar;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private String stars;


    public Song(int id, String title, String singers, int year, String stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {return id;}

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public String getStars() {
        return stars;
    }

    public String toString() {
        String str = id+"\n"+title+"\n"+singers +"\n"+year+" "+stars;

        return str;
    }
}