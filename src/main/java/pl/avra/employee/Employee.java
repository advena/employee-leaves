package pl.avra.employee;

public class Employee {

    private EmploymentLeaveData employmentLeaveData;

    private EmploymentDate employmentDate;
    private EmployeeLeaveCalculator leaveCalculator;

    private Employee(EmploymentDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    static Employee hireEmployeeWith(EmploymentDate employmentDate) {
        return new Employee(employmentDate);
    }

    public void takeLeaveWith(int leaveDays) {
        if(employmentLeaveData.canTakeHoliday(leaveDays)) {
            employmentLeaveData.increaseHolidayDays(leaveDays);
        } else {
            throw new TooManyDaysRequestedException(leaveDays, alreadyTakenLeaveDays, employmentType);
        }
    }
}
