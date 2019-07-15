import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BabysitterPayTest {

    private Babysitter babysitter;

    @BeforeEach
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void testABabySitterDoesNotWorkPriorTo5PM() {
        try {
            LocalDateTime julyTwelfth2019At2PM = LocalDateTime.of(2019, Month.JULY, 12, 14, 0);
            babysitter.startTime(julyTwelfth2019At2PM);
            babysitter.endTime(julyTwelfth2019At2PM);
            babysitter.isInWorkingHours();
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Outside of working hours."));
        }
    }

    @Test
    public void testABabySitterDoesNotWorkAfter4AM() {
        try {
            LocalDateTime julyTwelfth2019At5AM = LocalDateTime.of(2019, Month.JULY, 12, 5, 0);
            babysitter.startTime(julyTwelfth2019At5AM);
            babysitter.endTime(julyTwelfth2019At5AM);
            babysitter.isInWorkingHours();
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
            babysitter.startTime(julyTwelfth2019At6PM);
            babysitter.endTime(julyTwelfth2019At5Pm);
            babysitter.isInWorkingHours();
            fail();
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains("Can't end work before you start."));
        }
    }

}
