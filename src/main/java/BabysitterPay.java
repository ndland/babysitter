import java.time.LocalTime;

public class BabysitterPay {

    private String family;
    private LocalTime startTime;
    private double pay;

    public BabysitterPay(String family) {
        this.family = family;
    }

    public void startTime(LocalTime startTime) throws Exception {
        LocalTime fiveOClock = LocalTime.parse("17:00");
        if (fiveOClock.compareTo(startTime) > 0) {
            throw new Exception("Outside of working hours.");
        }
        this.startTime = startTime;
    }

    public double getPay() {
        return 15.00;
    }
}
