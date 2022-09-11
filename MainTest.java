/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
    
    @Test
    public void testMain() {
        Main testMain = new Main();
        assertEquals(12.77,Main.computeOrder(11.99),0.01);
        assertEquals(38.31, Main.computeOrder(11.99, 3),0.01);
        assertEquals(34.48, Main.computeOrder(11.99,3,0.1),0.01);
    }

}
