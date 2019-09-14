package sapiens.core.activation;

public class UnitStep implements ActivationFunction {

  @Override
  public double activate(double value) {
    return value >= 0d ? 1d : 0d;
  }
}
