import java.util.Arrays;

public class LangLst {
    private String language;

    private String[] words;


    public String getLanguage() {
        return language;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "LangLst{" +
                "language='" + language + '\'' +
                ", words=" + Arrays.toString(words) +
                '}';
    }
}