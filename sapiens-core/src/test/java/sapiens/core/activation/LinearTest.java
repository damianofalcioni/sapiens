package sapiens.core.activation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinearTest {

  @Test
  public void testIdentity() {
    var linear = new Linear(1d);

    assertResult(linear, -42d, -42d);
    assertResult(linear, -2d, -2d);
    assertResult(linear, -1d, -1d);
    assertResult(linear, 0d, 0d);
    assertResult(linear, 1d, 1d);
    assertResult(linear, 2d, 2d);
    assertResult(linear, 42d, 42d);
  }

  @Test
  public void testDouble() {
    var linear = new Linear(2d);

    assertResult(linear, -42d, -84d);
    assertResult(linear, -2d, -4d);
    assertResult(linear, -1d, -2d);
    assertResult(linear, 0d, 0d);
    assertResult(linear, 1d, 2d);
    assertResult(linear, 2d, 4d);
    assertResult(linear, 42d, 84d);
  }

  private void assertResult(ActivationFunction function, double input,
      double expected) {
    var result = function.activate(input);

    assertEquals(expected, result);
  }
}
