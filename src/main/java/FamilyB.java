import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyB extends Babysitter {

    private static final double BASE_PAY_BEFORE_10PM = 12.0;
    private static final double PAY_BETWEEN_10PM_AND_12AM = 8.0;
    private static final LocalTime TEN_PM = LocalTime.of(22, 0);
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (getEndTime().isAfter(getEndTime().toLocalDate().atStartOfDay())
                && getStartTime().isBefore(getEndTime().toLocalDate().atStartOfDay())) {
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), LocalTime.of(22, 0)) * BASE_PAY_BEFORE_10PM
                    + (24 + ChronoUnit.HOURS.between(LocalTime.of(22, 0), LocalTime.MIDNIGHT)) * PAY_BETWEEN_10PM_AND_12AM
            + ChronoUnit.HOURS.between(LocalTime.MIDNIGHT, getEndTime().toLocalTime()) * 16.0;
            return totalPay;
        }

        if (isStartTimeBetween5PMAnd10PM()) {
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * BASE_PAY_BEFORE_10PM;
        }

        if (isStartTimeBetween10PMand12AM()) {
            if (isStartTimeOrEndTimeEqualToMidnight()) {
                return (24 + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime())) * PAY_BETWEEN_10PM_AND_12AM;
            }
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_BETWEEN_10PM_AND_12AM;
        }

        if (isStartTimeAfterMidnightAndBefore4AM()) {
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 16.00;
        }

        return totalPay;
    }

    private boolean isStartTimeBetween10PMand12AM() {
        return getStartTime().toLocalTime().compareTo(LocalTime.of(22, 0)) >= 0
                && getStartTime().toLocalTime().compareTo(LocalTime.from(getEndTime().toLocalDate().atStartOfDay())) > 0;
    }

    private boolean isStartTimeBetween5PMAnd10PM() {
        return getStartTime().toLocalTime().compareTo(LocalTime.of(17, 0)) >= 0
                && getStartTime().toLocalTime().compareTo(LocalTime.of(22, 0)) < 0;
    }

    private boolean isStartTimeBetween10PMAndMidnight() {
        return getStartTime().toLocalTime().compareTo(TEN_PM) >= 0;
    }

    private boolean isStartTimeOrEndTimeEqualToMidnight() {
        return getStartTime().toLocalTime().equals(LocalTime.MIDNIGHT)
                || getEndTime().toLocalTime().equals(LocalTime.MIDNIGHT);
    }

    private boolean isStartTimeAfterMidnightAndBefore4AM() {
        return getStartTime().isAfter(getStartTime().toLocalDate().atStartOfDay()) && getStartTime().isBefore(getStartTime().toLocalDate().atStartOfDay().plusHours(4));
    }
}
