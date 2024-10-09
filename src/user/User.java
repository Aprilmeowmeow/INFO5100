package user;

import movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Movie> watchedMovies = new ArrayList<>();
    private List<Movie> recommendedMovies = new ArrayList<>();
    private Profile profile;
    private Billing billing;
    private Preferences preferences;

    public User(String username, String email, Profile profile, Billing billing, Preferences preferences) {
        this.username = username;
        this.email = email;
        this.profile = profile;
        this.billing = billing;
        this.preferences = preferences;
    }

    public void watchMovie(Movie movie) {
        watchedMovies.add(movie);
        movie.play();
    }

    public Profile getProfile() {
        return profile;
    }

    public Billing getBilling() {
        return billing;
    }

    public Preferences getPreferences() {
        return preferences;
    }

}


