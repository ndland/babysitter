import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyC extends Babysitter {

    public static final LocalTime NINE_PM = LocalTime.of(21, 0);
    public static final double PAY_AFTER_9PM = 21.0;
    public static final double BASE_PAY = 15.00;
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (didWorkThroughMidnight()) {
            return calculateHoursBetween(getStartTime().toLocalTime(), NINE_PM) * PAY_AFTER_9PM
                    + (HOURS_IN_A_DAY + calculateHoursBetween(NINE_PM, getEndTime().toLocalTime())) * BASE_PAY;
        }

        if (isStartTime9PMOrBefore()) {
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_AFTER_9PM;
        }

        if (didWorkAfter9PM()) {
            return calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * BASE_PAY;
        }
        return totalPay;
    }

    private boolean isStartTime9PMOrBefore() {
        return getStartTime().toLocalTime().compareTo(NINE_PM) <= 0;
    }

    private boolean didWorkAfter9PM() {
        return getEndTime().toLocalTime().isAfter(NINE_PM);
    }
}
