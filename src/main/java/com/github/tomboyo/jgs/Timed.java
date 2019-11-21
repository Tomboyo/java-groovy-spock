package com.github.tomboyo.jgs;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public final class Timed<Result> {

  private final Result result;
  private final Duration duration;

  private Timed(
    Result result,
    Duration duration
  ) {
    this.result = result;
    this.duration = duration;
  }

  public Result getResult() {
    return result;
  }

  public Duration getDuration() {
    return duration;
  }

  public static <R> Timed<R> time(Supplier<R> unitOfWork, Clock clock) {
    Instant start = clock.instant();
    R result = unitOfWork.get();
    Instant end = clock.instant();
    return new Timed<>(result, Duration.between(start, end));
  }

}
