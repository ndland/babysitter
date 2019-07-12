import java.time.LocalDateTime;

public class BabysitterPay {

    private String family;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double pay;

    public BabysitterPay(String family) {
        this.family = family;
    }

    public void startTime(LocalDateTime startTime) throws Exception {
        int fiveOClockPM = 17;
        if (fiveOClockPM > startTime.getHour() && startTime.getHour() > 4) {
            throw new Exception("Outside of working hours.");
        }
        this.startTime = startTime;
    }

    public void endTime(LocalDateTime endTime) throws Exception {
        int fourOClockAM = 4;
        if (fourOClockAM < endTime.getHour() && endTime.getHour() < 17) {
            throw new Exception("Outside of working hours.");
        }
        this.endTime = endTime;
    }

    public double getPay() throws Exception {
        if (startTime.isAfter(endTime)) {
            throw new Exception("Can't end work before you start.");
        }
        return 15.00;
    }
}
