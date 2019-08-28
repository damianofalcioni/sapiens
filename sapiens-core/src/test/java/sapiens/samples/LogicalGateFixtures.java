package sapiens.samples;

import sapiens.core.Layer;
import sapiens.core.Network;
import sapiens.core.Neuron;

public class LogicalGateFixtures {

  public static Network notGate() {
    var neuron = new Neuron(new double[] { -1d }, 0d);
    var layer = new Layer(new Neuron[] { neuron });
    return new Network(new Layer[] { layer });
  }

  public static Network orGate() {
    var neuron = new Neuron(new double[] { 1d, 1d }, 1d);
    var layer = new Layer(new Neuron[] { neuron });
    return new Network(new Layer[] { layer });
  }

  public static Network andGate() {
    var neuron = new Neuron(new double[] { 1d, 1d }, 2d);
    var layer = new Layer(new Neuron[] { neuron });
    return new Network(new Layer[] { layer });
  }

  public static Network nandGate() {
    var neuron = new Neuron(new double[] { -1d, -1d }, -1.5d);
    var layer = new Layer(new Neuron[] { neuron });
    return new Network(new Layer[] { layer });
  }

  public static Network xorGate() {
    var neuron1 = new Neuron(new double[] { 1d, 1d }, 1d);
    var neuron2 = new Neuron(new double[] { -1d, -1d }, -1d);
    var neuron3 = new Neuron(new double[] { 1d, 1d }, 2d);

    var layer1 = new Layer(new Neuron[] { neuron1, neuron2 });
    var layer2 = new Layer(new Neuron[] { neuron3 });

    return new Network(new Layer[] { layer1, layer2 });
  }
}
