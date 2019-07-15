import java.time.LocalTime;

public class FamilyA extends Babysitter {

    private static final LocalTime ELEVEN_PM = LocalTime.of(23, 0);
    private static final double PAY_BEFORE_11_PM = 15.00;
    private static final double PAY_AFTER_11_PM = 20.00;
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (didWorkThroughMidnight()) {
            return calculateHoursBetween(getStartTime().toLocalTime(), ELEVEN_PM) * PAY_BEFORE_11_PM
                    + (HOURS_IN_A_DAY + calculateHoursBetween(ELEVEN_PM, getEndTime().toLocalTime())) * PAY_AFTER_11_PM;
        }

        if (didWorkBefore11PM()) {
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_BEFORE_11_PM;
        }

        if (didWorkAfter11PM()) {
            return calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_AFTER_11_PM;

        }
        return totalPay;
    }

    private boolean didWorkBefore11PM() {
        return getStartTime().toLocalTime().compareTo(ELEVEN_PM) <= 0;
    }

    private boolean didWorkAfter11PM() {
        return getEndTime().toLocalTime().compareTo(ELEVEN_PM) >= 0;
    }
}
