import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

/**
 * Created by hug.
 */

public class ExperimentHelper{

    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N) {
        if(N < 1){
            throw new RuntimeException("N must be bigger than 0");
        }

        if(N == 1){
            return 0;
        }

        return optimalIPL(N - 1) + (int)(Math.log(N) / Math.log(2));
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {

        return (double)optimalIPL(N) / (double)N;
    }

    public static void randomDeleteAndAdd(BST<Integer> tree){
        int range = 100000;

        Random rand = new Random();

        tree.deleteTakingSuccessor(tree.getRandomKey());

        int randomNumber = rand.nextInt(range);
        while (tree.contains(randomNumber)){
            randomNumber = rand.nextInt(range);
        }
        tree.add(randomNumber);

    }

    public static void randomDeleteAndAdd2(BST<Integer> tree){
        int range = 100000;

        Random rand = new Random();

        tree.deleteTakingRandom(tree.getRandomKey());

        int randomNumber = rand.nextInt(range);
        while (tree.contains(randomNumber)){
            randomNumber = rand.nextInt(range);
        }
        tree.add(randomNumber);

    }

    public static void randomAdd(BST<Integer> tree){//add a random Integer number from 0-100000(exclusive) to bst
        int range = 100000;
        Random rand = new Random();

        int randomNumber = rand.nextInt(range);
        while (tree.contains(randomNumber)){
            randomNumber = rand.nextInt(range);
        }
        tree.add(randomNumber);
//        Set<Integer> randomKeys = new HashSet<>();
//        Random rand = new Random();
//        int range = 1000000; // Much larger than n to avoid collisions
//
//        while (randomKeys.size() < n) {
//            randomKeys.add(rand.nextInt(range));
//        }
//
//        // Convert to list and insert in random order
//        List<Integer> keyList = new ArrayList<>(randomKeys);
//        Collections.shuffle(keyList);
//
//        for (Integer key : keyList) {
//            tree.add(key);
//        }
    }





}
