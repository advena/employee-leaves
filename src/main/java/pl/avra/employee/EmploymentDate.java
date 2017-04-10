package pl.avra.employee;

import java.time.LocalDate;

public class EmploymentDate {

    private LocalDate employmentDate;
    private Expirience expirience;

    public EmploymentDate(LocalDate date, int year, int month) {
        this.employmentDate = date;
        expirience = new Expirience(year, month);
    }

}
