package com.github.tomboyo.jgs;

public final class Length {
  public static enum Units {
    INCHES(.0254), // 1 inch = 0.0254 meters
    FEET(0.3048),  // 1 foot = 0.3048 meters
    METERS(1.0);   // 1 meter = 1 meter

    private double base;

    Units(double base) {
      this.base = base;
    }
  }

  private final Units units;
  private final double measure;

  private Length(Units units, double measure) {
    this.units = units;
    this.measure = measure;
  }

  public static Length of(Units units, double value) {
    return new Length(units, value);
  }

  public Length to(Units units) {
    return new Length(
      units,
      measure * this.units.base / units.base
    );
  }

  public double asDouble() {
    return measure;
  }
}