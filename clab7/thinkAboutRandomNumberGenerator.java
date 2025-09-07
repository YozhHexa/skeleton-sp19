import edu.princeton.cs.algs4.StdRandom;

public class thinkAboutRandomNumberGenerator {

    public static void main(String[] args){
        int m = 50;
        int n = 100;
        //code 1
        int[] list1 = new int[m];
        for(int i = 1; i <= m; i++){
            int randomInt = StdRandom.uniform(n);
            while (contains(list1, randomInt)){
                randomInt = StdRandom.uniform(n);
            }
            list1[i - 1] = randomInt;
        }
        //code 2
        int[] list2 = StdRandom.permutation(n, m);

    }

    private static boolean contains(int[] list, int k){
        for(int i = 0; i < list.length; i++){
            if(list[i] == k){
                return true;
            }
            if(i == list.length - 1){
                return false;
            }
        }
        return false;
    }
}
