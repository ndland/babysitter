import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BabysitterPayTest {

    @Test
    public void testABabysitterForFamilyAMakes15DollarsAnHourBefore11PM() {
        BabysitterPay babysitterPay = new BabysitterPay("Family A");
        babysitterPay.startTime(LocalTime.parse("17:00"));
        assertEquals(babysitterPay.getPay(), 15.00);
    }
}
