package pl.avra.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeLeaveCalculator {

    private static final int FULL_HOLIDAY_LIMIT = 120;
    private LocalDate employementDate;
    private Expirience expirience;
    CurrentDateProvider currnetDateProvider;

    EmployeeLeaveCalculator(LocalDate employementDate, Expirience expirience) {
        this.employementDate = employementDate;
        this.expirience = expirience;
    }

    public int retrieveAllDays(LocalDate employementDate, Expirience expirience) {
        int availableDays = calculateAvailableDays();
        if(isTrial()) {
            return calculateNonFullLeave(availableDays);
        } else {
            return availableDays;
        }
    }

    private int calculateNonFullLeave(int availableDays) {
        return (int) Math.ceil((availableDays /12.0) * calculateCurrentWorkExperience());
    }

    private int calculateAvailableDays() {
        long currentWorkExperience = calculateCurrentWorkExperience();
        long allWorkExperience =  expirience.getMonths() + currentWorkExperience;
        if(allWorkExperience >= FULL_HOLIDAY_LIMIT) {
            return 26;
        } else {
            return 20;
        }
    }

    private long calculateCurrentWorkExperience() {
        return ChronoUnit.MONTHS.between(employementDate, currnetDateProvider.now());
    }

    private boolean isTrial() {
        return calculateCurrentWorkExperience() <= 6;
    }
}
