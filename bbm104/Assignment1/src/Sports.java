public class Sports {
    private int sportid;
    private String sportname;
    private int calorieBurned;

    public Sports(int sportid,String sportname,int calorieBurned) {
        this.sportid = sportid;
        this.sportname = sportname;
        this.calorieBurned = calorieBurned;
    }

    public int getSportid() {
        return sportid;
    }

    public void setSportid(int sportid) {
        this.sportid = sportid;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }

    public int getCalorieBurned() {
        return calorieBurned;
    }

    public void setCalorieBurned(int calorieBurned) {
        this.calorieBurned = calorieBurned;
    }

    public void sporYaparsa(){

    }
}
