**wordExample**

Initial assumption was to assume that the solution would grab the 
first occurring word in the sentence that had the shortest character length.

Created the methods

_**getFirstSingleLongestWord(String);**_

_**getFirstSingleShortestWord(String);**_

It returns an instance of a class called **WordAndLength** which
contains the word as a String and the word length as an Integer.

Because these methods don't return all the words with the same max or min character length,
another approach was also taken.

**setWordMap(String)** splits the array and then groups words into a Map<Integer, List<String>> by length.
This is achieved concisely through using Stream and _Collectors.groupingBy(String::length)_
This is then stored in the wordmap field.

Subsequently the **getMinCharacterLengthWords**() or **getMaxCharacterLengthWords**() will
return an instance of a **WordsAndLength** class which rather than a String has a List<String> which
contains all the words related to the length. In these methods an entryset is streamed from the wordmap
using min(Map.Entry.comparingByKey()) or max(Map.Entry.comparingByKey()) in order to get the appropriate
key value matching the requirement. 

JUNIT tests have been created to prove both solutions

- focus on proving multiple words with same max or min length are returned
- first occurring max or min word can be returned.
- some basic error handling
- an empty string returns and empty string








.









