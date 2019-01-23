package sentiment;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.HashMap;
import java.util.Map;

public class SentimentAnalyzer {

    GoSentiment gs;
    Map<Integer, String> lookup;

    public interface GoSentiment extends Library {
        int ClassifySentiment(GoString str);
    }

    public SentimentAnalyzer(){
        String path = System.getProperty("user.dir") + "/src/main/bin/sentiment.so";
        gs = Native.loadLibrary(path, GoSentiment.class);
        lookup = new HashMap<>();
        lookup.put(0, "negative");
        lookup.put(1, "positive");
    }

    public int analyzeSentiment(String text){
            GoString str = new GoString(text);
            return gs.ClassifySentiment(str);
    }

    public String toSentimentWord(int value){
        if(lookup.containsKey(value)){
            return lookup.get(value);
        }
        return "null";
    }

    public static void main(String[] args) {
        System.out.println(new SentimentAnalyzer().analyzeSentiment("i love this function"));
    }
}
