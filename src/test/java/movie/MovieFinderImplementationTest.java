package test.java.movie;

import main.java.movie.Movie;
import main.java.movie.MovieFinderImplementation;
import org.junit.Test;

import java.util.List;

public class MovieFinderImplementationTest {

    private static final String FILE_NAME = "C:\\Users\\AnaBajanescu\\Desktop\\master_UPT\\labs&courses\\sem1\\CBSE\\IoCContainer\\src\\main\\java\\movie\\movies.txt";

    @Test
    public void testFindAll() {
        MovieFinderImplementation movieFinderImplementation = new MovieFinderImplementation(FILE_NAME);
        List<Movie> movies = movieFinderImplementation.findAll();
        movies.forEach(System.out::println);
    }
}
