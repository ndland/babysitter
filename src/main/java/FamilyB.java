import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyB extends Babysitter {

    private static final double BASE_PAY_BEFORE_10PM = 12.0;
    private static final double PAY_BETWEEN_10PM_AND_12AM = 8.0;
    private static final LocalTime TEN_PM = LocalTime.of(22, 0);

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (isStartTimeOrEndTimeEqualToMidnight()) {
            return (24 + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime())) * PAY_BETWEEN_10PM_AND_12AM;
        }

        if (isStartTimeAfterMidnightAndBefore4AM()) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 16.00;
        }

        if (isStartTimeBetween10PMAndMidnight()) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_BETWEEN_10PM_AND_12AM;
        }

        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * BASE_PAY_BEFORE_10PM;
    }

    private boolean isStartTimeBetween10PMAndMidnight() {
        return getStartTime().toLocalTime().compareTo(TEN_PM) >= 0;
    }

    private boolean isStartTimeOrEndTimeEqualToMidnight() {
        return getStartTime().toLocalTime().equals(LocalTime.MIDNIGHT) || getEndTime().toLocalTime().equals(LocalTime.MIDNIGHT);
    }

    private boolean isStartTimeAfterMidnightAndBefore4AM() {
        return getStartTime().isAfter(getStartTime().toLocalDate().atStartOfDay()) && getStartTime().isBefore(getStartTime().toLocalDate().atStartOfDay().plusHours(4));
    }
}
