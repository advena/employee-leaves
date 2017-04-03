package pl.avra.employee

import spock.lang.Specification

class EmployeeSpec extends Specification {

    def employmentType = Mock(EmploymentType)
    def LEAVE_DAYS = 4

    def "should allow to increase leave days number"() {
        given:
        employmentType.areLeaveDaysAvailable(_) >> true
        def employee = Employee.hireEmployeeWith(employmentType)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)

        then:
        noExceptionThrown()
    }

    def "should allow to increase leave days multiple times"() {
        given:
        employmentType.areLeaveDaysAvailable(_) >> true
        def employee = Employee.hireEmployeeWith(employmentType)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS)

        then:
        noExceptionThrown()
    }

    def "should not allow to increase leave days when requested days are too many"() {
        given:
        employmentType.areLeaveDaysAvailable(LEAVE_DAYS + 1) >> false
        employmentType.areLeaveDaysAvailable(LEAVE_DAYS) >> true

        def employee = Employee.hireEmployeeWith(employmentType)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS + 1)

        then:
        def ex = thrown TooManyDaysRequestedException
    }
}
