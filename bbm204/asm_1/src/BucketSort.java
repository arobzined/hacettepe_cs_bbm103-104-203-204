
import java.util.ArrayList;
import java.util.List;

public class BucketSort {


    public List<Integer> the_list;
    public BucketSort(List<Integer> the_list){
        this.the_list = the_list;
    }

    public List<Integer> bucket_sort(int list_size){
        int numberOfBuckets = (int) Math.sqrt(list_size);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0;i < list_size ; i++){
            buckets.add(new ArrayList<>());
        }
        int max = this.the_list.get(0);
        for(int i:this.the_list){
            if(i > max){
                max = i;
            }
        }
        for(int i : this.the_list){
            buckets.get(this.hashing(i,max,numberOfBuckets)).add(i);
        }

        for(List<Integer> x : buckets){
            x.sort(Integer::compare);
        }

        List<Integer> sortedArray = new ArrayList<>();

        for(List<Integer> x : buckets){
            for(int i : x){
                sortedArray.add(i);
            }
        }

        this.the_list = sortedArray;
        return this.the_list;
    }

    public int hashing(int element,int max,int bucket_numbers){
        return ((element/max) * (bucket_numbers - 1));
    }
}
