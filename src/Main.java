import movie.Movie;
import system.MovieRecommendationSystem;
import user.Billing;
import user.Preferences;
import user.Profile;
import user.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Dune", "Action", 2021, new String[]{"Timothée Hal Chalamet", "Zendaya"}, 9.1, 148);
        Movie movie2 = new Movie("Aquaman", "Drama", 2018, new String[]{"Jason Moamoa", "Amber Heard"}, 8.7, 118);
        Movie movie3 = new Movie("Avatar", "Sci-Fi", 2009, new String[]{" Sam Worthington, Zoe Saldana"}, 8.6, 169);
        List<Movie> movieList = Arrays.asList(movie1, movie2, movie3);

        Profile profileUser1 = new Profile("Fiona", "1999-04-17", "TW");
        Profile profileUser2 = new Profile("East Wang", "1998-12-02", "US");

        Billing billingUser1 = new Billing("Credit Card", 150.00);
        Billing billingUser2 = new Billing("Apple Pay", 200.00);

        Preferences preferencesUser1 = new Preferences(new String[]{"Sci-Fi", "Drama"}, 150, 8.0);
        Preferences preferencesUser2 = new Preferences(new String[]{"Action", "Comedy"}, 120, 9.0);

        User user1 = new User("fiona123", "fiona@google.com", profileUser1, billingUser1, preferencesUser1);
        User user2 = new User("eastwang1202", "eastwang1202@google.com", profileUser2, billingUser2, preferencesUser2);

        MovieRecommendationSystem movieSystem = new MovieRecommendationSystem();

        Scanner scanner = new Scanner(System.in);
        User currentUser;
        currentUser = user1;


        while (true) {
            System.out.println("\n===== Movie System Main Menu =====");
            System.out.println("1. Watch Movie");
            System.out.println("2. Recommend Movie");
            System.out.println("3. Profile User");
            System.out.println("4. Billing");
            System.out.println("5. Preferences");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Goodbye! We hope to see you soon!");
                return;
            } else if (choice == 1) {
                System.out.println("1. Watch a Movie");
                System.out.println("2. Search Movie");
                System.out.println("0. Back to Main Menu");
                System.out.print("Select an option: ");

                int movieChoice = scanner.nextInt();
                scanner.nextLine();
                if (movieChoice == 1) {
                    System.out.println("Now available movies:");
                    for (int i = 0; i < movieList.size(); i++) {
                        System.out.println((i + 1) + ". " + movieList.get(i).getDetails());
                    }
                    System.out.print("Select a movie to watch (enter the number): ");
                    int movieIndex = scanner.nextInt() - 1;
                    if (movieIndex >= 0 && movieIndex < movieList.size()) {
                        currentUser.watchMovie(movieList.get(movieIndex));
                        System.out.println("Movie finished. Press Enter to return to the previous menu.");
                        scanner.nextLine();
                    } else {
                        System.out.println("Invalid movie selection.");
                    }
                }
                else if (movieChoice == 2) {
                    System.out.println("Type the movie title to search for: ");
                    String movieTitle = scanner.nextLine();

                    boolean found = false;
                    for (Movie movie : movieList) {
                        if (movie.getTitle().toLowerCase().contains(movieTitle.toLowerCase())) {
                            System.out.println("Found: " + movie.getDetails());
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No movies found with the title: " + movieTitle);
                    }
                } else if (movieChoice == 0) {
                    return;
                }
            } else if (choice == 2) {
                System.out.println("1. Recommend a Movie to Another User");
                System.out.println("2. View Recommended Movies from Another User");
                System.out.println("Select an option: ");

                int recommendChoice = scanner.nextInt();
                scanner.nextLine();
                if (recommendChoice == 1) {
                    System.out.print("Enter the username to recommend a movie to: ");
                    String username = scanner.nextLine();
                    User receiver = username.equals("eastwang1202") ? user2 : user1;
                    System.out.println("Select a movie to recommend:");
                    for (int i = 0; i < movieList.size(); i++) {
                        System.out.println((i + 1) + ". " + movieList.get(i).getDetails());
                    }
                    System.out.println("Enter your movie choice: ");
                    int movieChoice = scanner.nextInt() - 1;
                    if (movieChoice >= 0 && movieChoice < movieList.size()) {
                        movieSystem.recommendMovie(currentUser, receiver, movieList.get(movieChoice));
                        System.out.println("Your movie recommended successfully.");
                    } else {
                        System.out.println("Invalid movie selection.");
                    }
                } else if (recommendChoice == 2) {
                    System.out.println("Movies recommended to you:");
                    List<Movie> recommendations = movieSystem.showRecommendationsForUser(currentUser);
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations available.");
                    } else {
                        recommendations.forEach(movie -> System.out.println(movie.getDetails()));
                    }
                }
            } else if (choice == 3) {
                System.out.println("1. Update Profile");
                System.out.println("2. See my Profile");
                System.out.print("Select an option: ");
                int profileChoice = scanner.nextInt();
                scanner.nextLine();

                if (profileChoice == 1) {
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new date of birth (YYYY-MM-DD):");
                    String newDOB = scanner.nextLine();
                    System.out.println("Enter new country:");
                    String newCountry = scanner.nextLine();

                    user1.getProfile().updateProfile(newName, newDOB, newCountry);
                    System.out.println("Profile updated successfully.");
                }
                else if (profileChoice == 2) {
                    System.out.println(user1.getProfile().getProfileDetails());
                }
            } else if (choice == 4) {
                System.out.println("1. Add Funds to Account");
                System.out.println("2. Charge for Premium Movie");
                System.out.println("0. Back to Main Menu");
                System.out.println("Select an option: ");
                int billingChoice = scanner.nextInt();
                scanner.nextLine();

                if (billingChoice == 1) {
                    System.out.print("Enter the total amount to add:");
                    double amount = scanner.nextDouble();
                    user1.getBilling().addFunds(amount);
                    System.out.println("Funds added. Current balance is $" + user1.getBilling().getBalance());
                }
                else if (billingChoice == 2) {
                    System.out.print("Enter the amount to charge:");
                    double amount = scanner.nextDouble();
                    user1.getBilling().charge(amount);
                    System.out.println("Charged. Current balance is $" + user1.getBilling().getBalance());
                }
                else if (billingChoice == 0) {
                    return;
                }
            } else if (choice == 5) {
                System.out.println("1. Update Preferences");
                System.out.println("2. Get Movie Recommendations Based on Preferences");
                System.out.println("0. Back to Main Menu");
                System.out.print("Select an option: ");
                int preferencesChoice = scanner.nextInt();
                scanner.nextLine();

                if (preferencesChoice == 1) {
                    System.out.print("Enter new favorite genres ex: Sci-Fi, Drama, Action: ");
                    String[] genres = scanner.nextLine().split(",");
                    System.out.print("Enter preferred maximum duration: ");
                    int maxDuration = scanner.nextInt();
                    System.out.print("Enter minimum rating: ");
                    double minRating = scanner.nextDouble();
                    user1.getPreferences().updatePreferences(genres, maxDuration, minRating);
                    System.out.println("Preferences updated.");
                }
                else if (preferencesChoice == 2) {
                    System.out.println("Movies recommended based on preferences:");
                    List<Movie> preferredMovies = user1.getPreferences().getRecommendedMovies(movieList);
                    if (preferredMovies.isEmpty()) {
                        System.out.println("No movies match your preferences.");
                    } else {
                        preferredMovies.forEach(movie -> System.out.println(movie.getDetails()));
                    }
                }
                else if (preferencesChoice == 0) {
                    return;
                }
            } else {
                System.out.println("Invalid option.");
            }
        }

    }
}
