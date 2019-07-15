import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyC extends Babysitter {

    public static final LocalTime NINE_PM = LocalTime.of(21, 0);
    private double totalPay = 0.0;

    public double getPay() {
        if (getEndTime().isAfter(getEndTime().toLocalDate().atStartOfDay())
                && getStartTime().isBefore(getEndTime().toLocalDate().atStartOfDay())) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), NINE_PM) * 21.0
                    + (24 + ChronoUnit.HOURS.between(NINE_PM, getEndTime().toLocalTime())) * 15.00;
        }

        if (getStartTime().toLocalTime().compareTo(NINE_PM) <= 0) {
            totalPay += ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 21.00;
        }

        if (getEndTime().toLocalTime().isAfter(NINE_PM)
                || getStartTime().toLocalTime().isAfter(LocalTime.of(21, 0))) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 15.00;
        }
        return totalPay;
    }
}
