package movie;

import user.User;

import java.util.List;
import java.util.Scanner;

public interface MovieInterface {
    void watchMovieFunction(Scanner scanner, List<Movie> movieList, User currentUser);

    void uploadMovies(String title, String genre, int releaseYear, String[] actors, double rating, int duration);

    void searchMovie(String searchParam, String searchType);

    void allAboutMovies(Scanner scanner);
}
