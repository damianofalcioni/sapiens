package sapiens.core;

import sapiens.core.activation.ActivationFunction;
import sapiens.core.activation.UnitStep;

public class Neuron {

  private final double[] weights;

  private final double bias;

  private final ActivationFunction activationFunction;

  public Neuron(double[] weigths, double bias) {
    this(weigths, bias, new UnitStep());
  }

  public Neuron(double[] weigths, double bias,
      ActivationFunction activationFunction) {
    this.weights = weigths;
    this.bias = bias;
    this.activationFunction = activationFunction;
  }

  public double process(double[] inputs) {
    var netValue = 0d;

    for (var i = 0; i < weights.length; i++) {
      netValue += weights[i] * inputs[i];
    }
    netValue += bias;

    return activationFunction.activate(netValue);
  }
}
