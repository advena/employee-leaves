package pl.avra.employee;

public class Employee {

    private EmploymentType employmentType;
    private int alreadyTakenLeaveDays;

    private EmploymentDate employmentDate;

    private Employee(EmploymentType employmentType) {
        this.employmentType = employmentType;
        this.alreadyTakenLeaveDays = 0;
    }

    static Employee hireEmployeeWith(EmploymentType employmentType) {
        return new Employee(employmentType);
    }

    public void takeLeaveWith(int leaveDays) {
        int increasedLeaveDays = alreadyTakenLeaveDays + leaveDays;
        if(employmentType.areLeaveDaysAvailable(increasedLeaveDays)) {
            this.alreadyTakenLeaveDays = increasedLeaveDays;
        } else {
            throw new TooManyDaysRequestedException(leaveDays, alreadyTakenLeaveDays, employmentType);
        }
    }
}
