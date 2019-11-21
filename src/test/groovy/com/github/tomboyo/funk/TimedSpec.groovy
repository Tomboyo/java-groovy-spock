import spock.lang.Specification

import java.time.Duration

import com.github.tomboyo.funk.Timed

class TimedSpec extends Specification {

  def "timed functions return their result"() {
    given:
    def unitOfWork = { -> 'result of computation' }

    when:
    def result = Timed.time(unitOfWork).getResult()

    then:
    result == 'result of computation'
  }
}
