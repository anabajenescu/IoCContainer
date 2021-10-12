package test.java.container;

import main.java.container.HomemadeContainer;
import org.junit.Test;

public class HomemadeContainerTest {

    private static final String MOVIE_CONFIG_FILE = "C:\\Users\\AnaBajanescu\\Desktop\\master_UPT\\labs&courses\\sem1\\CBSE\\IoCContainer\\src\\main\\java\\movie\\config.txt";
    private static final String SPELL_CHECKER_CONFIG_FILE = "C:\\Users\\AnaBajanescu\\Desktop\\master_UPT\\labs&courses\\sem1\\CBSE\\IoCContainer\\src\\main\\java\\spellCheck\\config.txt";

    @Test
    public void testMovieFinder() {
        final HomemadeContainer homemadeContainer = new HomemadeContainer(MOVIE_CONFIG_FILE);
        // Shows the movies directed by Peter Jackson
        homemadeContainer.invoke();
    }

    @Test
    public void testSpellChecker() {
        final HomemadeContainer homemadeContainer = new HomemadeContainer(SPELL_CHECKER_CONFIG_FILE);
        // Shows the correct spelling of word 'monstra'
        homemadeContainer.invoke();
    }
}
