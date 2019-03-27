import components.Battery;
import components.Engine;
import components.GearBox;
import org.junit.Before;
import org.junit.Test;
import vehicles.PetrolCar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetrolCarTest {

    public PetrolCar car;
    public Battery battery;
    public Engine engine;
    public GearBox gearbox;

    @Before
    public void setup(){
        car = new PetrolCar("Nissan", "Maker", "blue", 4, "manual",55.00, 25000);

        battery = new Battery("Tesla", "Bionic");
        engine = new Engine("Joaquin", "Runner");
        gearbox = new GearBox("Hassler", "Shift");
    }

    @Test
    public void hasMake(){
        assertEquals("Nissan", car.getMake());
    }

    @Test
    public void hasModel(){
        assertEquals("Maker", car.getModel());
    }

    @Test
    public void hasColour(){
        assertEquals("blue", car.getColour());
    }

    @Test
    public void hasNumberOfDoors(){
        assertEquals(4, car.getDoors());
    }

    @Test
    public void hasHirePrice(){
        assertEquals(55.00, car.getHirePrice(), 0);
    }

    @Test
    public void hasRentalStatus(){
        assertEquals(false, car.getRented());
    }

    @Test
    public void startsWithNoCustomer(){
        assertEquals(null, car.getCustomer());
    }

    @Test
    public void startsWithNoComponents(){
        assertEquals(0, car.getComponents().size());
    }

    @Test
    public void canAddComponentToCar(){
        car.add(battery);
        car.add(engine);
        car.add(gearbox);
        assertEquals(3, car.getComponents().size());
    }



}
