import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader output = null;
        List<Integer> unsorted_array = new ArrayList<Integer>(); // creating reader and list for our files and stuff to store here.
        try {
            String strCurrentLine;
            output = new BufferedReader(new FileReader(args[0])); //reading file and getting data
            int i = 0;
            while ((strCurrentLine = output.readLine()) != null) {
                if(i == 0){
                    i++;
                    continue;
                }
                if(i > 500) { // here s where i decide my input size (500 , 1000 , 2000 , etc.)
                    break;
                }
                String[] inp = strCurrentLine.split(",");
                unsorted_array.add(Integer.valueOf(inp[6]));//for every input line , split the data for commas and select the value that we are going to use in out project
                i++;
            }


        } catch (FileNotFoundException exe) {
            exe.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        List<Integer> unsorted1 = Arrays.asList(new Integer[unsorted_array.size()]);
        List<Integer> unsorted2 = unsorted_array; // just for some extra spaces if we need'em :D

        //BucketSort alg = new BucketSort(unsorted_array); //for sorted test stuff , i used bucketsort because of its super fast and easy to use
        //unsorted_array = alg.bucket_sort(unsorted_array.size());

        //List<Integer> fin_list = reverser(unsorted_array); // this is the reverser static func that i wrote , you can check it little down here :D
        //System.out.println(fin_list);


        int j = 10;
        long total_time = 0;



        for(int i = 0;i < 1000;i++){
            //Collections.copy(unsorted1, unsorted_array);
            //Collections.copy(unsorted1, fin_list);

            //long start1 = System.nanoTime(); // the time that i note for my report.


            //SelectionSort alg1 = new SelectionSort(unsorted1);
            //unsorted1 = alg1.selection_sort(unsorted1.size());

            //QuickSort alg2 = new QuickSort(unsorted1);
            //unsorted1 = alg2.quick_sort(unsorted1.size(),0,unsorted1.size() - 1);

            //BucketSort alg1 = new BucketSort(unsorted1);
            //unsorted1 = alg1.bucket_sort(unsorted_array.size());


            //long end1 = System.nanoTime();
            //System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));

            //total_time += (end1 - start1);

        }
        //System.out.println("****************************************");
        //System.out.println("mean is : " + total_time / 1000);



        Random random = new Random();
        for(int i = 0;i < 10;i++){
            Collections.copy(unsorted1, unsorted_array);
            //System.out.println(unsorted1);
            int indexx = random.nextInt(unsorted1.size());
            System.out.println(indexx);

            long start1 = System.nanoTime();


            LinearSearch algo_x = new LinearSearch(unsorted1);
            algo_x.linear_search(unsorted1.get(indexx));
            //System.out.println(unsorted1);

            //BinarySearch algo_y = new BinarySearch(unsorted1);
            //algo_y.binary_search(value);
            //System.out.println(x + "found");

            long end1 = System.nanoTime();
            System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
            total_time += (end1 - start1);

        }
        System.out.println("****************************************");
        System.out.println("mean is : " + total_time / 10);

        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};

        // Create sample data for linear runtime
        double[][] yAxis = new double[3][10];
        /*yAxis[0] = new double[]{1.5133, 2.9135, 7.6189, 25.4314, 97.8697, 374.4652, 1337.6882, 4116.7087, 19689.4805, 69000.5036};
        yAxis[1] = new double[]{0.4220, 0.8861, 1.3802, 3.2894, 6.0397, 9.4256, 34.2318, 109.9010, 275.0588, 488.6334};
        yAxis[2] = new double[]{6.4920, 6.3678, 6.8326, 7.8520, 10.7254, 15.3057, 22.2049, 27.7423, 47.6306, 91.0643};
        */
                             //   500  , 1000  , 2000  , 4000   , 8000  , 16000   , 32000 ,   64000   , 128000  , 250000
        /*yAxis[0] = new double[]{1.4869, 2.2435, 3.4317, 8.4922, 29.6903, 114.3286, 426.6022, 1657.2117, 6598.6931, 22147.8894};
        yAxis[1] = new double[]{3.4869, 8.2540, 21.6650, 77.6803, 262.6801, 934.6410, 3623.5972, 14399.6165, 49985.6594, 237397.3284};
        yAxis[2] = new double[]{0.3703, 0.6667, 0.8010, 1.1682, 1.6568, 3.5691, 6.0566, 11.5406, 21.1909, 35.7807};*/

        // reversly
        /*
        yAxis[0] = new double[]{1.6443, 3.7966, 6.2651, 24.7200, 92.4650, 350.3254, 1379.7816, 5422.6256, 21909.3642, 83138.7604};
        yAxis[1] = new double[]{2.7472, 5.8592, 10.7075, 27.8223, 81.1304, 150.8751, 438.2218, 1846.6529, 7118.9180, 14906.0926};
        yAxis[2] = new double[]{0.2916, 0.5684, 1.0251, 1.2733, 2.3025, 3.4754, 6.6495, 13.1006, 24.8088, 33.0227};*/


        // Searching

        //yAxis[0] = new double[]{7923,10470,10768,13309,17947,23451,36998,44417,68612,142972};
        //yAxis[1] = new double[]{6305,10734,10222,11309,12971,17277,27286,51406,88178,250228};
        //yAxis[2] = new double[]{1578,1559,1585,1557,1402,1680,1808,2045,1755,2373};



        // Save the char as .png and show it
        /*try {
            showAndSaveChart("Searching Algorithms", inputAxis, yAxis);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
    public static List<Integer> reverser(List<Integer> a_list){
        List<Integer> final_list = Arrays.asList(new Integer[a_list.size()]);
        int i = a_list.size();
        for(int j = 0;j < a_list.size();j++){
            final_list.set(j,a_list.get(i-1));
            i--;
        }
        return final_list;
    }
    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title).yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Linear - Random", doubleX, yAxis[0]);
        chart.addSeries("Linear - Sorted", doubleX, yAxis[1]);
        chart.addSeries("Binary - Sorted", doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }

}
