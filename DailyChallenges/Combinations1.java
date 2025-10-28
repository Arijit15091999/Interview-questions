import java.util.*;

public class Combinations1{
    public static void main(String[] args) {
        System.out.println(combinations(4, 3));
    }
    public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        helper(1, n, k, new ArrayList(), res);
        return res;
    }
    private static void helper(
            int index,
            int n,
            int k,
            ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> res) {
        if(ds.size() == k) {
            res.add(new ArrayList(ds));
            return;
        }
        if(index > n) {
            return;
        }
        int remainingElements = n - index + 1;
        if(ds.size() + remainingElements < k) {
            return;
        }
        // take
        ds.add(index);
        helper(index + 1, n , k, ds, res);
        ds.remove(ds.size() - 1);
        // not take
        helper(index + 1, n , k, ds, res);
    }
}
