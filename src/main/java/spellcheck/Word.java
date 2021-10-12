package main.java.spellcheck;

public class Word {

    private String faultyWord;
    private String correctWord;

    public String getFaultyWord() {
        return faultyWord;
    }

    public void setFaultyWord(String faultyWord) {
        this.faultyWord = faultyWord;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }

    @Override
    public String toString() {
        return "Word [faultyWord=" + faultyWord + ", correctWord=" + correctWord + "]";
    }
}
