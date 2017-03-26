package pl.avra.employee;

public class TooManyDaysRequestedException extends RuntimeException {

    public TooManyDaysRequestedException(int leaveDays, int alreadyTakenLeaveDays, EmploymentType employmentType) {
        super(String.format("Employee has requested too many days for leave. %d requested days, already taken %d, " +
                        "employment type %s", leaveDays, alreadyTakenLeaveDays, employmentType));
    }
}
