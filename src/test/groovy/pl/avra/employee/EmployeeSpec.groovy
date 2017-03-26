package pl.avra.employee

import spock.lang.Specification

class EmployeeSpec extends Specification {

    def MAXIMUM_LEAVE_DAYS = 10
    def LEAVE_DAYS = 4

    def "should allow to increase leave days number"() {
        given:
        def employee = Employee.hireEmployeeWith(MAXIMUM_LEAVE_DAYS)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)

        then:
        noExceptionThrown()
    }

    def "should allow to increase leave days multiple times"() {
        given:
        def employee = Employee.hireEmployeeWith(MAXIMUM_LEAVE_DAYS)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS)

        then:
        noExceptionThrown()
    }

    def "should not allow to increase leave days when requested days are too many"() {
        given:
        def employee = Employee.hireEmployeeWith(MAXIMUM_LEAVE_DAYS)

        when:
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS)
        employee.takeLeaveWith(LEAVE_DAYS)

        then:
        def ex = thrown TooManyDaysRequestedException
        ex.message == "Employee has requested too many days for leave. ${LEAVE_DAYS} requested days, already taken ${LEAVE_DAYS * 2}, " +
                "maximum employee leave days are ${MAXIMUM_LEAVE_DAYS}"
    }
}
