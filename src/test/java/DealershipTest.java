import dealership.Dealership;
import org.junit.Before;
import org.junit.Test;
import personnel.Customer;
import vehicles.ElectricCar;

import static org.junit.Assert.assertEquals;

public class DealershipTest {

    public Dealership dealership;
    public ElectricCar car;
    public Customer customer;

    @Before
    public void setup(){
        dealership = new Dealership("Arnold CodeClan", 300000);
        customer = new Customer("Eloise", 32, true, 130.50);
        car = new ElectricCar("Tesla", "Roadster", "blue", 4, "manual",75.00, 30000);
    }

    @Test
    public void canBuyCar(){
        dealership.buy(car);
        assertEquals(1, dealership.getVehicles().size());
        assertEquals(270000, dealership.getNetBalance(), 0);
    }

    @Test
    public void canRentCar(){
        dealership.buy(car);
        dealership.hiresTo(customer, car, 1);
        assertEquals(55.50, customer.getFunds(), 0);
        assertEquals(400, dealership.getTill().getPettyCash(), 0);
        assertEquals(1, dealership.getDealer().getSales());
    }

    @Test
    public void carReturnWithNoDamages(){
        dealership.buy(car);
        dealership.hiresTo(customer, car, 1);
        dealership.returns(car, 0);
        assertEquals(null, customer.getVehicle());
        assertEquals(1, dealership.getVehicles().size());
        assertEquals(30000.00, car.getPurchasePrice(), 0);
        assertEquals(0, car.getDamages(), 0);
    }

    @Test
    public void carReturnCarWithDamages(){
        dealership.buy(car);
        dealership.hiresTo(customer, car, 1);
        dealership.returns(car, 25.00);
        assertEquals(null, customer.getVehicle());
        assertEquals(1, dealership.getVehicles().size());
        assertEquals(29975.00, car.getPurchasePrice(), 0);
        assertEquals(25.00, car.getDamages(), 0);
    }

    @Test
    public void canRepairCar(){
        dealership.buy(car);
        dealership.hiresTo(customer, car, 1);
        dealership.returns(car, 25.00);
        dealership.repairs(car);
        assertEquals(null, customer.getVehicle());
        assertEquals(1, dealership.getVehicles().size());
        assertEquals(30000.00, car.getPurchasePrice(), 0);
        assertEquals(0, car.getDamages(), 0);
        assertEquals(375.00, dealership.getTill().getPettyCash(), 0);
    }

}
