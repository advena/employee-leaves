package pl.avra.employee;

public class EmployeeLeaveDays {

    int alreadyTakenDays = 0;

    void increaseWith(int days) {
        alreadyTakenDays += days;
    }


}
