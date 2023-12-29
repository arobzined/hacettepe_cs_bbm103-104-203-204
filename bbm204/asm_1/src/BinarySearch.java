import java.util.List;

public class BinarySearch {
    public List<Integer> the_list;
    public BinarySearch(List<Integer> the_list){
        this.the_list = the_list;
    }

    public int binary_search(int item){
        int low = 0;
        int high = this.the_list.size() - 1;
        int size = this.the_list.size();
        while (high - low > 1){
            int mid = (high + low) / 2;
            if(this.the_list.get(mid) < item){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        if(this.the_list.get(low) == item){
            return low;
        }
        else if(this.the_list.get(high) == item){
            return high;
        }
        return -1;
    }
}
