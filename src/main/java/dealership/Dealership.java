package dealership;

import personnel.Customer;
import personnel.Dealer;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private ArrayList<Vehicle> vehicles;
    private Dealer dealer;
    private CashRegister till;
    private double netBalance;

    public Dealership(String name, double netBalance){
        this.name = name;
        this.vehicles = new ArrayList<Vehicle>();
        this.dealer = new Dealer("Stanley", 29, 10);
        this.till = new CashRegister(325.00);
        this.netBalance = netBalance;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public Dealer getDealer(){
        return dealer;
    }

    public void setDealer(Dealer dealer){
        this.dealer = dealer;
    }

    public CashRegister getTill(){
        return till;
    }

    public double getNetBalance(){
        return netBalance;
    }

    public void buy(Vehicle vehicle){
        double price = vehicle.getPurchasePrice();
        this.netBalance -= price;
        this.vehicles.add(vehicle);
    }

    public void hiresTo(Customer customer, Vehicle vehicle, int days){
        if(this.vehicles.contains(vehicle)){
            int index = this.vehicles.indexOf(vehicle);
            this.vehicles.remove(index);
            vehicle.assign(customer);
        }
        double cash = customer.hires(vehicle, days);
        this.getTill().add(cash);
        this.getDealer().sale();
    }

    public void returns(Vehicle vehicle, double damage){
        this.vehicles.add(vehicle);
        vehicle.getCustomer().returns(vehicle);
        vehicle.isReturned();
        if(damage > 0){
            vehicle.inflicted(damage);
        }
    }

    public void repairs(Vehicle vehicle){
        double repairCosts = vehicle.getDamages();
        this.till.subtract(repairCosts);
        vehicle.isRepaired();
    }
}
