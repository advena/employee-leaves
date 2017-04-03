package pl.avra.employee

import spock.lang.Specification
import spock.lang.Unroll

class EmploymentTypeSpec extends Specification {

    @Unroll
    def "should return #expected for #days days at #employmentType"() {
        when:
        def result = employmentType.areLeaveDaysAvailable(days)

        then:
        result == expected

        where:
        employmentType                   | days || expected
        Employment.LONG_TERM_EMPLOYMENT  | 26   || true
        Employment.LONG_TERM_EMPLOYMENT  | 27   || false
        Employment.LONG_TERM_EMPLOYMENT  | 20   || true
        Employment.SHORT_TERM_EMPLOYMENT | 26   || false
        Employment.SHORT_TERM_EMPLOYMENT | 21   || false
        Employment.SHORT_TERM_EMPLOYMENT | 20   || true
        Employment.SHORT_TERM_EMPLOYMENT | 19   || true

    }
}
