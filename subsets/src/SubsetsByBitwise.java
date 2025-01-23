import java.util.ArrayList;
import java.util.List;

public class SubsetsByBitwise {

    public static List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> subsets = new ArrayList<>();

        String format = "%" + n + "s";
        for (int i = 0; i < Math.pow(2, n); i++) {
            String intToBin = String.format(format, Integer.toBinaryString(i)).replace(' ', '0');
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (intToBin.charAt(j) == '1') {
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }

}
