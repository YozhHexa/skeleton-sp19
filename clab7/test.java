import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
public class test {

    @Test
    public void testRandomTree(){
        // A binary tree created by inserting n randomly chosen keys into an empty tree has an expected
        // internal path length of In roughly equals 1.386n * Lgn

        BST<Integer> bst = new BST<>();
        int n = 1000000;
        Set<Integer> randomKeys = new HashSet<>();
        Random rand = new Random();
        int range = 100000000; // Much larger than n to avoid collisions

        while (randomKeys.size() < n) {
            randomKeys.add(rand.nextInt(range));
        }

        // Convert to list and insert in random order
        List<Integer> keyList = new ArrayList<>(randomKeys);
        Collections.shuffle(keyList);

        for (Integer key : keyList) {
            bst.add(key);
        }
//        for(int i = 0; i < n; i++){
//            ExperimentHelper.randomAdd(bst);
//        }
        Double internalPathLength = bst.averageDepth() * n;
        System.out.println(internalPathLength);
        System.out.println(1.386 * n * (Math.log(n) / Math.log(2)));
    }
}
