package vehicles;

import components.Component;
import personnel.Customer;

import java.util.ArrayList;

public abstract class Vehicle {

    private String make;
    private String model;
    private String colour;
    private ArrayList<Component> components;
    private boolean rented;
    private Customer customer;
    private double hirePrice;
    private double purchasePrice;
    private double damages;

    public Vehicle(String make, String model, String colour, double hirePrice, double purchasePrice){
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.components = new ArrayList<Component>();
        this.rented = false;
        this.customer = null;
        this.hirePrice = hirePrice;
        this.purchasePrice = purchasePrice;
        this.damages = damages;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getColour(){
        return colour;
    }

    public ArrayList<Component> getComponents(){
        return components;
    }

    public boolean getRented(){
        return rented;
    }

    public Customer getCustomer(){
        return customer;
    }

    public double getHirePrice(){
        return hirePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void add(Component component){
        this.components.add(component);
    }

    public void isRented(Customer customer){
        this.rented = true;
        this.customer = customer;
    }

    public void isReturned(){
        this.rented = false;
        this.customer = null;
    }

    public void assign(Customer customer){
        this.customer = customer;
    }

    public void inflicted(double damage){
        this.damages += damage;
        this.purchasePrice -= damage;
    }

    public double getDamages() {
        return damages;
    }

    public void isRepaired(){
        this.purchasePrice += this.damages;
        this.damages = 0;
    }
}
