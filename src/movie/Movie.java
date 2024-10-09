package movie;

public class Movie {

    private String title;
    private String genre;
    private int releaseYear;
    private String[] actors;
    private double rating;
    private int duration;

    public Movie(String title, String genre, int releaseYear, String[] actors, double rating, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.actors = actors;
        this.rating = rating;
        this.duration = duration;
    }

    public void play() {
        System.out.println("Playing the movie: " + title);
    }

    public String getDetails() {
        return "Movie title: " + title + "\nGenre: " + genre + "\nYear: " + releaseYear + "\nRating: " + rating + "\nDuration: " + duration + " minutes" + "\n----------------------------";
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

}