package pl.avra.employee;

public class Employee {

    private int maximumLeaveDays;
    private int alreadyTakenLeaveDays;

    private Employee(int maximumLeaveDays) {
        this.maximumLeaveDays = maximumLeaveDays;
        this.alreadyTakenLeaveDays = 0;
    }

    public static Employee hireEmployeeWith(int maximumLeaveDays) {
        return new Employee(maximumLeaveDays);
    }

    public void takeLeaveWith(int leaveDays) {
        int increasedLeaveDays = alreadyTakenLeaveDays + leaveDays;
        if(areRequestedDaysApplicable(increasedLeaveDays)) {
            this.alreadyTakenLeaveDays = increasedLeaveDays;
        } else {
            throw new TooManyDaysRequestedException(leaveDays, alreadyTakenLeaveDays, maximumLeaveDays);
        }
    }

    private boolean areRequestedDaysApplicable(int increasedLeaveDays) {
        return increasedLeaveDays <= maximumLeaveDays;
    }
}
