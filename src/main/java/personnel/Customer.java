package personnel;

import dealership.Dealership;
import interfaces.IHire;
import vehicles.Vehicle;

public class Customer extends Person implements IHire {

    private boolean hasLicence;
    private double funds;
    private Vehicle vehicle;

    public Customer(String name, int age, boolean hasLicence, double funds){
        super(name, age);
        this.hasLicence = hasLicence;
        this.funds = funds;
        this.vehicle = vehicle;
    }

    public double hires(Vehicle vehicle, int days){
        double price = vehicle.getHirePrice();
        double total = price * days;
        this.vehicle = vehicle;
        this.pays(total);
        return total;
    }

    public void returns(Vehicle vehicle){
        this.vehicle = null;
    }

    public double pays(double cost){
        return this.funds -= cost;
    }

    public boolean hasLicence(){
        return hasLicence;
    }

    public double getFunds(){
        return funds;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
