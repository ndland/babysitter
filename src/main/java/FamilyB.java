import java.time.temporal.ChronoUnit;

public class FamilyB extends Babysitter {

    public double getPay() throws Exception {
        super.isInWorkingHours();

        return ChronoUnit.HOURS.between(getStartTime().toLocalTime(), getEndTime().toLocalTime()) * 12.0;
    }
}
