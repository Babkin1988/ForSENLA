import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Sentense {
    private String sentense;
    private List<String> words;
    private int count;
    public String getText(){
        return sentense;
    }
    public List<String> getWords() throws NullPointerException {
        try {
        Collections.sort(words);
        }
        catch (NullPointerException ex){
            throw new NullPointerException("List of words is empty");
        }
        return words;
    }
    public int getCount(){
        return count;
    }

    private String[] firstToUpperCase(String[] arr) throws NullPointerException, IndexOutOfBoundsException {
        if (arr == null) throw new NullPointerException("Array of strings is empty.");
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == null || arr[i] == "") continue;
            StringBuilder str = new StringBuilder(arr[i]);
            try {
                if (Character.isLowerCase(str.charAt(0))) {
                    str.setCharAt(0, (char) (arr[i].codePointAt(0) - 32));
                }
            }
            catch(IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException("Internal error! firstToUpperCase method bug!");
            }
            newArr[i] = str.toString();
        }
        return newArr;
    }
    public Sentense(String text) throws NullPointerException {
        if (text == null) throw new NullPointerException("String is empty");
        this.sentense = text.replaceAll("[^a-zA-Z\\`]", " ").strip();
        this.sentense = sentense.replaceAll("[\\s]{2,}", " ");
        if (sentense == "") {
            this.words = null;
            this.count = 0;
            return;
        }
        try {
            this.words = Arrays.asList(firstToUpperCase(this.sentense.split(" ")));
            this.count = words.size();
        }
        catch (NullPointerException ex) {
            throw ex;
        }
        catch (IndexOutOfBoundsException ex) {
            throw ex;
        }
    }
}
