package test.java.spellcheck;

import main.java.spellcheck.RomanianSpellChecker;
import main.java.spellcheck.Word;
import org.junit.Test;

import java.util.List;

public class RomanianSpellCheckerTest {

    private static final String FILE_NAME = "C:\\Users\\AnaBajanescu\\Desktop\\master_UPT\\labs&courses\\sem1\\CBSE\\IoCContainer\\src\\main\\java\\spellCheck\\romanianSpellChecks.txt";

    @Test
    public void testFindAll() {
        RomanianSpellChecker spellChecker = new RomanianSpellChecker(FILE_NAME);
        List<Word> words = spellChecker.spellCheckAll();
        words.forEach(System.out::println);
    }
}
