import components.Battery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryTest {

    public Battery battery;

    @Before
    public void setup(){
        battery = new Battery("Tesla", "Bionic");
    }

    @Test
    public void hasMake(){
        assertEquals("Tesla", battery.getMake());
    }

    @Test
    public void hasModel(){
        assertEquals("Bionic", battery.getModel());
    }

}
