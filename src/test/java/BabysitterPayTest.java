import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class BabysitterPayTest {

    private BabysitterPay babysitterPay;

    @BeforeEach
    public void setUp() {
        babysitterPay = new BabysitterPay("Family A");
    }

    @Test
    public void testABabysitterForFamilyAMakes15DollarsAnHourBefore11PM() throws Exception {
        babysitterPay.startTime(LocalTime.parse("17:00"));
        assertEquals(babysitterPay.getPay(), 15.00);
    }

    @Test
    public void testABabySitterDoesNotWorkPriorTo5PM() {
        try {
            babysitterPay.startTime(LocalTime.parse("14:00"));
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterDoesNotWorkAfter4AM() {
        try {
            babysitterPay.endTime(LocalTime.parse("05:00"));
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }
}
