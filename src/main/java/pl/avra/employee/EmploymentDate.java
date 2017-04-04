package pl.avra.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmploymentDate {

    private static final int FULL_HOLIDAY_LIMIT = 120;
    private LocalDate employementDate;
    private Expirience expirience;
    CurrentDateProvider currnetDateProvider;

    EmploymentDate(LocalDate employementDate, Expirience expirience) {
        this.employementDate = employementDate;
        this.expirience = expirience;
    }

    public int retrieveAllDays() {
        int availableDays = calculateAvaliableDays();
        if(isTrial()) {
            return calcultateNonFullLeave(availableDays);
        } else {
            return availableDays;
        }
    }

    private int calcultateNonFullLeave(int availableDays) {
        return (int) Math.ceil((availableDays /12.0) * calculateCurrentWorkExperience());
    }

    private int calculateAvaliableDays() {
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
