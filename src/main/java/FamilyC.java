import java.time.temporal.ChronoUnit;

public class FamilyC extends Babysitter {

    public double getPay() {
        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 21.00;
    }
}
