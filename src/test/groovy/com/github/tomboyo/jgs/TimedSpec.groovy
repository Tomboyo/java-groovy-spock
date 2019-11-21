import spock.lang.Specification

import java.time.Clock
import java.time.Duration
import java.time.Instant

import com.github.tomboyo.jgs.Timed

class TimedSpec extends Specification {

  def "timed functions return their result"() {
    given:
    def unitOfWork = { -> 'result of computation' }
    def clock = Clock.systemDefaultZone()

    when:
    def result = Timed.time(unitOfWork, clock).getResult()

    then:
    result == 'result of computation'
  }

  def "timed functions return their run duration"() {
    given:
    def unitOfWork = { -> 'result of computation' }
    def clock = Mock(Clock)

    def start = Instant.ofEpochMilli(0)
    def expectedDuration = Duration.ofSeconds(1)
    clock.instant() >>> [ start, start.plus(expectedDuration) ]

    when:
    def actualDuration = Timed.time(unitOfWork, clock).getDuration()

    then:
    actualDuration == expectedDuration
  }
}
