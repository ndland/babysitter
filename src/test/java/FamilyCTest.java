import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FamilyCTest {

    @Test
    public void aBabysitterMakes21DollarsForOneHourOfWorkBefore9PM() {
        FamilyC familyC = new FamilyC();
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        familyC.startTime(julyTwelfth2019At5PM);
        familyC.endTime(julyTwelfth2019At6PM);
        try {
            assertEquals(21.00, familyC.getPay());
        } catch (Exception e) {
            fail();
        }
    }
}
