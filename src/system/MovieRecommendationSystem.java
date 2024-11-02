package system;

import movie.Movie;
import user.User;

import java.util.*;

public class MovieRecommendationSystem implements RecommendSystemInterface {
    private List<User> allUsers = new ArrayList<>();
    private Map<User, List<Movie>> userRecommendations = new HashMap<>();

    public MovieRecommendationSystem() {

    }

    @Override
    public void recommendMovieToUser(User recommender, User receiver, Movie movie) {
        List<Movie> recommendedMovies = userRecommendations.get(receiver);

        if (recommendedMovies == null) {
            recommendedMovies = new ArrayList<>();
        }

        recommendedMovies.add(movie);

        userRecommendations.put(receiver, recommendedMovies);
    }

    @Override
    public List<Movie> getRecommendedMovie(User user) {
        return userRecommendations.getOrDefault(user, new ArrayList<>());
    }

    @Override
    public List<Movie> showRecommendationsForUser(User user) {
        List<Movie> recommendedMovie = getRecommendedMovie(user);
        if (recommendedMovie == null) {
            return null;
        } else {
            return recommendedMovie;
        }
    }

    @Override
    public void recommendMovie(Scanner scanner){
        System.out.print("Enter the username to recommend a movie to: ");
        String username = scanner.nextLine();
        User receiver = username.equals("eastwang1202") ? User.user2 : User.user1;
        System.out.println("Select a movie to recommend:");
        for (int i = 0; i < Movie.movieList.size(); i++) {
            System.out.println((i + 1) + ". " + Movie.movieList.get(i).getDetails());
        }
        System.out.println("Enter your movie choice: ");
        int movieChoice = scanner.nextInt() - 1;
        if (movieChoice >= 0 && movieChoice < Movie.movieList.size()) {
            recommendMovieToUser(User.currentUser, receiver, Movie.movieList.get(movieChoice));
            System.out.println("Your movie recommended successfully.");
        } else {
            System.out.println("Invalid movie selection.");
        }
    }

    @Override
    public void userRecommendList(){
        System.out.println("Movies recommended to you:");
        List<Movie> recommendations = showRecommendationsForUser(User.currentUser);
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {
            recommendations.forEach(movie -> System.out.println(movie.getDetails()));
        }
    }
}
