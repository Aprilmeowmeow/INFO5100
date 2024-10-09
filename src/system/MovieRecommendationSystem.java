package system;

import movie.Movie;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRecommendationSystem {
    private List<User> allUsers = new ArrayList<>();
    private Map<User, List<Movie>> userRecommendations = new HashMap<>();

    public void recommendMovie(User recommender, User receiver, Movie movie) {
        List<Movie> recommendedMovies = userRecommendations.get(receiver);

        if (recommendedMovies == null) {
            recommendedMovies = new ArrayList<>();
        }

        recommendedMovies.add(movie);

        userRecommendations.put(receiver, recommendedMovies);
    }

    public List<Movie> getRecommendedMovie(User user) {
        return userRecommendations.getOrDefault(user, new ArrayList<>());
    }

    public List<Movie> showRecommendationsForUser(User user) {
        List<Movie> recommendedMovie = getRecommendedMovie(user);
        if (recommendedMovie == null) {
            return null;
        } else {
            return recommendedMovie;
        }
    }
}
