import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyC extends Babysitter {

    public static final LocalTime NINE_PM = LocalTime.of(21, 0);
    public static final double PAY_AFTER_9PM = 21.0;
    public static final double BASE_PAY = 15.00;
    private double totalPay = 0.0;

    public double getPay() {
        if (didWorkThroughMidnight()) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), NINE_PM) * PAY_AFTER_9PM
                    + (24 + ChronoUnit.HOURS.between(NINE_PM, getEndTime().toLocalTime())) * BASE_PAY;
        }

        if (isStartTime9PMOrBefore()) {
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_AFTER_9PM;
        }

        if (didWorkAfter9PM()) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * BASE_PAY;
        }
        return totalPay;
    }

    private boolean didWorkThroughMidnight() {
        return getEndTime().isAfter(getEndTime().toLocalDate().atStartOfDay())
                && getStartTime().isBefore(getEndTime().toLocalDate().atStartOfDay());
    }

    private boolean isStartTime9PMOrBefore() {
        return getStartTime().toLocalTime().compareTo(NINE_PM) <= 0;
    }

    private boolean didWorkAfter9PM() {
        return getEndTime().toLocalTime().isAfter(NINE_PM);
    }
}
