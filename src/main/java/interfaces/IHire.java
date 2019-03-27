package interfaces;

import dealership.Dealership;
import vehicles.Vehicle;

public interface IHire {

    public double hires(Vehicle vehicle, int days);

    public double pays(double cost);
}
