## Clab7 giving up
About randomly add item in BST, i am curious about how to do that.
It seems that random is different from random, and it has something with math.
  
    public static void randomAdd(BST<Integer> tree){//add a random Integer number from 0-100000(exclusive) to bst
        int range = 100000;
        Random rand = new Random();
        int randomNumber = rand.nextInt(range);
        while (tree.contains(randomNumber)){
            randomNumber = rand.nextInt(range);
        }
        tree.add(randomNumber);
    }

I wrote this to randomly add.
I saw IPL(Internal Path Length) of random BST is expected to be 1.83n * lgn(base at 2) from a paper(https://scispace.com/pdf/an-empirical-study-of-insertion-and-deletion-in-binary-ve4jpact0q.pdf).
But when i make comparsion, i found at most 16% difference, so first question will be i randomly add right?.

Besides, when randomly adding and deleting item, there are three paraments that puzzle me.
First, the start size of BST. Second, the range of item key that will be added into BST. Third, the times of random add and delete.
The third number has influence on last plot, when it is 10000, it will decrease, and when it is 100000, it will increase, that is the question asked.There are nothing suggestion about the three paraments selection,
that is puzzling.
