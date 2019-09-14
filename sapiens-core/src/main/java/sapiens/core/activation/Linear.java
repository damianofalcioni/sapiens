package sapiens.core.activation;

public class Linear implements ActivationFunction {

  public final double mu;

  public Linear(double mu) {
    this.mu = mu;
  }

  @Override
  public double activate(double value) {
    return mu * value;
  }
}
