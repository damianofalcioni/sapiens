package sapiens.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
  public void testNandGate() {
    var nand = LogicalGateFixtures.nandGate();

    assertResult(nand, zeroZero, 1d);
    assertResult(nand, zeroOne, 1d);
    assertResult(nand, oneZero, 1d);
    assertResult(nand, oneOne, 0d);
  }

  @Test
  public void testNorGate() {
    var nor = LogicalGateFixtures.norGate();

    assertResult(nor, zeroZero, 1d);
    assertResult(nor, zeroOne, 0d);
    assertResult(nor, oneZero, 0d);
    assertResult(nor, oneOne, 0d);
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

    assertEquals(1, result.length);
    assertEquals(expected, result[0]);
  }
}
