import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;

public class FamilyB extends Babysitter {

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (getStartTime().toLocalTime().compareTo(LocalTime.of(22,0)) >= 0) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 8.0;
        }
        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 12.0;
    }
}
