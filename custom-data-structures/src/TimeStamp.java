import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeStamp {

    HashMap<String, List<String>> valuesDict;
    HashMap<String, List<Integer>> timestampDict;

    public TimeStamp() {
        valuesDict = new HashMap<>();
        timestampDict = new HashMap<>();
    }

    // Set TimeStamp data variables
    public void setValue(String key, String value, int timestamp) {
        if (valuesDict.containsKey(key)) {
            if (value != valuesDict.get(key).get(valuesDict.get(key).size() - 1)) {
                valuesDict.get(key).add(value);
                timestampDict.get(key).add(timestamp);
            }
        } else {
            valuesDict.put(key, new ArrayList<>());
            valuesDict.get(key).add(value);
            timestampDict.put(key, new ArrayList<>());
            timestampDict.get(key).add(timestamp);
        }
    }

    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {
        int index = 0;
        if (!valuesDict.containsKey(key)) {
            return "";
        } else {
            index = searchIndex(timestampDict.get(key).size(), key, timeStamp);
        }

        if (index > -1) {
            return valuesDict.get(key).get(index);
        }
        return "";
    }

    // Find the index of right most occurrence of the given timestamp using binary search
    public int searchIndex(int n, String key, int timeStamp) {

        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (!(timestampDict.get(key).get(mid) > timeStamp)) left = mid + 1;
            else right = mid;
        }
        return left - 1;
    }

}
