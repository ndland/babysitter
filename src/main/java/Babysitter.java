import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Babysitter {

    protected int HOURS_IN_A_DAY = 24;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static final int FIVE_PM = 17;
    private static final int FOUR_AM = 4;

    public void startTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void endTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    protected void isInWorkingHours() throws Exception {
        if ((FOUR_AM < endTime.getHour() && endTime.getHour() < FIVE_PM) &&
                (FIVE_PM > startTime.getHour() && startTime.getHour() > FOUR_AM)) {
            throw new Exception("Outside of working hours.");
        }
        if (startTime.isAfter(endTime)) { throw new Exception("Can't end work before you start."); }
    }

    protected boolean didWorkThroughMidnight() {
        if (getStartTime().toLocalTime().equals(LocalTime.MIDNIGHT)
                || getEndTime().toLocalTime().equals(LocalTime.MIDNIGHT)) {
            return true;
        } else {
            return getEndTime().isAfter(getEndTime().toLocalDate().atStartOfDay())
                    && getStartTime().isBefore(getEndTime().toLocalDate().atStartOfDay());
        }
    }

    protected long calculateHoursBetween(LocalTime startTime, LocalTime endTime) {
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
