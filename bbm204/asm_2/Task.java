import java.time.LocalTime;
import java.util.Arrays;

public class Task implements Comparable {
    public String name;
    public String start;
    public int duration;
    public int importance;
    public boolean urgent;

    /*
        Getter methods
     */
    public String getName() {
        return this.name;
    }

    public String getStartTime() {
        return this.start;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getImportance() {
        return this.importance;
    }

    public boolean isUrgent() {
        return this.urgent;
    }

    /**
     * Finish time should be calculated here
     *
     * @return calculated finish time as String
     */
    public String getFinishTime() {
        int hour = Integer.parseInt(this.start.substring(0,2));
        int minute = Integer.parseInt(this.start.substring(3));
        if(minute == 0){
            if(hour + this.duration < 10){
                return String.format("0%d:00", hour + this.duration);
            }
            return String.format("%d:00", hour + this.duration);
        }
        else{
            if(hour + this.duration < 10){
                return String.format("0%d:%d", hour + this.duration, minute);
            }
            return String.format("%d:%d", hour + this.duration, minute);
        }
    }

    /**
     * Weight calculation should be performed here
     *
     * @return calculated weight
     */
    public double getWeight() {
        int weight = (this.importance * (this.urgent ? 2000 : 1)) / this.duration;
        //System.out.println(weight);
        return weight;
    }

    /**
     * This method is needed to use {@link Arrays#sort(Object[])} ()}, which sorts the given array easily
     *
     * @param o Object to compare to
     * @return If self > object, return > 0 (e.g. 1)
     * If self == object, return 0
     * If self < object, return < 0 (e.g. -1)
     */
    @Override
    public int compareTo(Object o) {
        Task other = (Task) o; // Cast to the actual type of the objects being compared
        int thisHour = Integer.parseInt(this.getFinishTime().substring(0, 2));
        int thisMinute = (Integer.parseInt(this.getFinishTime().substring(3)));
        int otherHour = Integer.parseInt(other.getFinishTime().substring(0, 2));
        int otherMinute = (Integer.parseInt(other.getFinishTime().substring(3)));

        if (thisHour < otherHour) {
            return -1;
        } else if (thisHour > otherHour) {
            return 1;
        } else {
            // Hours are equal, compare minutes
            if(thisMinute < otherMinute) {
                return -1;
            } else if (thisMinute > otherMinute) {
                return 1;
            } else {
                // Hours and minutes are equal
                return 0;
            }
        }
    }

}
