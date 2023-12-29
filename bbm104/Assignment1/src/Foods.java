public class Foods {
    private int foodid;
    private String foodname;
    private int calorieofFood;

    public Foods(int foodid,String foodname,int calorieofFood) {
        this.setFoodid(foodid);
        this.setFoodname(foodname);
        this.setCalorieofFood(calorieofFood);
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getCalorieofFood() {
        return calorieofFood;
    }

    public void setCalorieofFood(int calorieofFood) {
        this.calorieofFood = calorieofFood;
    }


}
