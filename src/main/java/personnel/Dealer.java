package personnel;

import interfaces.ISell;

public class Dealer extends Person implements ISell {

    private int dailySalesTarget;
    private int sales;

    public Dealer(String name, int age, int dailySalesTarget){
        super(name, age);
        this.dailySalesTarget = dailySalesTarget;
        this.sales = 0;
    }

    public int getDailySalesTarget(){
        return dailySalesTarget;
    }

    public int getSales(){
        return sales;
    }

    public void sale(){
        this.sales += 1;
    }
}
