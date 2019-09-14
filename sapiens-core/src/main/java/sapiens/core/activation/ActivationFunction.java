package sapiens.core.activation;

@FunctionalInterface
public interface ActivationFunction {

  public double activate(double value);
}
