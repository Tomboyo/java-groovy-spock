import spock.lang.Specification

import static com.github.tomboyo.jgs.Length.Units.*

import com.github.tomboyo.jgs.Length

class LengthSpec extends Specification {

  def "conversion between units of measure"() {
    given:
    def actual = Length
      .of(from, input)
      .to(to)
      .asDouble()
    
    expect:
    Math.abs(actual - output) < 0.0001
    
    where:
    from   | to     | input   | output
    FEET   | FEET   | 1.0d    | 1.0d
    METERS | METERS | 1.0d    | 1.0d
    FEET   | METERS | 1.0d    | 0.3048d
    METERS | FEET   | 0.3048d | 1.0d
    FEET   | METERS | 2.0d    | 0.6096d
    FEET   | INCHES | 1.0d    | 12.0d
  }
}