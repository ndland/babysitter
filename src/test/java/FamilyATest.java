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
            assertEquals(15.00, familyA.getPay());
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
            assertEquals(45.00, familyA.getPay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testABabysitterForFamilyAMakes35DollarsForWorking1HourBefore11PMAnd1HourAfter11PM() {
        LocalDateTime julyTwelfth2019At11PM = LocalDateTime.of(2019, Month.JULY, 12, 23, 0);
        LocalDateTime julyThirteenth2019At12AM = LocalDateTime.of(2019, Month.JULY, 13, 0, 0);
        FamilyA familyA = new FamilyA();
        familyA.startTime(julyTwelfth2019At11PM);
        familyA.endTime(julyThirteenth2019At12AM);
        try {
            assertEquals(35, familyA.getPay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testABabysitterForFamilyAMakes190DollarsForWorkingAFullShiftForFamilyA() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyThirteenth2019At4AM = LocalDateTime.of(2019, Month.JULY, 13, 4, 0);
        FamilyA familyA = new FamilyA();
        familyA.startTime(julyTwelfth2019At5PM);
        familyA.endTime(julyThirteenth2019At4AM);
        try {
            assertEquals(190, familyA.getPay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}