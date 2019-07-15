import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FamilyBTest {

    private FamilyB familyB;

    @BeforeEach
    public void setUp() {
        familyB = new FamilyB();
    }

    @Test
    public void testABabysitterForFamilyBMakes12DollarsForOneHourOfWorkBefore10PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        familyB.startTime(julyTwelfth2019At5PM);
        familyB.endTime(julyTwelfth2019At6PM);
        try {
            assertEquals(12.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes36DollarsForWorking3Hours() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At8PM = LocalDateTime.of(2019, Month.JULY, 12, 20, 0);
        familyB.startTime(julyTwelfth2019At5PM);
        familyB.endTime(julyTwelfth2019At8PM);
        try {
            assertEquals(36.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes8DollarsForWorking1HourBetween10PMAnd12AM() {
        LocalDateTime julyTwelfth2019At10PM = LocalDateTime.of(2019, Month.JULY, 12, 22, 0);
        LocalDateTime julyTwelfth2019At11PM = LocalDateTime.of(2019, Month.JULY, 12, 23, 0);
        familyB.startTime(julyTwelfth2019At10PM);
        familyB.endTime(julyTwelfth2019At11PM);
        try {
            assertEquals(8.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes16DollarsForWorking2HoursBetween10PMAnd12AM() {
        LocalDateTime julyTwelfth2019At10PM = LocalDateTime.of(2019, Month.JULY, 12, 22, 0);
        LocalDateTime julyThirteenth2019At12AM = LocalDateTime.of(2019, Month.JULY, 13, 0, 0);
        familyB.startTime(julyTwelfth2019At10PM);
        familyB.endTime(julyThirteenth2019At12AM);
        try {
            assertEquals(16.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes16DollarsForWorking1HourAfter12AM() {
        LocalDateTime julyTwelfth2019At1AM = LocalDateTime.of(2019, Month.JULY, 12, 1, 0);
        LocalDateTime julyTwelfth2019At2AM= LocalDateTime.of(2019, Month.JULY, 12, 2, 0);
        familyB.startTime(julyTwelfth2019At1AM);
        familyB.endTime(julyTwelfth2019At2AM);
        try {
            assertEquals(16.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testABabysitterForFamilyBMakes44DollarsForWorkingFrom9PMTo1AM() {
        LocalDateTime julyEleventhAt9PM = LocalDateTime.of(2019, Month.JULY, 11, 21, 0);
        LocalDateTime julyTwelfth2019At1AM= LocalDateTime.of(2019, Month.JULY, 12, 1, 0);
        familyB.startTime(julyEleventhAt9PM);
        familyB.endTime(julyTwelfth2019At1AM);
        try {
            assertEquals(44.00, familyB.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }
}
