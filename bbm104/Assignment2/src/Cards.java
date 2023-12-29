public abstract class Cards extends Monopoly{
    private String itemvalue;

    public Cards(String itemvalue){
        this.setItemvalue(itemvalue);
    }


    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue;
    }
}

