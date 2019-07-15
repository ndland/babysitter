import java.time.LocalTime;

public class FamilyB extends Babysitter {

    private static final double BASE_PAY_BEFORE_10PM = 12.0;
    private static final double PAY_BETWEEN_10PM_AND_12AM = 8.0;
    private static final double PAY_AFTER_MIDNIGHT = 16.0;
    private static final LocalTime TEN_PM = LocalTime.of(22, 0);
    private static final LocalTime FIVE_PM = LocalTime.of(17, 0);
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (didWorkThroughMidnight()) {
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), TEN_PM) * BASE_PAY_BEFORE_10PM
                    + (HOURS_IN_A_DAY + calculateHoursBetween(TEN_PM, LocalTime.MIDNIGHT)) * PAY_BETWEEN_10PM_AND_12AM
                    + calculateHoursBetween(LocalTime.MIDNIGHT, getEndTime().toLocalTime()) * PAY_AFTER_MIDNIGHT;
            return totalPay;
        }
        if (isStartTimeBetween5PMAnd10PM()) {
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * BASE_PAY_BEFORE_10PM;
        }

        if (isStartTimeBetween10PMand12AM()) {
            if (isStartTimeOrEndTimeEqualToMidnight()) {
                return (HOURS_IN_A_DAY + calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime())) * PAY_BETWEEN_10PM_AND_12AM;
            }
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_BETWEEN_10PM_AND_12AM;
        }

        if (isStartTimeAfterMidnightAndBefore4AM()) {
            totalPay += calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_AFTER_MIDNIGHT;
        }

        return totalPay;
    }

    private boolean isStartTimeBetween10PMand12AM() {
        return getStartTime().toLocalTime().compareTo(TEN_PM) >= 0
                && getStartTime().toLocalTime().compareTo(LocalTime.from(getEndTime().toLocalDate().atStartOfDay())) > 0;
    }

    private boolean isStartTimeBetween5PMAnd10PM() {
        return getStartTime().toLocalTime().compareTo(FIVE_PM) >= 0
                && getStartTime().toLocalTime().compareTo(TEN_PM) < 0;
    }

    private boolean isStartTimeOrEndTimeEqualToMidnight() {
        return getStartTime().toLocalTime().equals(LocalTime.MIDNIGHT)
                || getEndTime().toLocalTime().equals(LocalTime.MIDNIGHT);
    }

    private boolean isStartTimeAfterMidnightAndBefore4AM() {
        return getStartTime().isAfter(getStartTime().toLocalDate().atStartOfDay())
                && getStartTime().isBefore(getStartTime().toLocalDate().atStartOfDay().plusHours(4));
    }
}
