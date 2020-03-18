import java.util.*;
import java.util.stream.Collectors;

public class WordSort {

    Map<Integer, List<String>> wordmap = null;

    public  void setWordmap(String sentence){
        try {
            this.wordmap = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(String::length));
        } catch (Exception e) {
            throw new IllegalArgumentException("sentence must be valid",e);
        }
    }

    public WordsAndLength getMaxCharacterLengthWords() {
        Integer max = wordmap.entrySet().stream().max(Map.Entry.comparingByKey()).get().getKey();
        return new WordsAndLength(wordmap.get(max),max);
    }

    public WordsAndLength getMinCharacterLengthWords() {
        Integer min = wordmap.entrySet().stream().min(Map.Entry.comparingByKey()).get().getKey();
        return new WordsAndLength(wordmap.get(min),min);
    }

    public  WordAndLength getFirstSingleLongestWord (String sentence){

        String longestWord = null;

        try {
            longestWord = Arrays.stream(sentence.split(" ")).
                    max(Comparator.comparingInt(String::length)).
                    orElse(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Sentence should be valid " + e.getMessage(),e);
        }

        return new WordAndLength(longestWord,longestWord.length()) ;
    }


    public  WordAndLength getFirstSingleShortestWord(String sentence){

        String shortestWord = null;
        try {
            shortestWord = Arrays.stream(sentence.split(" ")).
                    min(Comparator.comparingInt(String::length)).
                    orElse(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Sentence should be valid " + e.getMessage(),e);
        }

        return new WordAndLength(shortestWord,shortestWord.length()) ;
    }


    /*
    for a single word and its length
    */
    public  class WordAndLength{
        String word;
        Integer length;
        WordAndLength(String word,Integer length){
            this.word = word;
            this.length = length;
        }
    }

    /* for a list of words with the same length */

    public class WordsAndLength{
        List<String> words;
        Integer length;
        WordsAndLength(List<String> words,Integer length){
            this.words = words;
            this.length = length;
        }
    }


};










