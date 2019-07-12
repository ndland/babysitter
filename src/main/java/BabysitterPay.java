import java.time.LocalTime;

public class BabysitterPay {

    private String family;
    private LocalTime startTime;
    private double pay;

    public BabysitterPay(String family) {
        this.family = family;
    }

    public void startTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public double getPay() {
        return 15.00;
    }
}
