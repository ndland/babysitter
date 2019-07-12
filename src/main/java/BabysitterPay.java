import java.time.LocalTime;

public class BabysitterPay {

    private String family;
    private LocalTime startTime;
    private LocalTime endTime;
    private double pay;

    public BabysitterPay(String family) {
        this.family = family;
    }

    public void startTime(LocalTime startTime) throws Exception {
        LocalTime fiveOClockPM = LocalTime.parse("17:00");
        if (fiveOClockPM.compareTo(startTime) > 0) {
            throw new Exception("Outside of working hours.");
        }
        this.startTime = startTime;
    }

    public void endTime(LocalTime endTime) throws Exception {
        LocalTime fourOClockAM = LocalTime.parse("04:00");
        if (fourOClockAM.compareTo(endTime) < 0) {
            throw new Exception("Outside of working hours.");
        }
        this.endTime = endTime;
    }

    public double getPay() {
        return 15.00;
    }
}
