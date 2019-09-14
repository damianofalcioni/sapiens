package sapiens.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sapiens.core.Layer;
import sapiens.core.Network;
import sapiens.core.Neuron;
import sapiens.core.activation.Linear;

public class Aproximator2dTest {

  @Test
  public void testAproximator() {
    var aproximator = aproximator();

    assertResult(aproximator, -2d, 0d);
    assertResult(aproximator, 0d, 7d);
    assertResult(aproximator, 2d, 7d);
    assertResult(aproximator, 4d, 3d);
    assertResult(aproximator, 6d, 3d);
    assertResult(aproximator, 8d, 1d);
    assertResult(aproximator, 10d, 1d);
    assertResult(aproximator, 12d, 0d);
    assertResult(aproximator, 14d, 0d);
  }

  private Network aproximator() {
    var neuron11 = new Neuron(new double[] { 1d }, 0d);
    var neuron12 = new Neuron(new double[] { 1d }, -4d);
    var neuron13 = new Neuron(new double[] { 1d }, -8d);
    var neuron14 = new Neuron(new double[] { 1d }, -12d);

    var neuron21 = new Neuron(new double[] { 1d, -1d, 0d, 0d }, -1d);
    var neuron22 = new Neuron(new double[] { 0d, 1d, -1d, 0d, }, -1d);
    var neuron23 = new Neuron(new double[] { 0d, 0d, 1d, -1d }, -1d);

    var neuron31 = new Neuron(new double[] { 7d, 3d, 1d }, 0d, new Linear(1d));

    var layer1 = new Layer(
        new Neuron[] { neuron11, neuron12, neuron13, neuron14 });
    var layer2 = new Layer(new Neuron[] { neuron21, neuron22, neuron23 });
    var layer3 = new Layer(new Neuron[] { neuron31 });

    return new Network(new Layer[] { layer1, layer2, layer3 });
  }

  private void assertResult(Network network, double input, double expected) {
    var inputs = new double[] { input };
    var result = network.process(inputs);

    assertEquals(1, result.length);
    assertEquals(expected, result[0]);
  }
}
