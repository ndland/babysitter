import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyA extends Babysitter {

    private LocalTime elevenPM = LocalTime.of(23, 0);
    private LocalTime fourAM = LocalTime.of(4, 0);
    private double payBefore11PM = 15.00;
    private double payAfter11PM = 20.00;
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();
        if (getEndTime().toLocalTime().compareTo(elevenPM) >= 0 || getEndTime().toLocalTime().compareTo(fourAM) <= 0) {
            if (getStartTime().toLocalTime() == elevenPM) {
                totalPay = (24 - ChronoUnit.HOURS.between(getEndTime().toLocalTime(), elevenPM)) * payAfter11PM +
                        (24 + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), LocalTime.MIDNIGHT)) * payBefore11PM;
            } else {
                totalPay = (24 - ChronoUnit.HOURS.between(getEndTime().toLocalTime(), elevenPM)) * payAfter11PM +
                        ChronoUnit.HOURS.between(getStartTime().toLocalTime(), elevenPM) * payBefore11PM;
            }
        } else {
            totalPay = calculatePayBefore11PM();
        }
        return totalPay;
    }

    private double calculatePayBefore11PM() {
        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * payBefore11PM;
    }
}
