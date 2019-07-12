import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyATest {

    @Test
    public void testABabysitterForFamilyAMakes15DollarsAnHourBefore11PM() {
        LocalDateTime julyTwelfth2019At5PM = LocalDateTime.of(2019, Month.JULY, 12, 17, 0);
        LocalDateTime julyTwelfth2019At6PM = LocalDateTime.of(2019, Month.JULY, 12, 18, 0);
        FamilyA familyA = new FamilyA();
        familyA.startTime(julyTwelfth2019At5PM);
        familyA.endTime(julyTwelfth2019At6PM);
        assertEquals(familyA.getPay(), 15.00);
    }
}
