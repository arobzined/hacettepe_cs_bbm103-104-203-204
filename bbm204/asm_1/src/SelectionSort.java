import java.util.List;

public class SelectionSort {

    public List<Integer> the_list;
    public SelectionSort(List<Integer> the_list){
        this.the_list = the_list;
    }

    public List<Integer> selection_sort(int list_size){
        for(int i = 0;i < list_size;i++){
            int min = i;
            for(int j = i+1;j < list_size;j++){
                int temp = this.the_list.get(j);
                if(temp < this.the_list.get(min)){
                    min = j;
                }
            }
            if(min != i){
                this.swap_elm(i,min);
            }
        }
        return this.the_list;
    }

    public void swap_elm(int fi,int si){
        int temp = this.the_list.get(fi);
        this.the_list.set(fi,this.the_list.get(si));
        this.the_list.set(si,temp);
    }
}
