package pl.avra.employee

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

class EmploymentDateSpec extends Specification {

    def NOW = LocalDate.parse("2017-02-01")
    def currentDateProvider = Mock(CurrentDateProvider)

    def setup() {
        currentDateProvider.now() >> NOW
    }

    @Unroll
    def "should return #expectedDays days for summary experience of #years years #months months and employment date as #date"() {
        given:
        def employmentDate = new EmployeeLeaveCalculator(LocalDate.parse(date), new Expirience(years, months))
        employmentDate.currnetDateProvider = currentDateProvider

        when:
        def availableDays = employmentDate.retrieveAllDays()

        then:
        availableDays == expextedDays

        where:
        years | months | date         || expextedDays
        10    | 0      | "2016-04-01" || 26
        7     | 0      | "2016-04-01" || 20
        10    | 0      | "2017-01-01" || 3
        10    | 0      | "2016-11-01" || 7
        8     | 0      | "2016-11-01" || 5
    }
}
