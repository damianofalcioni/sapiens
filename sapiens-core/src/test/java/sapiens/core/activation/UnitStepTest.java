package sapiens.core.activation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnitStepTest {

  @Test
  public void testUnitStep() {
    var unitStep = new UnitStep();

    assertResult(unitStep, -42d, 0d);
    assertResult(unitStep, -2d, 0d);
    assertResult(unitStep, -1d, 0d);
    assertResult(unitStep, 0d, 1d);
    assertResult(unitStep, 1d, 1d);
    assertResult(unitStep, 2d, 1d);
    assertResult(unitStep, 42d, 1d);
  }

  private void assertResult(ActivationFunction function, double input,
      double expected) {
    var result = function.activate(input);

    assertEquals(expected, result);
  }
}
