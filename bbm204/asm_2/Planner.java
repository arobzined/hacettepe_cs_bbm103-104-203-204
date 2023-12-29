import java.util.ArrayList;
import java.util.Arrays;

public class Planner {

    public final Task[] taskArray;
    public final Integer[] compatibility;
    public final Double[] maxWeight;
    public final ArrayList<Task> planDynamic;
    public final ArrayList<Task> planGreedy;

    public Planner(Task[] taskArray) {

        // Should be instantiated with an Task array
        // All the properties of this class should be initialized here

        this.taskArray = taskArray;
        this.compatibility = new Integer[taskArray.length];
        maxWeight = new Double[taskArray.length];

        this.planDynamic = new ArrayList<>();
        this.planGreedy = new ArrayList<>();
    }

    /**
     * @param index of the {@link Task}
     * @return Returns the index of the last compatible {@link Task},
     * returns -1 if there are no compatible {@link Task}s.
     */
    public int binarySearch(int index) {
        int low = 0;
        int high = this.taskArray.length - 1;
        int result = -1;

        while(low <= high){
            int mid = low + ((high - low )/ 2);
            double start_time = Integer.parseInt(this.taskArray[index].getStartTime().substring(0,2));
            double start_minute = Integer.parseInt(this.taskArray[index].getStartTime().substring(3));
            start_minute /= 60;

            double finish_time = Integer.parseInt(this.taskArray[mid].getFinishTime().substring(0,2));
            double finish_minute = Integer.parseInt(this.taskArray[mid].getStartTime().substring(3));
            finish_minute /= 60;

            start_time += start_minute;
            finish_time += finish_minute;

            if (finish_time <= start_time){
                result = mid;// x is on the right side
                low = mid + 1;
            }
            else{// x is on the left side
                high = mid - 1;
            }
        }
        return result;
    }


    /**
     * {@link #compatibility} must be filled after calling this method
     */

    public void calculateCompatibility() {
        int size = this.taskArray.length;
        Arrays.fill(this.compatibility,-1);
        for(int i = 0;i < size;i++){
            this.compatibility[i] = this.binarySearch(i);
        }
        System.out.println("Calculating max array");
        System.out.println("---------------------");
        this.calculateMaxWeight(size - 1);
    }


    /**
     * Uses {@link #taskArray} property
     * This function is for generating a plan using the dynamic programming approach.
     * @return Returns a list of planned tasks.
     */

    public ArrayList<Task> planDynamic() {
        System.out.println();
        System.out.println("Calculating the dynamic solution");
        System.out.println("--------------------------------");
        solveDynamic(this.taskArray.length - 1);
        System.out.println();
        System.out.println("Dynamic Schedule\n" +
                "----------------");
        this.reverser();
        for(Task x : planDynamic){
            System.out.println(String.format("At %s, %s.",  x.getStartTime(), x.getName()));
        }
        return planDynamic;
    }

    /**
     * {@link #planDynamic} must be filled after calling this method
     */
    public void solveDynamic(int i) {
        if(this.compatibility[i] == null){
            this.calculateCompatibility();
        }
        if(this.maxWeight[i] == null){
            this.calculateMaxWeight(this.taskArray.length - 1);
        }
        if (i < 0){
            return;
        }
        System.out.println(String.format("Called solveDynamic(%d)", i));
        if(this.compatibility[i] == -1){
            planDynamic.add(this.taskArray[i]);
            return;
        }

        if (this.maxWeight[i] - this.taskArray[i].getWeight() == this.maxWeight[compatibility[i]]) {
            planDynamic.add(this.taskArray[i]);
            solveDynamic(compatibility[i]);
        } else {
            solveDynamic(i - 1);
        }
    }


    /**
     * {@link #maxWeight} must be filled after calling this method
     */
    /* This function calculates maximum weights and prints out whether it has been called before or not  */
    public Double calculateMaxWeight(int i) {
        System.out.println(String.format("Called calculateMaxWeight(%d)", i));
        if(i < 0 || i >= maxWeight.length){
            return 0.0;
        }

        if(maxWeight[i] != null){
            if(i == 0){
                System.out.println("Called calculateMaxWeight(-1)");
                System.out.println("Called calculateMaxWeight(-1)");
            }
            return maxWeight[i];
        }
        else if(maxWeight[i] == null){
            maxWeight[i] = Math.max(calculateMaxWeight(compatibility[i]) + this.taskArray[i].getWeight(),calculateMaxWeight(i - 1));
        }
        return maxWeight[i];
    }

    /**
     * {@link #planGreedy} must be filled after calling this method
     * Uses {@link #taskArray} property
     *
     * @return Returns a list of scheduled assignments
     */

    /*
     * This function is for generating a plan using the greedy approach.
     * */
    public ArrayList<Task> planGreedy() {
        for(int i = 0;i < this.taskArray.length;i++){
            if(i == 0){
                this.planGreedy.add(this.taskArray[0]);
            }
            else {
                double start_time = Integer.parseInt(this.taskArray[i].getStartTime().substring(0,2));
                double start_minute = Integer.parseInt(this.taskArray[i].getStartTime().substring(3));
                start_minute /= 60;
                start_time += start_minute;

                double finish_time = Integer.parseInt(this.planGreedy.get(this.planGreedy.size() - 1).getFinishTime().substring(0,2));
                double finish_minute = Integer.parseInt(this.planGreedy.get(this.planGreedy.size() - 1).getStartTime().substring(3));
                finish_minute /= 60;
                finish_time += finish_minute;

                if(start_time >= finish_time){
                    this.planGreedy.add(this.taskArray[i]);
                }
            }
        }
        System.out.println("Greedy Schedule\n" +
                "---------------");
        for(Task x : this.planGreedy){
            System.out.println(String.format("At %s, %s.",  x.getStartTime(), x.getName()));
        }

        return this.planGreedy;
    }
    // for the reversing of planDynamic arraylist since collections cannot usable.
    public void reverser(){
        int size = this.planDynamic.size();
        Task[] arr = new Task[size];
        int j = 0;
        for(int i = size - 1;i > -1;i--){
            arr[i] = this.planDynamic.get(j);
            j++;
        }
        for(int i = 0;i < size;i++){
            this.planDynamic.set(i,arr[i]);
        }
    }
}
