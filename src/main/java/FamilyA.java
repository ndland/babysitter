import java.time.temporal.ChronoUnit;

public class FamilyA extends Babysitter {

    private double payBefore11PM = 15.00;

    public double getPay() throws Exception {
        super.isInWorkingHours();
        return ChronoUnit.HOURS.between(getStartTime(), getEndTime()) * payBefore11PM;
    }
}
