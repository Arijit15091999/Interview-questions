import java.sql.Array;
import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2};
        Permutation p = new Permutation();
        System.out.println(p.getAllUniquePermutations(arr));
    }
    public List<List<Integer>> getAllPermutation(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        boolean[] visited = new boolean[arr.length];
        helper(arr, visited, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] arr, boolean[] visited, List<Integer> ds, List<List<Integer>> res) {
        if(ds.size() == arr.length) {
            res.add(new ArrayList(ds));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ds.add(arr[i]);
                helper(arr, visited, ds, res);
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> getAllUniquePermutations(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        helper2(arr, visited, new ArrayList<>(), res);
        return res;
    }

    private void helper2(int[] arr, boolean[] visited, List<Integer> ds, List<List<Integer>> res) {
        if(ds.size() == arr.length) {
            res.add(new ArrayList(ds));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            if(!visited[i]) {
                visited[i] = true;
                ds.add(arr[i]);
                helper2(arr, visited, ds, res);
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }
}
