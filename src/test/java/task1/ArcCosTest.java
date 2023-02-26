package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ArcCosTest {
    double delta = 0.1;
    double deltaHighPrecision = 0.01;

    @ParameterizedTest
    @ValueSource(doubles = {-100, -10, -1.5, -1.000001, 1.000001, 1.5, 10, 100})
    public void xNotAllowedTest(double value) {
        Assertions.assertEquals(Double.NaN, ArcCos.arccos(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1})
    public void xLimitValuesTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.999999, -0.5, -0.000001})
    public void xNegativeTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.999999, 0.5, 0.000001})
    public void xPositiveTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1})
    public void xLimitValuesHighPrecisionTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), deltaHighPrecision);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.999999, -0.5, -0.000001})
    public void xNegativeHighPrecisionTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), deltaHighPrecision);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.999999, 0.5, 0.000001})
    public void xPositiveHighPrecisionTest(double value) {
        Assertions.assertEquals(Math.acos(value), ArcCos.arccos(value), deltaHighPrecision);
    }
}
