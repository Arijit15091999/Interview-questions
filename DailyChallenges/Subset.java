import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,2,2,2,2};
        Subset s = new Subset();
        System.out.println(s.getTheUniqueSubsets(arr));
    }
    public List<List<Integer>> getTheSubsets(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        helper(0, arr, new ArrayList<>(), res);
        return res;
    }
    private void helper(int index, int[] arr, List<Integer> ds, List<List<Integer>> res) {
        if (index == arr.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        // not take
        helper(index + 1, arr, ds, res);
        // take
        ds.add(arr[index]);
        helper(index + 1, arr, ds, res);
        ds.remove(ds.size() - 1);
    }
    public List<List<Integer>> getTheUniqueSubsets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper2(0, arr, new ArrayList<>(), res);
        return res;
    }
    private void helper2(int index, int[] arr, List<Integer> ds, List<List<Integer>> res) {
        if(index == arr.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        // take
        ds.add(arr[index]);
        helper2(index + 1, arr, ds, res);
        ds.remove(ds.size() - 1);
        // not take and skip if duplicates are there
        while(index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        helper2(index + 1, arr, ds, res);
    }
}
