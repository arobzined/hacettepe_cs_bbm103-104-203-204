import java.util.List;

public class LinearSearch {
    public List<Integer> the_list;
    public LinearSearch(List<Integer> the_list){
        this.the_list = the_list;
    }

        public int linear_search(int item){
            int size = this.the_list.size();
            for(int x : this.the_list) {
                if (x == item) {
                    return item;
                }
            }
            return -1;
        }
}

