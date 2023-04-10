public class Test {


////Mock Unit test
    public interface ITemperatureConverter {
        double fahrenheitToCelsius(double fahrenheit);
    }

    public static class MockTemperatureConverter implements ITemperatureConverter {
        @Override
        public double fahrenheitToCelsius(double fahrenheit) {
            if (fahrenheit == 32) {
                return 0; 
                //freezing point of water
            } else if (fahrenheit == 212) {
                return 100;
                //boiling point of water
            } else if (fahrenheit == -40) {
                return -40;
            } else if (fahrenheit == 99.5) {
                return 37.5;
            }
                else { throw new IllegalArgumentException("Unexpected input: " + fahrenheit);
            }
        }
    }
///Normal Unit Tests
    public static void main(String[] args) {
        testFahrenheitToCelsius();
    }

    public static void testFahrenheitToCelsius() {
        double[][] testCases = {
            {32, 0},
            {212, 100},
            {-40, -40},
            {99.5, 37.5}
        };

        ITemperatureConverter mockTemperatureConverter = new MockTemperatureConverter();

        for (double[] testCase : testCases) {
            double fahrenheit = testCase[0];
            double expectedCelsius = testCase[1];
            double actualCelsius = mockTemperatureConverter.fahrenheitToCelsius(fahrenheit);

            if (Math.abs(actualCelsius - expectedCelsius) > 0.01) {
                System.out.printf(
                    "Test failed: Expected %.2f Celsius for %.2f Fahrenheit, but got %.2f Celsius.%n",
                    expectedCelsius, fahrenheit, actualCelsius
                );
            } else {
                System.out.printf(
                    "Test passed: %.2f Fahrenheit correctly converted to %.2f Celsius.%n",
                    fahrenheit, actualCelsius
                );
            }
        }
    }
}


