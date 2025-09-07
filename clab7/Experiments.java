import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.*;

/**
 * Created by hug.
 */
public class Experiments {
    public static void experiment1() {
        Random r = new Random();
        List<Integer> itemNumbers = new ArrayList<>();
        List<Double> averageDepthRandomTree = new ArrayList<>();
        List<Double> averageDepthOptimalTree = new ArrayList<>();
        BST<Integer> randomTree = new BST<>();

        List<Integer> itemsRandom = new ArrayList<>(5000);
        for(int i = 0; i < 5000; i++){
            itemsRandom.add(i);
        }
        Collections.shuffle(itemsRandom);

        Iterator<Integer> iter = itemsRandom.iterator();
        for(int i = 0; i < 5000; i++){
            int randomNode = iter.next();
            itemNumbers.add(i + 1);
            randomTree.add(randomNode);
            Double aveDepth = randomTree.averageDepth();
            averageDepthRandomTree.add(aveDepth);
            Double optimalAverageDepth = ExperimentHelper.optimalAverageDepth(i + 1);
            averageDepthOptimalTree.add(optimalAverageDepth);
        }
        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("item numbers").yAxisTitle("average depth").build();
        chart.addSeries("average depth with random tree", itemNumbers, averageDepthRandomTree);
        chart.addSeries("average depth with optimal tree", itemNumbers, averageDepthOptimalTree);

        new SwingWrapper(chart).displayChart();

    }

    public static void experiment2() {
        int range = 10000;
        int N = 2000;
        int operationNumber = 0;

        BST tree = new BST<>();
        List<Integer> randomNumbers = new ArrayList<>();
        int[] items = StdRandom.permutation(range, N);
        for (int item : items) {
            tree.add(item);
        }


        Double startDepth = tree.averageDepth();

        List<Double> averageDepth = new ArrayList<>();
        List<Integer> numberOfOperation = new ArrayList<>();
        averageDepth.add(startDepth);
        numberOfOperation.add(0);
        for(int i = 0; i < 10000; i++){
            ExperimentHelper.randomDeleteAndAdd(tree);
            Double aveDepth = tree.averageDepth();
            averageDepth.add(aveDepth);
            operationNumber += 2;
            numberOfOperation.add(operationNumber);



        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("operation numbers").yAxisTitle("average depth").build();
        chart.addSeries("average depth with random delete and add operations", numberOfOperation, averageDepth);


        new SwingWrapper(chart).displayChart();

    }


    public static void experiment3() {
        int range = 10000;
        int N = 5000;
        int operationNumber = 0;

        BST tree = new BST<>();
        List<Integer> randomNumbers = new ArrayList<>();
        int[] items = StdRandom.permutation(range, N);
        for (int item : items) {
            tree.add(item);
        }


        Double startDepth = tree.averageDepth();

        List<Double> averageDepth = new ArrayList<>();
        List<Integer> numberOfOperation = new ArrayList<>();
        averageDepth.add(startDepth);
        numberOfOperation.add(0);
        for(int i = 0; i < 100000; i++){
            ExperimentHelper.randomDeleteAndAdd2(tree);
            Double aveDepth = tree.averageDepth();
            averageDepth.add(aveDepth);
            operationNumber += 2;
            numberOfOperation.add(operationNumber);



        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("operation numbers").yAxisTitle("average depth").build();
        chart.addSeries("average depth with random delete and add operations", numberOfOperation, averageDepth);


        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        experiment3();
    }
}
