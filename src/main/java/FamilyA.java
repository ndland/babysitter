import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyA extends Babysitter {

    private static LocalTime ELEVEN_PM = LocalTime.of(23, 0);
    private static LocalTime FOUR_AM = LocalTime.of(4, 0);
    private double PAY_BEFORE_11_PM = 15.00;
    private double PAY_AFTER_11_PM = 20.00;
    private double totalPay = 0.0;

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (isEndTimeAfter11PMOrBefore4AM()) {
            if (getStartTime().toLocalTime() == ELEVEN_PM) {
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
        return getEndTime().toLocalTime().compareTo(ELEVEN_PM) >= 0
                || getEndTime().toLocalTime().compareTo(FOUR_AM) <= 0;
    }

    private void calculatePayBeforeAndAfter11PM() {
        totalPay = (HOURS_IN_A_DAY - calculateHoursBetween(getEndTime().toLocalTime(), ELEVEN_PM)) * PAY_AFTER_11_PM +
                calculateHoursBetween(getStartTime().toLocalTime(), ELEVEN_PM) * PAY_BEFORE_11_PM;
    }

    private void calculatePayWhenStartTimeIs11PM() {
        totalPay = (HOURS_IN_A_DAY - calculateHoursBetween(getEndTime().toLocalTime(), ELEVEN_PM)) * PAY_AFTER_11_PM +
                (HOURS_IN_A_DAY + calculateHoursBetween(getStartTime().toLocalTime(), LocalTime.MIDNIGHT)) * PAY_BEFORE_11_PM;
    }

    private void calculatePayBefore11PM() {
        totalPay = calculateHoursBetween(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * PAY_BEFORE_11_PM;
    }

}
