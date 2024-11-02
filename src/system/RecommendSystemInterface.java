package system;

import movie.Movie;
import user.User;

import java.util.List;
import java.util.Scanner;

public interface RecommendSystemInterface {
    void recommendMovieToUser(User recommender, User receiver, Movie movie);

    List<Movie> getRecommendedMovie(User user);

    List<Movie> showRecommendationsForUser(User user);

    void recommendMovie(Scanner scanner);

    void userRecommendList();
}
