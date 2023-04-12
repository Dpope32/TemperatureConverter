import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.printf("Temperature in Celsius: %.2f\n", celsius);
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public class TemperatureConverterTest {

    public static void main(String[] args) {
        testFahrenheitToCelsius();
    }

    public static void testFahrenheitToCelsius() {
        double[][] testCases = {
            {32, 0},
            {212, 100},
            {-40, -40},
        };

        for (double[] testCase : testCases) {
            double fahrenheit = testCase[0];
            double expectedCelsius = testCase[1];
            double actualCelsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);

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

}
