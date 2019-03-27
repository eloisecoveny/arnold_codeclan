package dealership;

public class CashRegister {

    private double pettyCash;
    private int sales;

    public CashRegister(double pettyCash){
        this.pettyCash = pettyCash;
        this.sales = 0;
    }

    public double getPettyCash(){
        return pettyCash;
    }

    public int getSales(){
        return sales;
    }

    public void add(double cash){
        this.pettyCash += cash;
        this.sales += cash;
    }

    public void subtract(double cash){
        this.pettyCash -= cash;
    }
}
