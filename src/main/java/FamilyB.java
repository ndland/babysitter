import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FamilyB extends Babysitter {

    private LocalTime tenPM = LocalTime.of(22, 0);

    public double getPay() throws Exception {
        super.isInWorkingHours();

        if (getStartTime().toLocalTime().compareTo(LocalTime.MIDNIGHT) == 0 || getEndTime().toLocalTime().compareTo(LocalTime.MIDNIGHT) == 0) {
            return (24 + ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime())) * 8.0;
        }

        if (getStartTime().toLocalTime().compareTo(tenPM) >= 0) {
            return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 8.0;
        }

        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 12.0;
    }
}
