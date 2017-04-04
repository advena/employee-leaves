package pl.avra.employee;

public class EmployeeHireFactory {

    public static Employee hireFullTimeEmployeeWith26LeaveDays() {
        return Employee.hireEmployeeWith(Employment.LONG_TERM_EMPLOYMENT);
    }

    public static Employee hireFullTimeEmployeeWith20LeaveDays() {
        return Employee.hireEmployeeWith(Employment.SHORT_TERM_EMPLOYMENT);
    }

    public static Employee hireNonFullTimeEmployee() {
        return Employee.hireEmployeeWith(new EmploymentType() {

            //here goes some logic
            public boolean areLeaveDaysAvailable(int increasedLeaveDays) {
                return false;
            }
        });
    }

}
