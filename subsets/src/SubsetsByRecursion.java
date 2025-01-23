import java.util.ArrayList;
import java.util.List;

public class SubsetsByRecursion {

    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        rec(arr, 0, subset, subsets);
        return subsets;
    }

    public void rec(int[] arr, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i == arr.length) {
            subsets.add(subset);
        } else {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(arr[i]);
            rec(arr, i + 1, newSubset, subsets);
            rec(arr, i + 1, subset, subsets);
        }
    }
}
