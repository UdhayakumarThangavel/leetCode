import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    List<String> words = new ArrayList<>();
    public WordDictionary() {}

    public void addWord(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        String[] wordArray = word.split("");
        if(words.contains(word)){
            return true;
        }
        for (int i=0;i< words.size();i++
             ) {
            String[] array = words.get(i).split("");
            if(array.length==word.length()){
                int count =0;
                for (int j=0;j< array.length;j++){
                    if(wordArray[j].equals(array[j]) || wordArray[j].equals(".")){
                        count += 1;
                    }
                }
                if(count == array.length){
                    return true;
                }
            }
        }
        return false;
    }
}