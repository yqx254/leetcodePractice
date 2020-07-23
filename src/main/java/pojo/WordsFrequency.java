package pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fstar
 */
public class WordsFrequency {
    Map<String, Integer> storage = new HashMap<>();
    public WordsFrequency(String[] book) {
        for(String word : book){
            storage.merge(word, 1, Integer::sum);
        }
    }

    public int get(String word) {
        Integer cnt = storage.get(word);
        return cnt == null ? 0 : cnt;
    }
}
