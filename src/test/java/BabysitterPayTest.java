import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class BabysitterPayTest {

    private BabysitterPay babysitterPay;

    @BeforeEach
    public void setUp() {
        babysitterPay = new BabysitterPay("Family A");
    }

    @Test
    public void testABabysitterForFamilyAMakes15DollarsAnHourBefore11PM() throws Exception {
        babysitterPay.startTime(LocalDateTime.of(2019, Month.JULY, 12, 17, 0));
        babysitterPay.endTime(LocalDateTime.of(2019, Month.JULY, 12, 18, 0));
        assertEquals(babysitterPay.getPay(), 15.00);
    }

    @Test
    public void testABabySitterDoesNotWorkPriorTo5PM() {
        try {
            babysitterPay.startTime(LocalDateTime.of(2019, Month.JULY, 12, 14, 0));
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterDoesNotWorkAfter4AM() {
        try {
            babysitterPay.endTime(LocalDateTime.of(2019, Month.JULY, 12, 5, 0));
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterCannotEndBeforeTheyStart() {
        try {
            babysitterPay.startTime(LocalDateTime.of(2019, Month.JULY, 12, 18, 0));
            babysitterPay.endTime(LocalDateTime.of(2019, Month.JULY, 12, 17, 0));
            babysitterPay.getPay();
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Can't end work before you start."));
        }
    }
}
