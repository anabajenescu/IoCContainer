package main.java.spellcheck;

import main.java.movie.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class RomanianSpellChecker implements SpellChecker{

    private static final String SEPARATOR = " = ";

    private final String fileName;

    public RomanianSpellChecker(String fileName) {
        this.fileName = requireNonNull(fileName);
    }

    @Override
    public List<Word> spellCheckAll() {
        List<Word> allWords = new ArrayList<>();
        FileReader input;

        try {
            input = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(input);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] array = line.split(SEPARATOR);

                Word word = new Word();
                word.setFaultyWord(array[0]);
                word.setCorrectWord(array[1]);

                allWords.add(word);
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return allWords;
    }
}
