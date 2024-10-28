package movie;

import java.util.*;

import user.User;

public class Movie implements MovieInterface{

    private String title;
    private String genre;
    private int releaseYear;
    private List<String> actors;
    private double rating;
    private int duration;
    private static final List<Movie> moviesData = new ArrayList<>();
    static Movie movie1 = new Movie("Dune", "Action", 2021, Arrays.asList("Timothée Hal Chalamet", "Zendaya"), 9.1, 148);
    static Movie movie2 = new Movie("Aquaman", "Drama", 2018, Arrays.asList("Jason Moamoa", "Amber Heard"), 8.7, 118);
    static Movie movie3 = new Movie("Avatar", "Sci-Fi", 2009, Arrays.asList("Sam Worthington, Zoe Saldana"), 8.6, 169);
    public static List<Movie> movieList = Arrays.asList(movie1, movie2, movie3); //Movie class movieList

    public Movie(String title, String genre, int releaseYear, List<String> actors, double rating, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.actors = actors;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(){
    }

    public void watchMovieFunction(Scanner scanner, List<Movie> movieList, User currentUser) {
        System.out.println("Now available movies:");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1) + ". " + movieList.get(i).getDetails());
        }

        System.out.print("Select a movie to watch (enter the number): ");
        int movieIndex = scanner.nextInt() - 1;

        if (movieIndex >= 0 && movieIndex < movieList.size()) {
            currentUser.watchMovie(movieList.get(movieIndex));
            System.out.println("Movie finished. Press Enter to return to the previous menu.");
            scanner.nextLine();  // Wait for Enter key
            scanner.nextLine();
        } else {
            System.out.println("Invalid movie selection.");
        }
    }


    public void uploadMovies(String title, String genre, int releaseYear, String[] actors, double rating, int duration) {
        List<String> actorsList = new ArrayList<>();
        Collections.addAll(actorsList, actors);
        Movie movie = new Movie(title, genre, releaseYear, actorsList, rating, duration);
        moviesData.add(movie);
        System.out.println("Movie added: " + title);
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
        return genre.toLowerCase();
    }
    public String getTitle() {
        return title;
    }

    public List<String> getActors() {
        return actors;
    }

    public void searchMovie(String searchParam, String searchType) {
        boolean found = false;
        for (Movie movie : moviesData) {
            switch (searchType.toLowerCase()) {
                case "title":
                    if (movie.getTitle().toLowerCase().contains(searchParam)) {
                        System.out.println("Found movie: " + movie.getTitle());
                        found = true;
                    }
                    break;
                case "actor":
                    if (movie.getActors().contains(searchParam)) {
                        System.out.println("Found movie with actor: " + movie.getTitle());
                        found = true;
                    }
                    break;
                case "genre":
                    if (movie.getGenre().toLowerCase().contains(searchParam)) {
                        System.out.println("Found movie in genre: " + movie.getTitle());
                        found = true;
                    }
                    break;
                default:
                    System.out.println("Invalid search type. Please use 'title', 'actor', or 'genre'.");
                    return;
            }
        }
        if (!found) {
            System.out.println("No movie found with the given search criteria.");
        }
    }

    public void allAboutMovies(Scanner scanner){
        System.out.println("Movie-related functions:");
        System.out.println("1. Watch a Movie");
        System.out.println("2. Search Movie");
        System.out.println("3. Add a Movie");
        System.out.println("0. Back to Main Menu");
        System.out.print("Select an option: ");

        int movieChoice = scanner.nextInt();
        scanner.nextLine();
        if (movieChoice == 1) {
            watchMovieFunction(scanner, movieList, User.currentUser);
        }
        else if (movieChoice == 2) {
            System.out.println("Search for a movie by: title, actor, or genre?");
            String searchType = scanner.nextLine().toLowerCase();
            System.out.println("Enter the " + searchType + " to search for:");
            String searchTerm = scanner.nextLine();

            searchMovie(searchTerm, searchType);
        }
        else if (movieChoice == 3) {
            System.out.println("Add movie to System");
            System.out.println("Enter movie title:");
            String movieTitle = scanner.nextLine();
            System.out.println("Enter movie genre:");
            String movieGenre = scanner.nextLine();
            System.out.println("Enter movie year:");
            int movieYear = scanner.nextInt();
            System.out.println("Enter movie actor:");
            String[] actors = scanner.nextLine().split(",");
            System.out.println("Enter movie rating:");
            double movieRating = scanner.nextDouble();
            System.out.println("Enter movie duration:");
            int movieDuration = scanner.nextInt();

            uploadMovies(movieTitle, movieGenre, movieYear, actors, movieRating, movieDuration);
        }
        else if (movieChoice == 0) {
            return;
        }
    }

}