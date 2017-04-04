package pl.avra.employee

import spock.lang.Specification
import spock.lang.Unroll

class ExpirienceSpec extends Specification {

    @Unroll
    def "should return summary #months months for given #months months and #years years"() {
        when:
        def allMonths = new Expirience(years, months).getMonths()

        then:
        allMonths == expextedMonths

        where:
        years | months || expextedMonths
        0     | 7      || 7
        1     | 0      || 12
        1     | 11     || 23
    }
}
