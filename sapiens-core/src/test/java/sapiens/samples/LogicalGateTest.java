package sapiens.samples;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import sapiens.core.Network;

public class LogicalGateTest {

  private static final double[] zero = { 0d };
  private static final double[] one = { 1d };
  private static final double[] zeroZero = { 0d, 0d };
  private static final double[] zeroOne = { 0d, 1d };
  private static final double[] oneZero = { 1d, 0d };
  private static final double[] oneOne = { 1d, 1d };

  @Test
  public void testNotGate() {
    var not = LogicalGateFixtures.notGate();

    assertResult(not, zero, 1d);
    assertResult(not, one, 0d);
  }

  @Test
  public void testOrGate() {
    var or = LogicalGateFixtures.orGate();

    assertResult(or, zeroZero, 0d);
    assertResult(or, zeroOne, 1d);
    assertResult(or, oneZero, 1d);
    assertResult(or, oneOne, 1d);
  }

  @Test
  public void testAndGate() {
    var and = LogicalGateFixtures.andGate();

    assertResult(and, zeroZero, 0d);
    assertResult(and, zeroOne, 0d);
    assertResult(and, oneZero, 0d);
    assertResult(and, oneOne, 1d);
  }

  @Test
  public void testXorGate() {
    var xor = LogicalGateFixtures.xorGate();

    assertResult(xor, zeroZero, 0d);
    assertResult(xor, zeroOne, 1d);
    assertResult(xor, oneZero, 1d);
    assertResult(xor, oneOne, 0d);
  }

  private void assertResult(Network gate, double[] inputs, double expected) {
    var result = gate.process(inputs);

    assertThat(result.length, is(1));
    assertThat(result[0], is(expected));
  }
}
