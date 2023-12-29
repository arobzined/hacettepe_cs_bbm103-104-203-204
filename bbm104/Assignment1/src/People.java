public class People {
    private int personid;
    private String personname;
    private String persongender;
    private int weight;
    private int height;
    private int dateofBirth;

    public People(int personid,String personname,String persongender,int weight,int height,int dateofBirth) {
        this.personid = personid;
        this.personname = personname;
        this.persongender = persongender;
        this.weight = weight;
        this.height = height;
        this.dateofBirth = dateofBirth;
    }


    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getPersongender() {
        return persongender;
    }

    public void setPersongender(String persongender) {
        this.persongender = persongender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(int dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    private int carolinow;
    private int calorigained;
    private int caloriburned;
    private int bazalmetabolizma;
    private int calorinet;

    public int getBazalmetabolizma() {
        return bazalmetabolizma;
    }

    public void setBazalmetabolizma(int bazalmetabolizma) {
        this.bazalmetabolizma = bazalmetabolizma;
    }


    public void yemekYediyse(int porsiyon, int calori){
        this.setCarolinow(this.getCarolinow() + (porsiyon*calori));
        this.setCalorigained(this.getCalorigained() + (porsiyon*calori));

    }
    public void sporYaptıysa(int duration,int calori){
        this.setCarolinow(this.getCarolinow() - (duration*(calori/60)));
        this.setCaloriburned(this.getCaloriburned() + ((calori/60)*duration));
    }
    public void bazalMetabolizmaHesalayıcı(){
        if (this.getPersongender().equals("male")){
            this.setBazalmetabolizma(((int)(67+(13.75*this.weight)+(5*this.height)-(6.8* (2022-this.dateofBirth)))));
        }
        else{
            this.setBazalmetabolizma(((int)(666+(9.6*this.weight)+(1.7*this.height)-(4.7* (2022-this.dateofBirth)))));
        }
    }
    public void netcalorihesaplama(){
        this.calorinet = (-this.bazalmetabolizma+this.calorigained-this.caloriburned);
    }

    public int getCarolinow() {
        return carolinow;
    }

    public void setCarolinow(int carolinow) {
        this.carolinow = carolinow;
    }

    public int getCalorigained() {
        return calorigained;
    }

    public void setCalorigained(int calorigained) {
        this.calorigained = calorigained;
    }

    public int getCaloriburned() {
        return caloriburned;
    }

    public void setCaloriburned(int caloriburned) {
        this.caloriburned = caloriburned;
    }


    public int getCalorinet() {
        return calorinet;
    }

    public void setCalorinet(int calorinet) {
        this.calorinet = (-this.bazalmetabolizma+this.calorigained-this.caloriburned);
    }
}
