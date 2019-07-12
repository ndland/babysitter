import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyATest {

    @Test
    public void testABabysitterForFamilyAMakes15DollarsForOneHourOfWorkBefore11PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        FamilyA familyA = new FamilyA();
        familyA.startTime(julyTwelfth2019At5PM);
        familyA.endTime(julyTwelfth2019At6PM);
        try {
            assertEquals(familyA.getPay(), 15.00);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testABabysitterForFamilyAMakes45DollarsForWorking3Hours() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At8PM = LocalDateTime.of(2019, Month.JULY, 12, 20, 0);
        FamilyA familyA = new FamilyA();
        familyA.startTime(julyTwelfth2019At5PM);
        familyA.endTime(julyTwelfth2019At8PM);
        try {
            assertEquals(familyA.getPay(), 45.00);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
