import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FamilyBTest {

    @Test
    public void testABabysitterForFamilyBMakes12DollarsForOneHourOfWorkBefore10PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        FamilyB familyB = new FamilyB();
        familyB.startTime(julyTwelfth2019At5PM);
        familyB.endTime(julyTwelfth2019At6PM);
        try {
            assertEquals(12.00, familyB.getPay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes36DollarsForWorking3Hours() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At8PM = LocalDateTime.of(2019, Month.JULY, 12, 20, 0);
        FamilyB familyB = new FamilyB();
        familyB.startTime(julyTwelfth2019At5PM);
        familyB.endTime(julyTwelfth2019At8PM);
        try {
            assertEquals(36.00, familyB.getPay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes8DollarsForWorking1HourBetween8PMAnd10PM() {
        LocalDateTime julyTwelfth2019At10PM = LocalDateTime.of(2019, Month.JULY, 12, 22, 0);
        LocalDateTime julyTwelfth2019At11PM = LocalDateTime.of(2019, Month.JULY, 12, 23, 0);
        FamilyB familyB = new FamilyB();
        familyB.startTime(julyTwelfth2019At10PM);
        familyB.endTime(julyTwelfth2019At11PM);
        try {
            assertEquals(8.00, familyB.getPay());
        } catch (Exception e) {
            fail();
        }
    }
}
