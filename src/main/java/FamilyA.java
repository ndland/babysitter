import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyA extends Babysitter {

    private LocalTime elevenPM = LocalTime.of(23, 0);
    private LocalTime fourAM = LocalTime.of(4, 0);
    private double payBefore11PM = 15.00;
    private double payAfter11PM = 20.00;
    private double totalPay = 0.0;
    private int HOURS_IN_A_DAY = 24;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (isEndTimeAfter11PMOrBefore4AM()) {
            if (getStartTime().toLocalTime() == elevenPM) {
                calculatePayWhenStartTimeIs11PM();
            } else {
                calculatePayBeforeAndAfter11PM();
            }
        } else {
            calculatePayBefore11PM();
        }
        return totalPay;
    }

    private boolean isEndTimeAfter11PMOrBefore4AM() {
        return getEndTime().toLocalTime().compareTo(elevenPM) >= 0 || getEndTime().toLocalTime().compareTo(fourAM) <= 0;
    }

    private void calculatePayBeforeAndAfter11PM() {
        totalPay = (HOURS_IN_A_DAY - ChronoUnit.HOURS.between(getEndTime().toLocalTime(), elevenPM)) * payAfter11PM +
                ChronoUnit.HOURS.between(getStartTime().toLocalTime(), elevenPM) * payBefore11PM;
    }

    private void calculatePayWhenStartTimeIs11PM() {
        totalPay = (HOURS_IN_A_DAY - ChronoUnit.HOURS.between(getEndTime().toLocalTime(), elevenPM)) * payAfter11PM +
                (HOURS_IN_A_DAY + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), LocalTime.MIDNIGHT)) * payBefore11PM;
    }

    private void calculatePayBefore11PM() {
        totalPay = ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * payBefore11PM;
    }
}
