package user;

import movie.Movie;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Movie> watchedMovies = new ArrayList<>();
    private List<Movie> recommendedMovies = new ArrayList<>();
    private static Profile profile;
    private static Billing billing;
    private String role;
    private List<User> listOfFriends = new ArrayList<>();
    private static Preferences preferences;
    public static User user1 = new User("fiona123", "fiona@google.com", profile.profileUser1, billing.billingUser1, preferences.preferencesUser1, "Viewer", new ArrayList<>());
    public static User user2 = new User("eastwang1202", "eastwang1202@google.com", profile.profileUser2, billing.billingUser2, preferences.preferencesUser2, "actor",new ArrayList<>());
    public static User currentUser = user1;

    public User(String username, String email, Profile profile, Billing billing, Preferences preferences, String role, List<User> listOfFriends) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.listOfFriends = new ArrayList<>();
        this.profile = profile;
        this.billing = billing;
        this.preferences = preferences;
    }

    public void watchMovie(Movie movie) {
        watchedMovies.add(movie);
        System.out.println("Playing the movie: " + movie.getTitle());
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

    public void addFriend(User user) {
        listOfFriends.add(user);
        System.out.println(user.username + " added to friends list.");
    }

    public void removeFriend(User user) {
        if (listOfFriends.remove(user)) {
            System.out.println(user.username + " removed from friends list.");
        } else {
            System.out.println(user.username + " is not in the friends list.");
        }
    }

    public void addFriends(List<User> user) {
        listOfFriends.addAll(user);
        System.out.println("Multiple friends added.");
    }

    public void hasFriends(User user) {
        if (!listOfFriends.isEmpty()) {
            System.out.println(user.username + " has friends.");
        } else {
            System.out.println(user.username + " has no friends.");
        }
    }

    public void hasARole(User user) {
        System.out.println(user.username + " has the role: " + role);
    }

    public User getUserName() {
        return currentUser.username.equals(username) ? user1 : user2;
    }

}


