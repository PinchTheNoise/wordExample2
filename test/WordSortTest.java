import org.junit.Assert;
import org.junit.Test;

public class WordSortTest {

    /**
     * JUNIT tests for WordSort methods for obtaining max and min length words in a sentence.
     */

    @Test
    public void test_The_Maximum_Length_Word() {
        WordSort w = new WordSort();
        w.setWordmap("The Quick Brown Fox Jumped over the lazy dog's back");
        Assert.assertEquals("Jumped is max length word","Jumped",w.getMaxCharacterLengthWords().words.get(0));
    }

    @Test
    public void test_Where_There_Is_Only_One_Maximum_Length_Word() {
        WordSort w = new WordSort();
        w.setWordmap("The Quick Brown Fox Jumped over the lazy dog's back");
        Assert.assertEquals("1 max length word",1,w.getMaxCharacterLengthWords().words.size());
    }

    @Test
    public void test_Where_Multiple_Words_Have_Minimum_Length() {
        WordSort w = new WordSort();
        w.setWordmap("The Quick Brown Fox Jumped the lazy dog's back whilst the cat found his mat once again");
        Assert.assertEquals("7 instances of shortest length words",7,w.getMinCharacterLengthWords().words.size());
    }

    @Test
    public void test_That_The_Minimum_Count_Word_Has_Three_Chars() {
        WordSort w = new WordSort();
        w.setWordmap("The Quick Brown Fox Jumped the lazy dog's back whilst the cat found his mat once again");
        Assert.assertTrue("minimum length words have 3 chars",w.getMinCharacterLengthWords().length == 3);
    }

    @Test
    public void test_That_Fox_And_Cat_Are_Both_Minimum_Count_Words() {
        WordSort w = new WordSort();
        w.setWordmap("The Quick Brown Fox Jumped the lazy dog's back whilst the cat found his mat once again");
        Assert.assertTrue("Fox is a minimum length word",w.getMinCharacterLengthWords().words.contains("Fox"));
        Assert.assertTrue("cat is a minimum length word",w.getMinCharacterLengthWords().words.contains("cat"));
    }

    @Test
    public void test_getFirstSingleLongestWord() {
        WordSort w = new WordSort();
        WordSort.WordAndLength longestWord = w.getFirstSingleLongestWord("There is a stupendously longish word in this sentence. Expectations are high.");
        Assert.assertEquals("'stupendously' is first instance of longest word","stupendously", longestWord.word);
        Assert.assertTrue("12 chars is length of longest word",longestWord.length==12);
    }

    @Test
    public void test_getFirstSingleShortestWord() {
        WordSort w = new WordSort();
        WordSort.WordAndLength shortestWord = w.getFirstSingleShortestWord("There is a stupendously longish word in this sentence. Expectations are high.");
        Assert.assertEquals("'a' is first instance of longest word","a", shortestWord.word);
        Assert.assertTrue("shortest word has 1 char",shortestWord.length==1);
    }

    @Test
    public void test_getFirstSingleShortestWord_When_One_Word_Only() {
        WordSort w = new WordSort();
        WordSort.WordAndLength shortestWord = w.getFirstSingleShortestWord("There");
        Assert.assertEquals("'There' is first instance of longest word","There", shortestWord.word);
        Assert.assertTrue("shortest word has 1 char",shortestWord.length==5);
    }

    @Test
    public void test_getFirstSingleShortestWord_With_Empty_String_Returns_Empty_String() {
        WordSort w = new WordSort();
        WordSort.WordAndLength shortestWord = w.getFirstSingleShortestWord("");
        Assert.assertEquals("empty string returned","", shortestWord.word);
        Assert.assertTrue("empty sentence returns an empty string",shortestWord.length==0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_Null_Sentence() {
        WordSort w = new WordSort();
        w.setWordmap(null);
    }

    @Test(expected =IllegalArgumentException.class)
    public void test_null_getFirstSingleShortestWord() {
        WordSort w = new WordSort();
        WordSort.WordAndLength shortestWord = w.getFirstSingleShortestWord(null);
        Assert.assertEquals("'a' is first instance of longest word","a", shortestWord.word);
        Assert.assertTrue("shortest word has 1 char",shortestWord.length==1);
    }

    @Test
    public void test_Empty_String_Word_Map() {
        WordSort w = new WordSort();
        w.setWordmap("");
        Assert.assertEquals("Empty string returned","",w.getMaxCharacterLengthWords().words.get(0));
        Assert.assertEquals("Empty string returned","",w.getMinCharacterLengthWords().words.get(0));
        Assert.assertTrue("Empty string returned",w.getMinCharacterLengthWords().length == 0);
        Assert.assertTrue("Empty string returned",w.getMaxCharacterLengthWords().length == 0);
    }

}