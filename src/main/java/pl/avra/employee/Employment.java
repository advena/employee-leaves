package pl.avra.employee;

enum Employment implements EmploymentType{

    LONG_TERM_EMPLOYMENT(26),
    SHORT_TERM_EMPLOYMENT(20);

    private final int maximumLeaveDays;

    Employment(int days) {
        maximumLeaveDays = days;
    }

    public boolean areLeaveDaysAvailable(int increasedLeaveDays) {
        return increasedLeaveDays <= maximumLeaveDays;
    }
}
