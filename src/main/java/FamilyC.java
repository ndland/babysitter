import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyC extends Babysitter {

    public double getPay() {
        if (getEndTime().toLocalTime().isAfter(LocalTime.of(21, 0))
                || getStartTime().toLocalTime().isAfter(LocalTime.of(21, 0))) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 15.00;
        }
        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 21.00;
    }
}
