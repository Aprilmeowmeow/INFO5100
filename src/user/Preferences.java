package user;

import movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Preferences {
    private String[] favoriteGenres;
    private int preferredMaxDuration;
    private double minimumRating;
    public static Preferences preferencesUser1 = new Preferences(new String[]{"Sci-Fi", "Drama"}, 150, 8.0);
    public static Preferences preferencesUser2 = new Preferences(new String[]{"Action", "Comedy"}, 120, 9.0);

    public Preferences(String[] favoriteGenres, int preferredMaxDuration, double minimumRating) {
        this.favoriteGenres = favoriteGenres;
        this.preferredMaxDuration = preferredMaxDuration;
        this.minimumRating = minimumRating;
    }

    public void updatePreferences(String[] genres, int maxDuration, double minRating) {
        this.favoriteGenres = genres;
        this.preferredMaxDuration = maxDuration;
        this.minimumRating = minRating;
    }

    public List<Movie> getRecommendedMovies(List<Movie> movies) {
        List<Movie> recommendedMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (isFavoriteGenre(movie.getGenre()) && movie.getDuration() <= preferredMaxDuration && movie.getRating() >= minimumRating) {
                recommendedMovies.add(movie);
            }
        }
        return recommendedMovies;
    }

    public boolean isFavoriteGenre(String genre) {
        for (String favoriteGenre : favoriteGenres) {
            if (favoriteGenre.equalsIgnoreCase(genre)) {
                return true;
            }
        }
        return false;
    }
}
