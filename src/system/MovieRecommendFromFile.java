package system;


import movie.Movie;

import java.util.*;
import java.io.*;

public class MovieRecommendFromFile {
    public static void main(String[] args) {
        List<String> tweetsFromFile = readTweetsFromFile("src/system/movie-tweets.txt");
        List<String> movies = new ArrayList<>(List.of("Barbie Movie", "Oppenheimer", "Avatar Way Of Water", "Spider Man", "Black Panther",
                "Top Gun: Maverick", "Dune", "The Batman", "Jurassic World: Dominion", "No Time to Die"));

        List<String> moviesList = processMovieName(movies);
        Hashtable<String, Integer> movieFreq = countHashtagMovie(tweetsFromFile, moviesList);
        List<String> topMovies = getTop3Movies(movieFreq);
        Map<String, String> originalNames = getOriginalNames(movies);

        System.out.println("Top 3 movies mentioned with hashtags:");
        for (int i = 0; i < topMovies.size(); i++) {
            String movie = topMovies.get(i);
            int frequency = movieFreq.get(movie);
            String originalName = originalNames.get(movie);
            System.out.println((i + 1) + ". " + originalName + " (mentioned " + frequency + " times)");
        }
    }

    public static List<Movie> getTopThreeMovies() {
        List<String> tweetsFromFile = readTweetsFromFile("src/system/movie-tweets.txt");
        List<String> movies = new ArrayList<> (List.of("Barbie Movie", "Oppenheimer", "Avatar Way Of Water", "Spider Man", "Black Panther",
                "Top Gun: Maverick", "Dune", "The Batman", "Jurassic World: Dominion", "No Time to Die"));
        List<String> moviesList = processMovieName(movies);
        Hashtable<String, Integer> movieFreq = countHashtagMovie(tweetsFromFile, moviesList);
        List<String> top3Movies = getTop3Movies(movieFreq);
        Map<String, String> originalNames = getOriginalNames(movies);

        List<Movie> topMovies = new ArrayList<>();
        for (String movieName : top3Movies) {
            String originalName = originalNames.get(movieName);
            Movie movie = new Movie(
                    originalName,
                    "Action",
                    2024,
                    new ArrayList<>(),
                    5.0,
                    120
            );
            topMovies.add(movie);
        }

        return topMovies;
    }

    private static Map<String, String> getOriginalNames(List<String> movies) {
        Map<String, String> originalNames = new HashMap<>();
        for (String movie : movies) {
            originalNames.put(movie.replace(" ", "").toLowerCase(), movie);
        }
        return originalNames;
    }

    private static List<String> processMovieName(List<String> movies) {
        List<String> moviesList = new ArrayList<>();
        for (String movie : movies) {
            moviesList.add(movie.replace(" ", "").toLowerCase());
        }
        return moviesList;
    }

    public static List<String> readTweetsFromFile(String filePath) {
        List<String> tweets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tweets.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tweets;
    }

    public static Hashtable<String, Integer> countHashtagMovie(List<String> tweets, List<String> movieList) {
        Hashtable<String, Integer> movieFeq = new Hashtable<>();
        for (String tweet : tweets) {
            String[] words = tweet.split(" ");
            for (String word : words) {
                if (word.contains("#")) {
                    String movieName = word.substring(1).toLowerCase();
                    if (movieList.contains(movieName)) {
                        movieFeq.put(movieName, movieFeq.getOrDefault(movieName, 0) + 1);
                    } else {
                        movieFeq.put(movieName, 1);
                    }
                }
            }
        }
        return movieFeq;
    }

    public static List<String> getTop3Movies(Hashtable<String, Integer> movieFeq) {
        List<String> sortedList = new ArrayList<>(movieFeq.keySet());

        Collections.sort(sortedList, (movie1, movie2) -> {
            return movieFeq.get(movie2).compareTo(movieFeq.get(movie1));
        });

        return sortedList.subList(0, Math.min(3, sortedList.size()));
    }
}
