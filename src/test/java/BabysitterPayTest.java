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
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        babysitterPay.startTime(julyTwelfth2019At5PM);
        babysitterPay.endTime(julyTwelfth2019At6PM);
        assertEquals(babysitterPay.getPay(), 15.00);
    }

    @Test
    public void testABabySitterDoesNotWorkPriorTo5PM() {
        try {
            LocalDateTime julyTwelfth2019At2PM = LocalDateTime.of(2019, Month.JULY, 12, 14, 0);
            babysitterPay.startTime(julyTwelfth2019At2PM);
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterDoesNotWorkAfter4AM() {
        try {
            LocalDateTime julyTwelfth2019At5AM = LocalDateTime.of(2019, Month.JULY, 12, 5, 0);
            babysitterPay.endTime(julyTwelfth2019At5AM);
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterCannotEndBeforeTheyStart() {
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        LocalDateTime julyTwelfth2019At5Pm = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        try {
            babysitterPay.startTime(julyTwelfth2019At6PM);
            babysitterPay.endTime(julyTwelfth2019At5Pm);
            babysitterPay.getPay();
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Can't end work before you start."));
        }
    }
}
