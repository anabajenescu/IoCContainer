package main.java.movie;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class MovieLister {

    private final MovieFinder movieFinder;

    public MovieLister(MovieFinder movieFinder) {
        this.movieFinder = requireNonNull(movieFinder);
    }

    public Movie[] getMoviesDirectedBy(String director) {
        List<Movie> movies = movieFinder.findAll();
        movies.removeIf(movie -> !movie.getDirectedBy().equals(director));

        System.out.println("Movies directed by " + director + " are:");
        System.out.println(movies);

        return movies.toArray(new Movie[0]);
    }
}
