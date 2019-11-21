package com.github.tomboyo.funk;

import java.util.function.Supplier;

public final class Timed<Result> {

  private final Result result;

  private Timed(
    Result result
  ) {
    this.result = result;
  }

  public Result getResult() {
    return result;
  }

  public static <R> Timed<R> time(Supplier<R> unitOfWork) {
    return new Timed<>(unitOfWork.get());
  }

}
