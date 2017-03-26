package pl.avra.employee;

public class TooManyDaysRequestedException extends RuntimeException {

    public TooManyDaysRequestedException(int leaveDays, int alreadyTakenLeaveDays, int maximumLeaveDays) {
        super(String.format("Employee has requested too many days for leave. %d requested days, already taken %d, " +
                        "maximum employee leave days are %d", leaveDays, alreadyTakenLeaveDays, maximumLeaveDays));
    }
}
