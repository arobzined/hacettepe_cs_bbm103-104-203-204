import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public List<Integer> the_list;
    public QuickSort(List<Integer> the_list){
        this.the_list = the_list;
    }

    public List<Integer> quick_sort(int list_size,int first_elm,int last_elm){
        int stackSize = last_elm - first_elm + 1;
        List<Integer> stack = Arrays.asList(new Integer[list_size]);
        int top = -1;
        stack.set(++top,first_elm);
        stack.set(++top,last_elm);
        while(top > 0){
            int high = stack.get(top--);
            int low = stack.get(top--);
            int pivot = this.partition(low,high);
            if(pivot - 1 > low){
                stack.set(++top,low);
                stack.set(++top,pivot-1);
            }
            if(pivot + 1 < high){
                stack.set(++top,pivot + 1);
                stack.set(++top,high);
            }
        }

        return this.the_list;
    }

    public int partition(int fi,int li){
        int pivot = this.the_list.get(li);
        int i = fi - 1;
        for(int j = fi;j < li;j++){
            if(this.the_list.get(j) <= pivot){
                i = i + 1;
                int temp = this.the_list.get(i);
                this.the_list.set(i,this.the_list.get(j));
                this.the_list.set(j,temp);
            }
        }
        int temp = this.the_list.get(i+1);
        this.the_list.set(i+1,this.the_list.get(li));
        this.the_list.set(li,temp);

        return i+1;
    }
}
