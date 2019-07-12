import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyA extends Babysitter {

    private LocalTime elevenPM = LocalTime.of(23, 0);
    private double payBefore11PM = 15.00;
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();
        if (getEndTime().toLocalTime().compareTo(LocalTime.MIDNIGHT)<= 0) {
            totalPay = (24 - ChronoUnit.HOURS.between(getEndTime().toLocalTime(), elevenPM)) * 20.00 +
                    (24l + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime())) * payBefore11PM;
        } else {
            totalPay = ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * payBefore11PM;
        }
        return totalPay;
    }
}
