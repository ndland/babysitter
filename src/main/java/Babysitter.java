import java.time.LocalDateTime;

public class Babysitter {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int fiveOClockPM = 17;
    private int fourOClockAM = 4;

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
        if ((fourOClockAM < endTime.getHour() && endTime.getHour() < fiveOClockPM) ||
        (fiveOClockPM > startTime.getHour() && startTime.getHour() > fourOClockAM)) {
            throw new Exception("Outside of working hours.");
        }
        if (startTime.isAfter(endTime)) { throw new Exception("Can't end work before you start."); }
    }
}
