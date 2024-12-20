import movie.Movie;
import movie.MovieInterface;
import system.MovieRecommendationSystem;
import system.RecommendSystemInterface;
import user.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MovieRecommendationSystem movieSystem = new MovieRecommendationSystem();

        Scanner scanner = new Scanner(System.in);
        MovieInterface movieFunction = new Movie();
        ProfileInterface profileFunction = new Profile();
        BillingInterface billingFunction = new Billing();
        CommunityInterface communityFunction = new Community();
        RecommendSystemInterface recommendSystemFunction = new MovieRecommendationSystem();

        while (true) {
            System.out.println("\n===== Movie System Main Menu =====");
            System.out.println("1. Watch Movie");
            System.out.println("2. Recommend Movie");
            System.out.println("3. Profile User");
            System.out.println("4. Billing");
            System.out.println("5. Preferences");
            System.out.println("6. Manage Community");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Goodbye! We hope to see you soon!");
                return;
            } else if (choice == 1) {
                movieFunction.allAboutMovies(scanner);

            } else if (choice == 2) {
                System.out.println("1. Recommend a Movie to Another User");
                System.out.println("2. View Recommended Movies");
                System.out.println("Select an option: ");

                int recommendChoice = scanner.nextInt();
                scanner.nextLine();
                if (recommendChoice == 1) {
                    recommendSystemFunction.recommendMovie(scanner);
                } else if (recommendChoice == 2) {
                    recommendSystemFunction.userRecommendList();
                }
            } else if (choice == 3) {
                profileFunction.manageProfiles(scanner);

            } else if (choice == 4) {
                billingFunction.accountsAndSecurity(scanner);
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
                    User.user1.getPreferences().updatePreferences(genres, maxDuration, minRating);
                    System.out.println("Preferences updated.");
                }
                else if (preferencesChoice == 2) {
                    System.out.println("Movies recommended based on preferences:");
                    List<Movie> preferredMovies = User.user1.getPreferences().getRecommendedMovies(Movie.movieList);
                    if (preferredMovies.isEmpty()) {
                        System.out.println("No movies match your preferences.");
                    } else {
                        preferredMovies.forEach(movie -> System.out.println(movie.getDetails()));
                    }
                }
                else if (preferencesChoice == 0) {
                    return;
                }
            }
            else if (choice == 6) {
                communityFunction.manageCommunity(scanner);
            }
            else {
                System.out.println("Invalid option.");
            }
        }

    }
}
