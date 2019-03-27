package vehicles;

import components.Battery;
import components.Engine;
import components.Tyre;

public abstract class Car extends Vehicle {

    private int doors;
    private String type;
    private Engine engine;
    private Tyre tyre;
    private Battery battery;

    public Car(String make, String model, String colour, int doors, String type, double hirePrice, double purchasePrice){
        super(make, model, colour, hirePrice, purchasePrice);
        this.doors = doors;
        this.engine = engine;
        this.tyre = tyre;
        this.tyre = tyre;
        this.battery = battery;
    }

    public int getDoors(){
        return doors;
    }

    public String getType() {
        return type;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Battery getBattery() {
        return battery;
    }
}
