import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FamilyCTest {

    private FamilyC familyC;

    @BeforeEach
    public void setUp() {
        familyC = new FamilyC();
    }

    @Test
    public void aBabysitterMakes21DollarsForOneHourOfWorkBefore9PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        familyC.startTime(julyTwelfth2019At5PM);
        familyC.endTime(julyTwelfth2019At6PM);
        try {
            assertEquals(21.00, familyC.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void aBabysitterMakes96DollarsForWorkingBeforeBefore9PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At9PM = LocalDateTime.of(2019, Month.JULY, 12, 21, 0);
        familyC.startTime(julyTwelfth2019At5PM);
        familyC.endTime(julyTwelfth2019At9PM);
        try {
            assertEquals(84.00, familyC.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void aBabysitterMakes15DollarsForWorkingOneHourAfter9PM() {
        LocalDateTime julyTwelfth2019At9PM = LocalDateTime.of(2019, Month.JULY, 12, 21, 0);
        LocalDateTime julyTwelfth2019At10PM = LocalDateTime.of(2019, Month.JULY, 12, 22, 0);
        familyC.startTime(julyTwelfth2019At9PM);
        familyC.endTime(julyTwelfth2019At10PM);
        try {
            assertEquals(15.00, familyC.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void aBabysitterMakes105DollarsForWorkingFrom9PMTo4AM() {
        LocalDateTime julyTwelfth2019At9PM = LocalDateTime.of(2019, Month.JULY, 12, 21, 0);
        LocalDateTime julyThirteenthAt4AM = LocalDateTime.of(2019, Month.JULY, 13, 4, 0);
        familyC.startTime(julyTwelfth2019At9PM);
        familyC.endTime(julyThirteenthAt4AM);
        try {
            assertEquals(105.00, familyC.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void aBabysitterMakes189DollarsForWorkingAFullShift() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyThirteenthAt4AM = LocalDateTime.of(2019, Month.JULY, 13, 4, 0);
        familyC.startTime(julyTwelfth2019At5PM);
        familyC.endTime(julyThirteenthAt4AM);
        try {
            assertEquals(189.00, familyC.calculatePay());
        } catch (Exception e) {
            fail();
        }
    }
}
