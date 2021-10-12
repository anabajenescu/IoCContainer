package main.java.spellcheck;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class TextEditor {

    private final SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = requireNonNull(spellChecker);
    }

    public String getCorrectFormOfWord (String word) {
        List<Word> words = spellChecker.spellCheckAll();
        Optional<String> correctWord = words.stream().filter(w -> w.getFaultyWord().equals(word)).map(Word::getCorrectWord).findFirst();

        if (correctWord.isPresent()) {
            System.out.println("The word \"" + word + "\" is misspelled! Its correct spelling is: "
                    + correctWord.get());

            return correctWord.get();
        } else {
            System.out.println("The word: " + word + " is correct!");

            return word;
        }
    }
}
