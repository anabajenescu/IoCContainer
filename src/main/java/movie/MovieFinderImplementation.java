package main.java.movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class MovieFinderImplementation implements MovieFinder {

    private static final String SEPARATOR = "; ";

    private final String fileName;

    public MovieFinderImplementation(String fileName) {
        this.fileName = requireNonNull(fileName);
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> allMovies = new ArrayList<>();
        FileReader input;

        try {
            input = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(input);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] array = line.split(SEPARATOR);

                Movie movie = new Movie();
                movie.setName(array[0]);
                movie.setDirectedBy(array[1]);

                allMovies.add(movie);
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return allMovies;
    }
}
