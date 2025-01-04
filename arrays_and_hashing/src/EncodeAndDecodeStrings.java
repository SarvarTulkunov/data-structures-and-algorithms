import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// Neetcode

/**
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 */
public class EncodeAndDecodeStrings {

    private String key = UUID.randomUUID().toString();

    public String encode(List<String> strs) {

        StringBuilder encodedStr = new StringBuilder();

        for (String str : strs) {
            encodedStr.append(key).append(str);
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == key.length()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>(Arrays.asList(str.split(key)));
        result.remove(0);
        return result;
    }


    public static void main(String[] args) {
        EncodeAndDecodeStrings encoder = new EncodeAndDecodeStrings();

        String str = encoder.encode(Arrays.asList("neet", "code", "love", "you"));

        System.out.println("Encoded str: " + str);

        System.out.println("Decoded str: " + encoder.decode(str).toString());

    }
}
